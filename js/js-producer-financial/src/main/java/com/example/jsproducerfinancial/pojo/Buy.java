package com.example.jsproducerfinancial.pojo;

import lombok.Data;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 17:33
 *
 * 产品买卖记录
 */
@Data
public class Buy {

    private Integer buy_id;
    private String username;
    private String product_name;
    private String product_number;
    private Double product_unit;
    private Double product_money; //购买基金花费金额
    private Double product_earnings;
    private String buy_time;
    private String sell_time;
    private Integer product_status;

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
        this.buy_time = buy_time;
        this.product_status = 1;
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
        this.buy_id = buy_id;
        this.username = username;
        this.product_name = product_name;
        this.product_earnings = product_earnings;
        this.sell_time = sell_time;
        this.product_status = 0;
    }

}
