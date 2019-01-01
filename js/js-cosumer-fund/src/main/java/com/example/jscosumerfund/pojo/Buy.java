package com.example.jscosumerfund.pojo;

import java.math.BigDecimal;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 17:33
 */
public class Buy {

    private Integer buy_id;
    private String username;
    private String finances; //购买的理财产品
    private String funds;  //购买的基金
    private Integer fund_unit; //购买基金份额
    private BigDecimal fund_money; //购买基金花费金额
    private String product_earnings;

    public Buy(){}

    public String getProduct_earnings() {
        return product_earnings;
    }

    public void setProduct_earnings(String product_earnings) {
        this.product_earnings = product_earnings;
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

    public String getFinances() {
        return finances;
    }

    public void setFinances(String finances) {
        this.finances = finances;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public Integer getFund_unit() {
        return fund_unit;
    }

    public void setFund_unit(Integer fund_unit) {
        this.fund_unit = fund_unit;
    }

    public BigDecimal getFund_money() {
        return fund_money;
    }

    public void setFund_money(BigDecimal fund_money) {
        this.fund_money = fund_money;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "buy_id=" + buy_id +
                ", username='" + username + '\'' +
                ", finances='" + finances + '\'' +
                ", funds='" + funds + '\'' +
                ", fund_unit=" + fund_unit +
                ", fund_money=" + fund_money +
                ", product_earnings='" + product_earnings + '\'' +
                '}';
    }
}
