package com.example.jsdengluprovider.pojo;

import java.io.Serializable;

/**
 * (Jsclientinfo)实体类
 *
 * @author makejava
 * @since 2018-12-19 23:36:46
 */
public class Jsclientinfo implements Serializable {
    private static final long serialVersionUID = 508212824884209503L;
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
    
    private String u1;
    
    private String u2;
    
    private String u3;
    
    private String u4;
    
    private String u5;


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

    public String getU1() {
        return u1;
    }

    public void setU1(String u1) {
        this.u1 = u1;
    }

    public String getU2() {
        return u2;
    }

    public void setU2(String u2) {
        this.u2 = u2;
    }

    public String getU3() {
        return u3;
    }

    public void setU3(String u3) {
        this.u3 = u3;
    }

    public String getU4() {
        return u4;
    }

    public void setU4(String u4) {
        this.u4 = u4;
    }

    public String getU5() {
        return u5;
    }

    public void setU5(String u5) {
        this.u5 = u5;
    }

}