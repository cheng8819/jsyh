package com.example.jsconsumerfinancial.pojo;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 17:33
 *
 * 产品买卖记录
 */
public class Buy {

    private Integer buy_id;
    private String username;
    private String product_name;
    private String product_number;
    private Double product_unit;
    private Double product_money; //购买基金花费金额
    private Double product_rernings;
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
     * @param product_rernings
     * @param sell_time
     */
    public Buy(String username, String product_name, Double product_rernings, String sell_time) {
        this.buy_id = buy_id;
        this.username = username;
        this.product_name = product_name;
        this.product_rernings = product_rernings;
        this.sell_time = sell_time;
        this.product_status = 0;
    }

    public Integer getBuy_id() {
        return buy_id;
    }

    public void setBuy_id(Integer buy_id) {
        this.buy_id = buy_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_number() {
        return product_number;
    }

    public void setProduct_number(String product_number) {
        this.product_number = product_number;
    }

    public Double getProduct_unit() {
        return product_unit;
    }

    public void setProduct_unit(Double product_unit) {
        this.product_unit = product_unit;
    }

    public Double getProduct_money() {
        return product_money;
    }

    public void setProduct_money(Double product_money) {
        this.product_money = product_money;
    }

    public Double getProduct_rernings() {
        return product_rernings;
    }

    public void setProduct_rernings(Double product_rernings) {
        this.product_rernings = product_rernings;
    }

    public String getBuy_time() {
        return buy_time;
    }

    public void setBuy_time(String buy_time) {
        this.buy_time = buy_time;
    }

    public String getSell_time() {
        return sell_time;
    }

    public void setSell_time(String sell_time) {
        this.sell_time = sell_time;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "buy_id=" + buy_id +
                ", username='" + username + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_number='" + product_number + '\'' +
                ", product_unit=" + product_unit +
                ", product_money=" + product_money +
                ", product_rernings=" + product_rernings +
                ", buy_time='" + buy_time + '\'' +
                ", sell_time='" + sell_time + '\'' +
                '}';
    }
}
