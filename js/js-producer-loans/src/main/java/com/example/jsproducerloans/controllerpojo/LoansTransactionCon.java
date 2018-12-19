package com.example.jsproducerloans.controllerpojo;


public class LoansTransactionCon {

  private Integer liid;
  private Integer liuid;
  private String litype;
  private Double linumber;
  private Integer linumberofperiods;

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

  public String getLitype() {
    return litype;
  }

  public void setLitype(String litype) {
    this.litype = litype;
  }

  public Double getLinumber() {
    return linumber;
  }

  public void setLinumber(Double linumber) {
    this.linumber = linumber;
  }
}
