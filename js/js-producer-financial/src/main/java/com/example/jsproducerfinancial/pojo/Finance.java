package com.example.jsproducerfinancial.pojo;

import lombok.Data;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/24 17:23
 */
@Data
public class Finance {

    private Integer product_id;

    /**
     * 理财产品代码
     */
    private String product_code;
    private String product_name;

    /**
     * 是否保本
     */
    private String break_even;

    /**
     * 产品风险等级
     */
    private String product_risk_level;

    /**
     * 客户风险等级
     */
    private String customer_risk_level;

    /**
     * 理财产品类型
     */
    private String product_type;

    /**
     * 币种
     */
    private String currency;

    /**
     * 业绩比较基准
     */
    private String performance_comparison_benchmark;

    /**
     * 产品额度
     */
    private String product_lines;

    /**
     * 募集期
     */
    private String collect_period;

    /**
     * 单笔认购限额(起购金额)
     */
    private Double single_subscription_limit;

    /**
     * 产品成立
     */
    private String product_founded;

    /**
     * 期限
     */
    private String time_limit;

    /**
     * 预计年化利率
     */
    private String expected_annualized_rate;

}
