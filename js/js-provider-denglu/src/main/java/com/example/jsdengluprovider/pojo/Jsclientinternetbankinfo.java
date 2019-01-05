package com.example.jsdengluprovider.pojo;

import java.io.Serializable;

/**
 * (Jsclientinternetbankinfo)实体类
 *
 * @author makejava
 * @since 2018-12-19 23:36:47
 */
public class Jsclientinternetbankinfo implements Serializable {
    private static final long serialVersionUID = -35747186711134972L;
    //客户后台id
    private Integer jsClientid;
    //客户网银用户名
    private String jsInternetbankusername;
    //客户网银密码
    private String jsInternetbankpassword;
    //客户网银登录记录
    private String jsCookierecord;
    //证件号码
    private String jsIdnumber;
    //客户网银手机号
    private String jsInternetBankPhone;

    //手机号
    private Jsclientinfo jsclientinfo;

    //银行卡号
    private Jsclientbank jsclientbank;

    public Jsclientbank getJsclientbank() {
        return jsclientbank;
    }

    public String getJsInternetBankPhone() {
        return jsInternetBankPhone;
    }

    public void setJsInternetBankPhone(String jsInternetBankPhone) {
        this.jsInternetBankPhone = jsInternetBankPhone;
    }

    public void setJsclientbank(Jsclientbank jsclientbank) {
        this.jsclientbank = jsclientbank;
    }

    public Jsclientinfo getJsclientinfo() {
        return jsclientinfo;
    }

    public void setJsclientinfo(Jsclientinfo jsclientinfo) {
        this.jsclientinfo = jsclientinfo;
    }

    public Integer getJsClientid() {
        return jsClientid;
    }

    public void setJsClientid(Integer jsClientid) {
        this.jsClientid = jsClientid;
    }

    public String getJsInternetbankusername() {
        return jsInternetbankusername;
    }

    public void setJsInternetbankusername(String jsInternetbankusername) {
        this.jsInternetbankusername = jsInternetbankusername;
    }

    public String getJsInternetbankpassword() {
        return jsInternetbankpassword;
    }

    public void setJsInternetbankpassword(String jsInternetbankpassword) {
        this.jsInternetbankpassword = jsInternetbankpassword;
    }

    public String getJsCookierecord() {
        return jsCookierecord;
    }

    public void setJsCookierecord(String jsCookierecord) {
        this.jsCookierecord = jsCookierecord;
    }

    public String getJsIdnumber() {
        return jsIdnumber;
    }

    public void setJsIdnumber(String jsIdnumber) {
        this.jsIdnumber = jsIdnumber;
    }

}