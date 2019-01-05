package com.service.pojo;

/**
 * 注册网银用户信息类
 */
public class ClientRegisterUser {
    //客户后台id号
    private Integer jsClientid;
    //客户姓名
    private String jsClientname;
    //性别
    private String jsSex;
    //客户证件类型
    private String jsCretificatetype;
    //证件号码
    private String jsIdnumber;
    //电话号码
    private String jsPhonenumber;
    //客户级别
    private String jsClientrank;
    //注册方式
    private String jsRegisterway;
    //客户网银开通状态 0关闭 1开通
    private Integer jsInternetOpenType;
    //客户网银用户名
    private String jsInternetbankusername;
    //客户网银密码
    private String jsInternetbankpassword;
    //客户网银手机号
    private String jsInternetBankPhone;

    public Integer getJsClientid() {
        return jsClientid;
    }

    public void setJsClientid(Integer jsClientid) {
        this.jsClientid = jsClientid;
    }

    public String getJsClientname() {
        return jsClientname;
    }

    public void setJsClientname(String jsClientname) {
        this.jsClientname = jsClientname;
    }

    public String getJsSex() {
        return jsSex;
    }

    public void setJsSex(String jsSex) {
        this.jsSex = jsSex;
    }

    public String getJsCretificatetype() {
        return jsCretificatetype;
    }

    public void setJsCretificatetype(String jsCretificatetype) {
        this.jsCretificatetype = jsCretificatetype;
    }

    public String getJsIdnumber() {
        return jsIdnumber;
    }

    public void setJsIdnumber(String jsIdnumber) {
        this.jsIdnumber = jsIdnumber;
    }

    public String getJsPhonenumber() {
        return jsPhonenumber;
    }

    public void setJsPhonenumber(String jsPhonenumber) {
        this.jsPhonenumber = jsPhonenumber;
    }

    public String getJsClientrank() {
        return jsClientrank;
    }

    public void setJsClientrank(String jsClientrank) {
        this.jsClientrank = jsClientrank;
    }

    public String getJsRegisterway() {
        return jsRegisterway;
    }

    public void setJsRegisterway(String jsRegisterway) {
        this.jsRegisterway = jsRegisterway;
    }

    public Integer getJsInternetOpenType() {
        return jsInternetOpenType;
    }

    public void setJsInternetOpenType(Integer jsInternetOpenType) {
        this.jsInternetOpenType = jsInternetOpenType;
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



    public String getJsInternetBankPhone() {
        return jsInternetBankPhone;
    }

    public void setJsInternetBankPhone(String jsInternetBankPhone) {
        this.jsInternetBankPhone = jsInternetBankPhone;
    }
}
