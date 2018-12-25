package com.example.jsproducerfund.service;

public interface Calculate {

    /**
     * 模拟基金走势
     */
    void FundPerformance();

    /**
     * 基金定投
     *
     * 定投的品种、金额、周期、分红方式以及委托赎回
     *
     * 一般定投基金一个月最低需要100-300元，也可以直接申购基金，最低1000元；
     * 点击赎回即可（确认赎回成功后的3-7工作日即可到帐，只有QDII时间较长）；
     */
    void automaticInvestmentPlan();

}
