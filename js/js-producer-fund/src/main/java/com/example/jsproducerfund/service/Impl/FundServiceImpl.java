package com.example.jsproducerfund.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerfund.config.Sender;
import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.*;
import com.example.jsproducerfund.service.FundService;
import com.example.jsproducerfund.util.Job.QuartzJobFactory;
import com.example.jsproducerfund.util.Job.QuartzManager;
import com.example.jsproducerfund.util.Job.ScheduleJob;
import com.example.jsproducerfund.util.RiskRatingAlgorithm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 15:06
 */
@Service
public class FundServiceImpl implements FundService {

    @Autowired
    private FundDao fundDao;

    private Integer pageNum = 1;

    @Autowired
    private QuartzManager quartzManager;

    @Autowired
    private Sender sender;

    @Override
    public String showNewFunds() {
        List<FundInfo> list = fundDao.findNewFunds();
        //分页查询 每页显示10行数据
        PageHelper.startPage(pageNum, 10);
        PageInfo<FundInfo> fundPageInfo = new PageInfo<>(list);
        return JSON.toJSONString(fundPageInfo.getList());
    }

    @Override
    public String showFunds(String fundType) {
        Performance performance = new Performance();
        performance.setFund_type(fundType);
        List<Performance> list = fundDao.findAll(performance);
        //分页查询 每页显示10行数据
        PageHelper.startPage(pageNum,5);
        PageInfo<Performance> fundPageInfo = new PageInfo<>(list);
        return JSON.toJSONString(fundPageInfo.getList());
    }

    @Override
    public String selFunds() {
        List<Performance> performanceList = fundDao.findAll(null);
        if(performanceList.size() <= 0){
            return "未查询到任何信息";
        }
        return JSON.toJSONString(performanceList);
    }

    @Override
    public String showFundDetails(String fundName) {
        if(fundName == null || "".equals(fundName)){
            return "基金名称不允许为空";
        }
        FundInfo fundInfo = fundDao.showFundDetails(fundName);
        if(fundInfo == null){
            return "未查找到任何信息";
        }
        fundInfo.setFundManager(fundDao.selFundManager(fundInfo.getFund_manager()));
        return JSON.toJSONString(fundInfo);
    }

    @Override
    public String collectFund(String fund_name,String fund_number, String username) {
        CollectInfo collectInfo = new CollectInfo();
        collectInfo.setFund_name(fund_name);
        collectInfo.setFund_number(fund_number);
        collectInfo.setUsername(username);
        //先查询该基金是否已经收藏过
        List<CollectInfo> collections = fundDao.selCollection(collectInfo);
        if(collections.size() > 0){
            return "已收藏";
        }
        //没收藏过就添加收藏信息
        Integer result = fundDao.addCollection(collectInfo);
        if(result <= 0){
            return "收藏失败";
        }
        return "收藏成功";
    }

    @Override
    public String selCollection(String username) {
        System.out.println("mxh "+username);
        if(username == null){
            return "用户名不允许为空";
        }
        CollectInfo collectInfo = new CollectInfo();
        collectInfo.setUsername(username);
        List<CollectInfo> collectInfos = fundDao.selCollection(collectInfo);
        return JSON.toJSONString(collectInfos);
    }

    @Override
    public String buyFund(FundInfo fundInfo,String username,Double fund_money) {
        System.out.println("购买者："+username);
        //-1.计算金额

        //0.查看银行卡每日消费金额上限，基金每日申购上限
        //1.调银行卡余额接口查看用户余额是否充足
        //2.余额充足在基金购买表添加一条购买记录
        //3.如果基金以前购买过，现在要追加，修改其购买份额,花费金额
        String fund_name = fundInfo.getFund_name();
        String fund_number = fundInfo.getFund_number();
        Double fund_price = fundInfo.getUnit_value();
        Double fund_unit = fund_money / fund_price; //基金对象里没有购买份额
        Date buyDate = new Date(); //购买时间

        //查询记录是否曾经购买过
        Buy oldInfo = new Buy();
        oldInfo.setUsername(username);
        oldInfo.setProduct_number(fund_number);
        List<Buy> buys = fundDao.selBuyFound(oldInfo);
        for (Buy info : buys) {
            if (fund_number.equals(info.getProduct_number())){
                fund_money = fund_money + info.getProduct_money(); //原来花费的金额与新增的相加
                fund_unit = fund_unit + info.getProduct_unit(); //原来购买的份额与新购买的相加
            }
        }
        Buy buy = new Buy(username,fund_name,fund_number,fund_unit,fund_money,String.valueOf(buyDate));
        Integer result = fundDao.addBuyFund(buy);
        if(result <= 0){
            return "购买基金失败";
        }
        return "购买基金成功";
    }

    @Override
    public String selBuyFund(String username, String fund_number) {
        Buy buy = new Buy();
        List<Buy> buys = null;
        if(username == null || "".equals(username)){
            return "用户名不为空!";
        }
        buy.setUsername(username);
        if(fund_number == null){
            //查询该用户全部购买信息
            buys = fundDao.selBuyFound(buy);
            return JSON.toJSONString(buys);
        }
        //根据用户名和基金代码查一条
        buy.setProduct_number(fund_number);
        buys = fundDao.selBuyFound(buy);
        return JSON.toJSONString(buys);
    }

    @Override
    public String sellFund(String fundName, String username) {
        FundInfo fundInfo = fundDao.findNewFunds().get(0);
        //1.判断基金期限是否到了

        //2.修改购买基金信息表里的数据
        Double earnings = 1000.00; //收益
        Buy sellInfo = new Buy(username,fundName,earnings,String.valueOf(new Date()));
        Integer result = fundDao.updBuyFund(sellInfo);
        if(result <= 0){
            return "赎回失败";
        }
        return "赎回成功";
    }

    @Override
    public String riskToleranceTest(RiskAppetite riskAppetite) {
        //根据调查问卷算出承受风险等级
        String result = RiskRatingAlgorithm.Algorithm(riskAppetite);
        //将风险等级写入对应用户风险等级栏
        String username = riskAppetite.getName();
        Integer count = fundDao.updRiskGrade(result,username);
        if(count <= 0){
            return "风险等级修改失败";
        }
        return result;
    }

    @Override
    public String addFundAccount(FundUser fundUser) {
        //调用短信验证码接口进行身份验证
        if(fundUser.getUsername() == null || fundUser.getPhone() == null ||
                fundUser.getCard_number() == null || fundUser.getCard_type() == null ||
                fundUser.getBeneficial_owner() == null || fundUser.getSex() == null ||
                fundUser.getCapital_source() == null)
        {
            return "开户信息不与允许为空";
        }
        Integer result = fundDao.addFundAccount(fundUser);
        if(result <= 0){
            return "开户失败";
        }
        return "开户成功";
    }

    @Override
    public String fundEarnings(String fundName,Integer num,Integer time) {
        //计算基金收益:
        Double redemptionRate = 0.005; //赎回费率
        Double iopy = 1.4; //赎回当日基金净值
        Double totalAmountRedemption = num * iopy; //赎回总额
        Double redemptionFee = totalAmountRedemption * redemptionRate; //赎回费用
        Double netRedemption = totalAmountRedemption - redemptionFee; //赎回净额
        return null;
    }

    @Override
    public String fundSubscriptionFee(String fundName, Double money) {
        Double iopy = 1.2; //当日净值
        Double explainRate = 0.015; //申购费率
        Double netSubscriptionAmount = money / (1.00+explainRate); //净申购金额
        Double subscriptionFees = money - netSubscriptionAmount; //申购费用
        Double shareSubscription = netSubscriptionAmount / iopy; //申购份额
        return null;
    }

    @Override
    public String automaticInvestmentPlan(String jobName,String time) {
        ScheduleJob job = new ScheduleJob();
        job.setJobId("10001");
        job.setJobName(jobName);
        job.setJobGroup("automaticInvestmentPlan");
        job.setJobStatus("1");
        job.setCronExpression("0/5 * * * * ?");
        job.setDesc("基金定投");
        quartzManager.addJob(job.getJobName(), QuartzJobFactory.class,job.getCronExpression(),job);
        return "定时任务创建成功";
    }
}
