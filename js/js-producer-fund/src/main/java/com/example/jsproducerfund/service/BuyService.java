package com.example.jsproducerfund.service;

import org.apache.ibatis.annotations.Param;

public interface BuyService {

    /**
     * 购买基金接口
     * @param fund_number
     * @param username
     * @return
     *
     * 购买基金做两件事：1.在购买表添加一条购买基金的记录
     *                   2.根据查询余额接口判断余额是否充足，充足购买，不充足反馈用户余额不足
     */
    String buyFund(String fund_number, @Param("username") String username, @Param("fund_money") Double fund_money);

    /**
     * 查询基金购买记录
     * @param username
     * @param fund_number
     * @return
     */
    String selBuyFund(@Param("username") String username,@Param("fund_number") String fund_number);

    /**
     * 赎回基金
     * 1.判断基金期限是否到期
     * 2.根据收益情况给客户打钱
     * @param fundName
     * @param username
     * @return
     */
    String sellFund(String fundName,String username);

    /**
     * 计算基金收益
     * @param fundName 基金名称
     * @param num 赎回份额
     * @param time 购买天数
     * @return
     */
    String fundEarnings(String fundName,Integer num,Integer time);

    /**
     * 计算申购费用
     * @param fundName
     * @param money
     * @return
     */
    String fundSubscriptionFee(String fundName,Double money);

    /**
     * 基金定投
     * @param jobName 定时任务名称
     * @param time 任务执行时间
     * @return
     */
    String automaticInvestmentPlan(String jobName,String time);

}
