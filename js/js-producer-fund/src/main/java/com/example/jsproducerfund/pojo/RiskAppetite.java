package com.example.jsproducerfund.pojo;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 19:39
 *
 * 用户风险承受测试调查问卷
 */
public class RiskAppetite {

    private String age_grades; //年龄阶段
    private String Investment_experience; //投资经验
    private String investment_horizon; //预期投资期限
    private String household_income; //全年家庭收入
    private String Investment_proportion; //家庭资金用于投资的比率
    private String Investment_purposes; //投资目的
    private String Investment_attitude;  //投资亏损态度
    private String issue1; //问题1
    private String issue2;
    private String issue3;
    private String issue4;
    private String issue5;

    public RiskAppetite(){}

    public String getAge_grades() {
        return age_grades;
    }

    public void setAge_grades(String age_grades) {
        this.age_grades = age_grades;
    }

    public String getInvestment_experience() {
        return Investment_experience;
    }

    public void setInvestment_experience(String investment_experience) {
        Investment_experience = investment_experience;
    }

    public String getInvestment_horizon() {
        return investment_horizon;
    }

    public void setInvestment_horizon(String investment_horizon) {
        this.investment_horizon = investment_horizon;
    }

    public String getHousehold_income() {
        return household_income;
    }

    public void setHousehold_income(String household_income) {
        this.household_income = household_income;
    }

    public String getInvestment_proportion() {
        return Investment_proportion;
    }

    public void setInvestment_proportion(String investment_proportion) {
        Investment_proportion = investment_proportion;
    }

    public String getInvestment_purposes() {
        return Investment_purposes;
    }

    public void setInvestment_purposes(String investment_purposes) {
        Investment_purposes = investment_purposes;
    }

    public String getInvestment_attitude() {
        return Investment_attitude;
    }

    public void setInvestment_attitude(String investment_attitude) {
        Investment_attitude = investment_attitude;
    }

    public String getIssue1() {
        return issue1;
    }

    public void setIssue1(String issue1) {
        this.issue1 = issue1;
    }

    public String getIssue2() {
        return issue2;
    }

    public void setIssue2(String issue2) {
        this.issue2 = issue2;
    }

    public String getIssue3() {
        return issue3;
    }

    public void setIssue3(String issue3) {
        this.issue3 = issue3;
    }

    public String getIssue4() {
        return issue4;
    }

    public void setIssue4(String issue4) {
        this.issue4 = issue4;
    }

    public String getIssue5() {
        return issue5;
    }

    public void setIssue5(String issue5) {
        this.issue5 = issue5;
    }

    @Override
    public String toString() {
        return "RiskAppetite{" +
                "age_grades='" + age_grades + '\'' +
                ", Investment_experience='" + Investment_experience + '\'' +
                ", investment_horizon='" + investment_horizon + '\'' +
                ", household_income='" + household_income + '\'' +
                ", Investment_proportion='" + Investment_proportion + '\'' +
                ", Investment_purposes='" + Investment_purposes + '\'' +
                ", Investment_attitude='" + Investment_attitude + '\'' +
                ", issue1='" + issue1 + '\'' +
                ", issue2='" + issue2 + '\'' +
                ", issue3='" + issue3 + '\'' +
                ", issue4='" + issue4 + '\'' +
                ", issue5='" + issue5 + '\'' +
                '}';
    }
}
