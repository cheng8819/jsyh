package com.example.jsconsumerloans.pojo;


public class LoansOverdue {

    private Integer loid;
    private Integer uid;
    private Integer ltid;
    private String lodate;
    private Double lomoney;

    public Integer getLtid() {
        return ltid;
    }

    public void setLtid(Integer ltid) {
        this.ltid = ltid;
    }

    public Integer getLoid() {
        return loid;
    }

    public void setLoid(Integer loid) {
        this.loid = loid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLodate() {
        return lodate;
    }

    public void setLodate(String lodate) {
        this.lodate = lodate;
    }

    public Double getLomoney() {
        return lomoney;
    }

    public void setLomoney(Double lomoney) {
        this.lomoney = lomoney;
    }
}
