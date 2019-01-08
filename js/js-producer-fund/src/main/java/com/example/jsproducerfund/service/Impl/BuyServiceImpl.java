package com.example.jsproducerfund.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerfund.dao.BuyDao;
import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.Buy;
import com.example.jsproducerfund.pojo.FundInfo;
import com.example.jsproducerfund.pojo.Performance;
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

    /**
     *
     * @param fund_number
     * @param username
     * @param fund_money
     * @return
     * @desc:
     *      //-1.计算金额
     *      //0.查看银行卡每日消费金额上限，基金每日申购上限
     *      //1.调银行卡余额接口查看用户余额是否充足
     *      //2.余额充足在基金购买表添加一条购买记录
     *      //3.如果基金以前购买过，现在要追加，修改其购买份额,花费金额
     */
    public String buyFund(String fund_number,String username,Double fund_money) {
        if(username == null || fund_number == null){
            return "用户标识或基金代码不为空";
        }
        if(fund_money == null || fund_money <= 0){
            return "购买金额不为空或必须大于0";
        }
        FundInfo fundInfo = fundDao.showFundDetails(fund_number);
        if(fundInfo == null){
            return "未查询到该基金信息";
        }
        String fund_name = fundInfo.getFund_name();
        Double fund_unit = cutValue(fundSubscriptionFee(fund_number, fund_money), 3); //计算申购份额
        Date buyDate = new Date(); //购买时间

        if(fund_unit > fundInfo.getFundUnit()){
            return "购买份额大于剩余基金份额";
        }

        fundInfo.setFundUnit(fundInfo.getFundUnit() - fund_unit); //减去份额
        fundInfo.setFund_scale(fundInfo.getFund_scale() + fund_money); //增加基金规模
        fundInfo.setFund_newscale(fundInfo.getFund_newscale() + fund_money); //增加最新基金规模
        //修改基金信息
        Integer count = fundDao.updFundInfo(fundInfo);
        if(count <= 0){
            return "基金数据修改失败";
        }

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

    /**
     * 赎回基金
     * @param fundNumber
     * @param num
     * @param username
     * @return
     * @desc:
     *      //1.判断基金期限是否到了
     *      //2.修改购买基金信息表里的数据
     */
    public String sellFund(String fundNumber,Integer num, String username) {
        if(fundNumber == null || username == null){
            return "基金代码或用户标识不为空";
        }
        if(num == null || num <= 0){
            return "赎回基金数量不为空或赎回数量必须大等0";
        }

        //计算赎回相关费用
        String data = fundEarnings(fundNumber, num);

        FundInfo fundInfo = fundDao.showFundDetails(fundNumber);
        fundInfo.setFundUnit(fundInfo.getFundUnit() + num); //增加基金份额
        Double totalPrice = Double.valueOf(cutValue(data, 1)); //赎回总额
        fundInfo.setFund_scale(fundInfo.getFund_scale() - totalPrice); //减去基金规模
        //修改基金信息
        Integer count = fundDao.updFundInfo(fundInfo);
        if(count <= 0){
            return "基金数据修改失败";
        }

        Double earnings = Double.valueOf(cutValue(data,4)); //收益
        Buy sellInfo = new Buy(username,fundNumber,earnings,String.valueOf(new Date()));
        Integer result = buyDao.updBuyFund(sellInfo);
        if(result <= 0){
            return "赎回失败";
        }
        return "赎回成功";
    }

    public String fundEarnings(String fundNumber,Integer num) {
        if(fundNumber == null || num == null || num <= 0){
            return "相关数据不完整";
        }
        FundInfo fundInfo = fundDao.showFundDetails(fundNumber);
        if(fundInfo == null){
            return "未购买该基金";
        }
        //计算基金收益:
        Double redemptionRate = fundInfo.getMaximum_redemption_rate(); //赎回费率
        Double iopv = fundDao.selPerformance(fundNumber).get(0).getIopv(); //赎回当日基金净值
        Double totalAmountRedemption = num * iopv; //赎回总额
        Double redemptionFee = totalAmountRedemption * redemptionRate; //赎回费用
        Double netRedemption = totalAmountRedemption - redemptionFee; //赎回净额
        Double data[] = {totalAmountRedemption,redemptionRate,iopv,redemptionFee,netRedemption};
        return String.valueOf(data);
    }

    public String fundSubscriptionFee(String fundNumber, Double money) {
        if(fundNumber == null){
            return "基金代码不为空";
        }
        if(money == null || money <= 0){
            return "购买金额不为空或购买金额必须大于0";
        }
        FundInfo fundInfo = fundDao.showFundDetails(fundNumber);
        if(fundInfo == null){
            return "未查询到该基金任何信息";
        }
        Double iopv = fundInfo.getIopv(); //当日净值
        Double explainRate = fundInfo.getMaximum_shengou_rate(); //申购费率
        Double netSubscriptionAmount = money / (1.00+explainRate); //净申购金额
        Double subscriptionFees = money - netSubscriptionAmount; //申购费用
        Double shareSubscription = netSubscriptionAmount / iopv; //申购份额
        Double data[] = {explainRate,subscriptionFees,shareSubscription};
        return String.valueOf(data);
    }

    /**
     * 对基金赎回、申购返回结果进行转化
     * @param data
     * @param index
     * @return
     */
    public Double cutValue(String data,Integer index){
        String[] split = data.split(",");
        Double[] doubleArray = new Double[data.length()];
        for(int i=0;i<split.length;i++){
            doubleArray[i] = Double.parseDouble(split[i]);
        }
        return doubleArray[index-1];
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

    @Override
    public String showBuyInfoByTime(String username, String startTime, String stopTime) {
        if(username == null || "".equals(username)){
            return "用户标识不为空";
        }
        if(startTime == null || stopTime == null){
            return "查询时间区间不为空";
        }
        return JSON.toJSONString(buyDao.findBuyInfoByTime(username,startTime,stopTime));
    }

    @Override
    public String showSellInfoByTime(String username, String startTime, String stopTime) {
        if(username == null || "".equals(username)){
            return "用户标识不为空";
        }
        if(startTime == null || stopTime == null){
            return "查询时间区间不为空";
        }
        return JSON.toJSONString(buyDao.findSellInfoByTime(username,startTime,stopTime));
    }
}
