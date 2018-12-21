package com.example.jscosumerfund.pojo;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 11:46
 *
 * 基金信息类
 */
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
     */
    private Integer new_product;

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
     * 成立日期
     */
    private String start_date;

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

    public FundInfo(){}

    public Integer getNew_product() {
        return new_product;
    }

    public void setNew_product(Integer new_product) {
        this.new_product = new_product;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

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
        return start_date;
    }

    public void setSrart_date(String srart_date) {
        this.start_date = srart_date;
    }

    public String getPortfolio_manager() {
        return portfolio_manager;
    }

    public void setPortfolio_manager(String portfolio_manager) {
        this.portfolio_manager = portfolio_manager;
    }

    public String getFund_kind() {
        return fund_kind;
    }

    public void setFund_kind(String fund_kind) {
        this.fund_kind = fund_kind;
    }

    public String getIssuing_date() {
        return issuing_date;
    }

    public void setIssuing_date(String issuing_date) {
        this.issuing_date = issuing_date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFund_newscale() {
        return fund_newscale;
    }

    public void setFund_newscale(String fund_newscale) {
        this.fund_newscale = fund_newscale;
    }

    public Double getUnit_value() {
        return unit_value;
    }

    public void setUnit_value(Double unit_value) {
        this.unit_value = unit_value;
    }

    public String getMaximum_rengou_rate() {
        return maximum_rengou_rate;
    }

    public void setMaximum_rengou_rate(String maximum_rengou_rate) {
        this.maximum_rengou_rate = maximum_rengou_rate;
    }

    public String getMaximum_shengou_rate() {
        return maximum_shengou_rate;
    }

    public void setMaximum_shengou_rate(String maximum_shengou_rate) {
        this.maximum_shengou_rate = maximum_shengou_rate;
    }

    public String getMaximum_redemption_rate() {
        return maximum_redemption_rate;
    }

    public void setMaximum_redemption_rate(String maximum_redemption_rate) {
        this.maximum_redemption_rate = maximum_redemption_rate;
    }

    public Double getMinimum_initial_subscription_amount() {
        return minimum_initial_subscription_amount;
    }

    public void setMinimum_initial_subscription_amount(Double minimum_initial_subscription_amount) {
        this.minimum_initial_subscription_amount = minimum_initial_subscription_amount;
    }

    public Double getMinimum_purchase_amount() {
        return minimum_purchase_amount;
    }

    public void setMinimum_purchase_amount(Double minimum_purchase_amount) {
        this.minimum_purchase_amount = minimum_purchase_amount;
    }

    public String getMinimum_additional_subscription_amount() {
        return minimum_additional_subscription_amount;
    }

    public void setMinimum_additional_subscription_amount(String minimum_additional_subscription_amount) {
        this.minimum_additional_subscription_amount = minimum_additional_subscription_amount;
    }

    public String getFund_manager() {
        return fund_manager;
    }

    public void setFund_manager(String fund_manager) {
        this.fund_manager = fund_manager;
    }

    public String getFund_trustee() {
        return fund_trustee;
    }

    public void setFund_trustee(String fund_trustee) {
        this.fund_trustee = fund_trustee;
    }

    @Override
    public String toString() {
        return "FundInfo{" +
                "fund_number='" + fund_number + '\'' +
                ", fund_shortname='" + fund_shortname + '\'' +
                ", fund_name='" + fund_name + '\'' +
                ", fund_type='" + fund_type + '\'' +
                ", fund_kind='" + fund_kind + '\'' +
                ", issuing_date='" + issuing_date + '\'' +
                ", currency='" + currency + '\'' +
                ", fund_scale='" + fund_scale + '\'' +
                ", fund_newscale='" + fund_newscale + '\'' +
                ", unit_value=" + unit_value +
                ", maximum_rengou_rate='" + maximum_rengou_rate + '\'' +
                ", maximum_shengou_rate='" + maximum_shengou_rate + '\'' +
                ", maximum_redemption_rate='" + maximum_redemption_rate + '\'' +
                ", minimum_initial_subscription_amount=" + minimum_initial_subscription_amount +
                ", minimum_purchase_amount=" + minimum_purchase_amount +
                ", minimum_additional_subscription_amount='" + minimum_additional_subscription_amount + '\'' +
                ", performance_benchmark='" + performance_benchmark + '\'' +
                ", risk_grade='" + risk_grade + '\'' +
                ", srart_date='" + start_date + '\'' +
                ", portfolio_manager='" + portfolio_manager + '\'' +
                ", fund_manager='" + fund_manager + '\'' +
                ", fund_trustee='" + fund_trustee + '\'' +
                '}';
    }
}
