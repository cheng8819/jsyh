package com.example.jsproducerfund.pojo;

import lombok.Data;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 17:33
 *
 * 产品买卖记录
 */
@Data
public class Buy {

    /**
     * 购买记录ID
     */
    private Integer buy_id;

    /**
     * 用户标识
     */
    private String username;

    /**
     * 产品名称
     */
    private String product_name;

    /**
     * 产品代码
     */
    private String product_number;

    /**
     * 购买份额
     */
    private Double product_unit;

    /**
     * 购买基金花费金额
     */
    private Double product_money;

    /**
     * 产品收益
     */
    private Double product_earnings;

    /**
     * 产品状态 1 已购买 0 已赎回
     */
    private Integer product_status;

    /**
     * 购买时间
     */
    private String buy_time;

    /**
     * 赎回时间
     */
    private String sell_time;

    /**
     * 分红模式
     */
    private String dividend_distribution;

    /**
     * 收费模式
     */
    private String charge_mode;

    public Buy(){}

    /**
     * 用于购买基金的构造方法
     * @param username
     * @param product_name
     * @param product_number
     * @param product_unit
     * @param product_money
     * @param buy_time
     */
    public Buy(String username, String product_name, String product_number, Double product_unit, Double product_money, String buy_time) {
        this.username = username;
        this.product_name = product_name;
        this.product_number = product_number;
        this.product_unit = product_unit;
        this.product_money = product_money;
        this.product_status = 1;
        this.buy_time = buy_time;
    }

    /**
     * 用于赎回的构造方法
     *
     * @param username
     * @param product_name
     * @param product_earnings
     * @param sell_time
     */
    public Buy(String username, String product_name, Double product_earnings, String sell_time) {
        this.username = username;
        this.product_name = product_name;
        this.product_earnings = product_earnings;
        this.product_status = 0;
        this.sell_time = sell_time;
    }

}
