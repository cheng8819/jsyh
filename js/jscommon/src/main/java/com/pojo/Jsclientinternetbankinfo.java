package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * (Jsclientinternetbankinfo)实体类
 *
 * @author makejava
 * @since 2018-12-26 10:05:46
 */
public class Jsclientinternetbankinfo implements Serializable {
    private static final long serialVersionUID = -44504654730167472L;
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
    private String jsInternetbankphone;
    //网银注册时间
    private Date jsOnlinebankregistrationtime;


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

    public String getJsInternetbankphone() {
        return jsInternetbankphone;
    }

    public void setJsInternetbankphone(String jsInternetbankphone) {
        this.jsInternetbankphone = jsInternetbankphone;
    }

    public Date getJsOnlinebankregistrationtime() {
        return jsOnlinebankregistrationtime;
    }

    public void setJsOnlinebankregistrationtime(Date jsOnlinebankregistrationtime) {
        this.jsOnlinebankregistrationtime = jsOnlinebankregistrationtime;
    }

}