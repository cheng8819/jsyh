package com.example.jscosumerfund.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/20 22:03
 *
 * 基金绩效表现(performance)表
 */
@Data
public class Performance implements Serializable{

    private String fund_number;
    private String fund_name;
    private String fund_type;

    /**
     * 单位净值
     */
    private Double iopv;

    /**
     *  累计净值
     */
    private Double iopvs;

    /**
     * 日涨幅
     */
    private Double dailyIncreases;

    /**
     * 一周回报率
     */
    private Double weekly_rate_of_return;

    /**
     * 一月回报率
     */
    private Double monthly_rate_of_return;

    /**
     * 三月回报率
     */
    private Double threeMonthRise;

    /**
     * 产品状态
     */
    private Integer fundStatus;

    /**
     * 基金评级
     */
    private String fund_rating;

}
