package com.pojo;

import java.io.Serializable;

/**
 * (Jsclientinfo)实体类
 *
 * @author makejava
 * @since 2018-12-26 10:05:46
 */
public class Jsclientinfo implements Serializable {
    private static final long serialVersionUID = 954150453375704050L;
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
    //客户网银开通状态 0 未开通  1开通
    private Integer jsInternetopentype;
    //国籍
    private String jsNationality;
    //出生日期
    private String jsDateofbirth;
    //婚姻状况
    private String jsMaritalstatus;
    //教育程度
    private String jsDegreeofeducation;
    //职业
    private String jsProfession;
    //所属行业
    private String jsIndustryinvolved;
    //技术职称
    private String jsTechnicaltitle;
    //行政级别
    private String jsAdministrativeranks;
    //供养人口
    private String jsTosupportthepopulation;
    //工作单位
    private String jsWorkunit;
    //进入本工作单位时间
    private String jsEntertheworkunittime;


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

    public Integer getJsInternetopentype() {
        return jsInternetopentype;
    }

    public void setJsInternetopentype(Integer jsInternetopentype) {
        this.jsInternetopentype = jsInternetopentype;
    }

    public String getJsNationality() {
        return jsNationality;
    }

    public void setJsNationality(String jsNationality) {
        this.jsNationality = jsNationality;
    }

    public String getJsDateofbirth() {
        return jsDateofbirth;
    }

    public void setJsDateofbirth(String jsDateofbirth) {
        this.jsDateofbirth = jsDateofbirth;
    }

    public String getJsMaritalstatus() {
        return jsMaritalstatus;
    }

    public void setJsMaritalstatus(String jsMaritalstatus) {
        this.jsMaritalstatus = jsMaritalstatus;
    }

    public String getJsDegreeofeducation() {
        return jsDegreeofeducation;
    }

    public void setJsDegreeofeducation(String jsDegreeofeducation) {
        this.jsDegreeofeducation = jsDegreeofeducation;
    }

    public String getJsProfession() {
        return jsProfession;
    }

    public void setJsProfession(String jsProfession) {
        this.jsProfession = jsProfession;
    }

    public String getJsIndustryinvolved() {
        return jsIndustryinvolved;
    }

    public void setJsIndustryinvolved(String jsIndustryinvolved) {
        this.jsIndustryinvolved = jsIndustryinvolved;
    }

    public String getJsTechnicaltitle() {
        return jsTechnicaltitle;
    }

    public void setJsTechnicaltitle(String jsTechnicaltitle) {
        this.jsTechnicaltitle = jsTechnicaltitle;
    }

    public String getJsAdministrativeranks() {
        return jsAdministrativeranks;
    }

    public void setJsAdministrativeranks(String jsAdministrativeranks) {
        this.jsAdministrativeranks = jsAdministrativeranks;
    }

    public String getJsTosupportthepopulation() {
        return jsTosupportthepopulation;
    }

    public void setJsTosupportthepopulation(String jsTosupportthepopulation) {
        this.jsTosupportthepopulation = jsTosupportthepopulation;
    }

    public String getJsWorkunit() {
        return jsWorkunit;
    }

    public void setJsWorkunit(String jsWorkunit) {
        this.jsWorkunit = jsWorkunit;
    }

    public String getJsEntertheworkunittime() {
        return jsEntertheworkunittime;
    }

    public void setJsEntertheworkunittime(String jsEntertheworkunittime) {
        this.jsEntertheworkunittime = jsEntertheworkunittime;
    }

}