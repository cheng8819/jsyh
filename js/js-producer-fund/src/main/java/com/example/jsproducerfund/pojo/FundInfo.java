package com.example.jsproducerfund.pojo;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 11:46
 */
public class FundInfo {

    private String fund_number;

    private String fund_shortname;

    private String fund_name;

    private String fund_type;

    private String fund_scale;

    private String performance_benchmark;

    private String risk_grade;

    private String srart_date;

    private String portfolio_manager;

    public FundInfo(){}

    public String getFund_number() {
        return fund_number;
    }

    public void setFund_number(String fund_number) {
        this.fund_number = fund_number;
    }

    public String getFund_name() {
        return fund_name;
    }

    public void setFund_name(String fund_name) {
        this.fund_name = fund_name;
    }

    public String getFund_shortname() {
        return fund_shortname;
    }

    public void setFund_shortname(String fund_shortname) {
        this.fund_shortname = fund_shortname;
    }

    public String getFund_type() {
        return fund_type;
    }

    public void setFund_type(String fund_type) {
        this.fund_type = fund_type;
    }

    public String getFund_scale() {
        return fund_scale;
    }

    public void setFund_scale(String fund_scale) {
        this.fund_scale = fund_scale;
    }

    public String getPerformance_benchmark() {
        return performance_benchmark;
    }

    public void setPerformance_benchmark(String performance_benchmark) {
        this.performance_benchmark = performance_benchmark;
    }

    public String getRisk_grade() {
        return risk_grade;
    }

    public void setRisk_grade(String risk_grade) {
        this.risk_grade = risk_grade;
    }

    public String getSrart_date() {
        return srart_date;
    }

    public void setSrart_date(String srart_date) {
        this.srart_date = srart_date;
    }

    public String getPortfolio_manager() {
        return portfolio_manager;
    }

    public void setPortfolio_manager(String portfolio_manager) {
        this.portfolio_manager = portfolio_manager;
    }
}
