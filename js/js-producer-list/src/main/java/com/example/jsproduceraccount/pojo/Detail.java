package com.example.jsproduceraccount.pojo;

public class Detail {
    private String cardnumber; //银行卡号
    private double moneysum; //交易金额
    private String currency; //币种
    private String nowtime; //交易时间
    private String type; //交易类型

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public double getMoneysum() {
        return moneysum;
    }

    public void setMoneysum(double moneysum) {
        this.moneysum = moneysum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNowtime() {
        return nowtime;
    }

    public void setNowtime(String nowtime) {
        this.nowtime = nowtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
