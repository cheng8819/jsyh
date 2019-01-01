package com.example.jsproducerfund.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerfund.dao.BuyDao;
import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.Buy;
import com.example.jsproducerfund.pojo.FundInfo;
import com.example.jsproducerfund.service.BuyService;
import com.example.jsproducerfund.util.Job.QuartzJobFactory;
import com.example.jsproducerfund.util.Job.QuartzManager;
import com.example.jsproducerfund.util.Job.ScheduleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 16:39
 */
@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    private BuyDao buyDao;

    @Autowired
    private FundDao fundDao;

    @Autowired
    private QuartzManager quartzManager;

    public String buyFund(String fund_number,String username,Double fund_money) {
        FundInfo fundInfo = fundDao.showFundDetails(fund_number);
        if(fundInfo == null){
            return "未查询到该基金信息";
        }
        //-1.计算金额

        //0.查看银行卡每日消费金额上限，基金每日申购上限
        //1.调银行卡余额接口查看用户余额是否充足
        //2.余额充足在基金购买表添加一条购买记录
        //3.如果基金以前购买过，现在要追加，修改其购买份额,花费金额
        String fund_name = fundInfo.getFund_name();
        Double fund_price = fundInfo.getUnit_value();
        Double fund_unit = fund_money / fund_price; //基金对象里没有购买份额
        Date buyDate = new Date(); //购买时间

        //查询记录是否曾经购买过
        Buy oldInfo = new Buy();
        oldInfo.setUsername(username);
        oldInfo.setProduct_number(fund_number);
        List<Buy> buys = buyDao.selBuyFound(oldInfo);
        for (Buy info : buys) {
            if (fund_number.equals(info.getProduct_number())){
                fund_money = fund_money + info.getProduct_money(); //原来花费的金额与新增的相加
                fund_unit = fund_unit + info.getProduct_unit(); //原来购买的份额与新购买的相加
            }
        }
        Buy buy = new Buy(username,fund_name,fund_number,fund_unit,fund_money,String.valueOf(buyDate));
        Integer result = buyDao.addBuyFund(buy);
        if(result <= 0){
            return "购买基金失败";
        }
        return "购买基金成功";
    }

    public String selBuyFund(String username, String fund_number) {
        Buy buy = new Buy();
        List<Buy> buys = null;
        if(username == null || "".equals(username)){
            return "用户名不为空!";
        }
        buy.setUsername(username);
        if(fund_number == null){
            //查询该用户全部购买信息
            buys = buyDao.selBuyFound(buy);
            return JSON.toJSONString(buys);
        }
        //根据用户名和基金代码查一条
        buy.setProduct_number(fund_number);
        buys = buyDao.selBuyFound(buy);
        return JSON.toJSONString(buys);
    }

    public String sellFund(String fundName, String username) {
        FundInfo fundInfo = fundDao.findNewFunds().get(0);
        //1.判断基金期限是否到了

        //2.修改购买基金信息表里的数据
        Double earnings = 1000.00; //收益
        Buy sellInfo = new Buy(username,fundName,earnings,String.valueOf(new Date()));
        Integer result = buyDao.updBuyFund(sellInfo);
        if(result <= 0){
            return "赎回失败";
        }
        return "赎回成功";
    }

    public String fundEarnings(String fundName,Integer num,Integer time) {
        //计算基金收益:
        Double redemptionRate = 0.005; //赎回费率
        Double iopy = 1.4; //赎回当日基金净值
        Double totalAmountRedemption = num * iopy; //赎回总额
        Double redemptionFee = totalAmountRedemption * redemptionRate; //赎回费用
        Double netRedemption = totalAmountRedemption - redemptionFee; //赎回净额
        return null;
    }


    public String fundSubscriptionFee(String fundName, Double money) {
        Double iopy = 1.2; //当日净值
        Double explainRate = 0.015; //申购费率
        Double netSubscriptionAmount = money / (1.00+explainRate); //净申购金额
        Double subscriptionFees = money - netSubscriptionAmount; //申购费用
        Double shareSubscription = netSubscriptionAmount / iopy; //申购份额
        return null;
    }


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
