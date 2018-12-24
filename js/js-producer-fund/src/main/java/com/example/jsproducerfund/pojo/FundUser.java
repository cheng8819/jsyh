package com.example.jsproducerfund.pojo;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 19:31
 *
 * 基金开户申请表/基金用户开户信息
 */
public class FundUser {

    private Integer user_id;
    private String username;
    private String sex;
    private String birthday;
    private String phone;
    private String profession; //职业
    private String address;
    private String card_type;
    private String card_number;
    private String risk_grade;
    private String beneficial_owner;
    private String capital_source;
    private String bank_name;

    public FundUser(){}

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getRisk_grade() {
        return risk_grade;
    }

    public void setRisk_grade(String risk_grade) {
        this.risk_grade = risk_grade;
    }

    public String getBeneficial_owner() {
        return beneficial_owner;
    }

    public void setBeneficial_owner(String beneficial_owner) {
        this.beneficial_owner = beneficial_owner;
    }

    public String getCapital_source() {
        return capital_source;
    }

    public void setCapital_source(String capital_source) {
        this.capital_source = capital_source;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }
}
