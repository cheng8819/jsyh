package com.service.pojo;

public class ClientRegisterBankInfo {

    /**
     * 用户注册添加银行卡信息
     * 参数
     * 银行卡号
     * 银行卡密码
     * 用户登录名
     * 银行卡预留电话
     * 网银登录密码
     * 短信验证码
     */
    //银行卡号
    private String bankIdCard;
    //银行卡密码
    private String bankPassword;
    //用户登录名
    private String clientUserName;
    //银行卡预留电话
    private String bankCardReservationPhone;
    //网银密码
    private String internetBankPassword;
    //短信验证码
    private String smsVerificationCode;
    //姓名
    private String username;
    //身份证号码
    private String iDCard;
    //网银登陆手机号
    private String internetBankPhone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getiDCard() {
        return iDCard;
    }

    public void setiDCard(String iDCard) {
        this.iDCard = iDCard;
    }

    public String getInternetBankPhone() {
        return internetBankPhone;
    }

    public void setInternetBankPhone(String internetBankPhone) {
        this.internetBankPhone = internetBankPhone;
    }

    public String getBankIdCard() {
        return bankIdCard;
    }

    public void setBankIdCard(String bankIdCard) {
        this.bankIdCard = bankIdCard;
    }

    public String getBankPassword() {
        return bankPassword;
    }

    public void setBankPassword(String bankPassword) {
        this.bankPassword = bankPassword;
    }

    public String getClientUserName() {
        return clientUserName;
    }

    public void setClientUserName(String clientUserName) {
        this.clientUserName = clientUserName;
    }

    public String getBankCardReservationPhone() {
        return bankCardReservationPhone;
    }

    public void setBankCardReservationPhone(String bankCardReservationPhone) {
        this.bankCardReservationPhone = bankCardReservationPhone;
    }

    public String getInternetBankPassword() {
        return internetBankPassword;
    }

    public void setInternetBankPassword(String internetBankPassword) {
        this.internetBankPassword = internetBankPassword;
    }

    public String getSmsVerificationCode() {
        return smsVerificationCode;
    }

    public void setSmsVerificationCode(String smsVerificationCode) {
        this.smsVerificationCode = smsVerificationCode;
    }
}
