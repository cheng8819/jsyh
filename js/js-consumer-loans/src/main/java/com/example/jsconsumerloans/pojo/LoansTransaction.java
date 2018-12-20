package com.example.jsconsumerloans.pojo;


public class LoansTransaction {

    private Integer liid;
    private Integer liuid;
    private Integer litype;
    private Double linumber;
    private Integer linumberofperiods;
    private Integer listate;
    private String lidate;

    public String getLidate() {
        return lidate;
    }

    public void setLidate(String lidate) {
        this.lidate = lidate;
    }

    public Integer getListate() {
        return listate;
    }

    public void setListate(Integer listate) {
        this.listate = listate;
    }

    public Integer getLinumberofperiods() {
        return linumberofperiods;
    }

    public void setLinumberofperiods(Integer linumberofperiods) {
        this.linumberofperiods = linumberofperiods;
    }

    public Integer getLiid() {
        return liid;
    }

    public void setLiid(Integer liid) {
        this.liid = liid;
    }

    public Integer getLiuid() {
        return liuid;
    }

    public void setLiuid(Integer liuid) {
        this.liuid = liuid;
    }

    public Integer getLitype() {
        return litype;
    }

    public void setLitype(Integer litype) {
        this.litype = litype;
    }

    public Double getLinumber() {
        return linumber;
    }

    public void setLinumber(Double linumber) {
        this.linumber = linumber;
    }
}
