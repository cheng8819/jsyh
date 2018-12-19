package com.cloud.jsconsumerremittance.pojo;


import java.io.Serializable;

/**
 * (Branch)实体类
 *
 * @author makejava
 * @since 2018-11-10 08:52:16
 */
public class Branch implements Serializable {

    //网点ID
    private Integer branchId;
    //网点名称
    private String branchName;
    //网点地址
    private String branchSite;
    //受理业务的时间段  {"one":"00:00 - 11:11","two":"14:30 - 15:30"}
    private String branchData;
    //经度
    private String branchLongitude;
    //维度
    private String branchDimensionality;


    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchSite() {
        return branchSite;
    }

    public void setBranchSite(String branchSite) {
        this.branchSite = branchSite;
    }

    public String getBranchData() {
        return branchData;
    }

    public void setBranchData(String branchData) {
        this.branchData = branchData;
    }

    public String getBranchLongitude() {
        return branchLongitude;
    }

    public void setBranchLongitude(String branchLongitude) {
        this.branchLongitude = branchLongitude;
    }

    public String getBranchDimensionality() {
        return branchDimensionality;
    }

    public void setBranchDimensionality(String branchDimensionality) {
        this.branchDimensionality = branchDimensionality;
    }

}