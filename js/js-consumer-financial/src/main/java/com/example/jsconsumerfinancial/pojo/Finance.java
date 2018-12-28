package com.example.jsconsumerfinancial.pojo;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/24 17:23
 */
public class Finance {

    private Integer product_id;
    private String product_code;
    private String product_name;
    private String break_even;
    private String product_risk_level;
    private String customer_risk_level;
    private String product_type;
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

    public Finance(){}

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBreak_even() {
        return break_even;
    }

    public void setBreak_even(String break_even) {
        this.break_even = break_even;
    }

    public String getProduct_risk_level() {
        return product_risk_level;
    }

    public void setProduct_risk_level(String product_risk_level) {
        this.product_risk_level = product_risk_level;
    }

    public String getCustomer_risk_level() {
        return customer_risk_level;
    }

    public void setCustomer_risk_level(String customer_risk_level) {
        this.customer_risk_level = customer_risk_level;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPerformance_comparison_benchmark() {
        return performance_comparison_benchmark;
    }

    public void setPerformance_comparison_benchmark(String performance_comparison_benchmark) {
        this.performance_comparison_benchmark = performance_comparison_benchmark;
    }

    public String getProduct_lines() {
        return product_lines;
    }

    public void setProduct_lines(String product_lines) {
        this.product_lines = product_lines;
    }

    public String getCollect_period() {
        return collect_period;
    }

    public void setCollect_period(String collect_period) {
        this.collect_period = collect_period;
    }

    public Double getSingle_subscription_limit() {
        return single_subscription_limit;
    }

    public void setSingle_subscription_limit(Double single_subscription_limit) {
        this.single_subscription_limit = single_subscription_limit;
    }

    public String getProduct_founded() {
        return product_founded;
    }

    public void setProduct_founded(String product_founded) {
        this.product_founded = product_founded;
    }

    public String getTime_limit() {
        return time_limit;
    }

    public void setTime_limit(String time_limit) {
        this.time_limit = time_limit;
    }

    public String getExpected_annualized_rate() {
        return expected_annualized_rate;
    }

    public void setExpected_annualized_rate(String expected_annualized_rate) {
        this.expected_annualized_rate = expected_annualized_rate;
    }
}
