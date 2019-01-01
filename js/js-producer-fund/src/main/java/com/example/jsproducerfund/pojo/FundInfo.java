package com.example.jsproducerfund.pojo;

import lombok.Data;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 11:46
 *
 * 基金信息类
 */
@Data
public class FundInfo {

    /**
     * 基金代码
     */
    private String fund_number;

    /**
     * 基金简称
     */
    private String fund_shortname;

    /**
     * 基金名称
     */
    private String fund_name;

    /**
     * 基金类型(混合型)
     */
    private String fund_type;

    /**
     * 基金种类(开放式基金)
     */
    private String fund_kind;

    /**
     * 发行日期
     */
    private String issuing_date;

    /**
     * 币种
     */
    private String currency;

    /**
     * 是否为新发基金
     * 0:新发布基金
     * 1:已上市基金
     * -1:已冻结
     */
    private Integer fundStatus;

    /**
     * 单位净值
     */
    private Double iopv;

    /**
     * 累计净值
     */
    private Double iopvs;

    /**
     * 日涨幅
     */
    private Double dailyIncreases;

    /**
     * 近三个月涨幅
     */
    private Double threeMonthRise;

    /**
     * 基金评级
     */
    private Integer fund_rating;

    /**
     *  基金募集规模
     */
    private String fund_scale;

    /**
     *  最新基金募集规模
     */
    private String fund_newscale;

    /**
     * 单位面值(发行价)
     */
    private Double unit_value;

    /**
     * 基金份额
     * 基金份额 = 基金规模 / 基金发行价格
     */
    private Double fundUnit;

    /**
     * 最大认购费率
     */
    private String maximum_rengou_rate;

    /**
     * 最大申购费率
     */
    private String maximum_shengou_rate;

    /**
     * 最大赎回费率
     */
    private String maximum_redemption_rate;

    /**
     * 首笔最低认购金额
     */
    private Double minimum_initial_subscription_amount;

    /**
     *  最低申购金额
     */
    private Double minimum_purchase_amount;

    /**
     *  追加认购最低金额
     */
    private String minimum_additional_subscription_amount;


    /**
     *  业绩基准(基金的及格线)
     */
    private String performance_benchmark;

    /**
     *  银行风险评级
     */
    private String risk_grade;

    /**
     * 基金经理
     */
    private String portfolio_manager;

    /**
     * 基金管理人
     */
    private String fund_manager;

    /**
     * 基金托管人
     */
    private String fund_trustee;

    /**
     * 成立时间
     */
    private String start_date;

    /**
     * 募集方式
     */
    private String raise_way;

    /**
     * 投资经理信息
     */
    private FundManager fundManager;

    /**
     * 基金公司
     */
    private String fund_company;
}
