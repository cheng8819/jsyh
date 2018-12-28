package com.example.jsproducerfund.pojo;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/28 11:19
 *
 * 基金公司信息类
 */
public class FundManager {

    private Integer manager_id;

    /**
     * 投资经理姓名
     */
    private String portfolio_manager_name;

    /**
     *  投资经理履历
     */
    private String portfolio_manager_record;

    /**
     * 历任基金
     */
    private String before_funds;

    /**
     *  基金经理获奖经历
     */
    private String portfolio_manager_awards;

    /**
     * 现任基金
     */
    private String now_funds;

    /**
     * 所属基金公司
     */
    private String fund_company;

    /**
     *  基金公司年限
     */
    private String fund_company_age;

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public String getPortfolio_manager_name() {
        return portfolio_manager_name;
    }

    public void setPortfolio_manager_name(String portfolio_manager_name) {
        this.portfolio_manager_name = portfolio_manager_name;
    }

    public String getPortfolio_manager_record() {
        return portfolio_manager_record;
    }

    public void setPortfolio_manager_record(String portfolio_manager_record) {
        this.portfolio_manager_record = portfolio_manager_record;
    }

    public String getBefore_funds() {
        return before_funds;
    }

    public void setBefore_funds(String before_funds) {
        this.before_funds = before_funds;
    }

    public String getPortfolio_manager_awards() {
        return portfolio_manager_awards;
    }

    public void setPortfolio_manager_awards(String portfolio_manager_awards) {
        this.portfolio_manager_awards = portfolio_manager_awards;
    }

    public String getNow_funds() {
        return now_funds;
    }

    public void setNow_funds(String now_funds) {
        this.now_funds = now_funds;
    }

    public String getFund_company() {
        return fund_company;
    }

    public void setFund_company(String fund_company) {
        this.fund_company = fund_company;
    }

    public String getFund_company_age() {
        return fund_company_age;
    }

    public void setFund_company_age(String fund_company_age) {
        this.fund_company_age = fund_company_age;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id=" + manager_id +
                ", portfolio_manager_name='" + portfolio_manager_name + '\'' +
                ", portfolio_manager_record='" + portfolio_manager_record + '\'' +
                ", before_funds='" + before_funds + '\'' +
                ", portfolio_manager_awards='" + portfolio_manager_awards + '\'' +
                ", now_funds='" + now_funds + '\'' +
                ", fund_company='" + fund_company + '\'' +
                ", fund_company_age='" + fund_company_age + '\'' +
                '}';
    }
}
