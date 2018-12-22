package com.example.jsproducerfund.pojo;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/20 22:03
 *
 * 基金绩效表现(performance)表
 */
public class Performance {

    private Integer fund_number;
    private String fund_name;
    private String fund_type;

    /**
     * 单位净值
     */
    private String iopy;

    /**
     *  累计净值
     */
    private String iopys;

    /**
     * 日涨幅
     */
    private String day_or;

    /**
     * 一周回报率
     */
    private String weekly_rate_of_return;

    /**
     * 一月回报率
     */
    private String monthly_rate_of_return;

    /**
     * 三月回报率
     */
    private String march_rate_of_return;

    /**
     * 产品状态
     */
    private String product_status;

    /**
     * 基金评级
     */
    private String fund_rating;

    public Performance(){}

    public Performance(Integer fund_number, String fund_name, String fund_type, String fund_rating) {
        this.fund_number = fund_number;
        this.fund_name = fund_name;
        this.fund_type = fund_type;
        this.fund_rating = fund_rating;
    }

    public String getFund_type() {
        return fund_type;
    }

    public void setFund_type(String fund_type) {
        this.fund_type = fund_type;
    }

    public Integer getFund_number() {
        return fund_number;
    }

    public void setFund_number(Integer fund_number) {
        this.fund_number = fund_number;
    }

    public String getFund_name() {
        return fund_name;
    }

    public void setFund_name(String fund_name) {
        this.fund_name = fund_name;
    }

    public String getIopy() {
        return iopy;
    }

    public void setIopy(String iopy) {
        this.iopy = iopy;
    }

    public String getIopys() {
        return iopys;
    }

    public void setIopys(String iopys) {
        this.iopys = iopys;
    }

    public String getDay_or() {
        return day_or;
    }

    public void setDay_or(String day_or) {
        this.day_or = day_or;
    }

    public String getWeekly_rate_of_return() {
        return weekly_rate_of_return;
    }

    public void setWeekly_rate_of_return(String weekly_rate_of_return) {
        this.weekly_rate_of_return = weekly_rate_of_return;
    }

    public String getMonthly_rate_of_return() {
        return monthly_rate_of_return;
    }

    public void setMonthly_rate_of_return(String monthly_rate_of_return) {
        this.monthly_rate_of_return = monthly_rate_of_return;
    }

    public String getMarch_rate_of_return() {
        return march_rate_of_return;
    }

    public void setMarch_rate_of_return(String march_rate_of_return) {
        this.march_rate_of_return = march_rate_of_return;
    }

    public String getProduct_status() {
        return product_status;
    }

    public void setProduct_status(String product_status) {
        this.product_status = product_status;
    }

    public String getFund_rating() {
        return fund_rating;
    }

    public void setFund_rating(String fund_rating) {
        this.fund_rating = fund_rating;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "fund_number=" + fund_number +
                ", fund_name='" + fund_name + '\'' +
                ", iopy='" + iopy + '\'' +
                ", iopys='" + iopys + '\'' +
                ", day_or='" + day_or + '\'' +
                ", weekly_rate_of_return='" + weekly_rate_of_return + '\'' +
                ", monthly_rate_of_return='" + monthly_rate_of_return + '\'' +
                ", march_rate_of_return='" + march_rate_of_return + '\'' +
                ", product_status='" + product_status + '\'' +
                ", fund_rating='" + fund_rating + '\'' +
                '}';
    }
}
