package com.example.jsproducerloans.pojo;


public class Loantype {

  private Integer lid;
  private String ltname;

  public Integer getLid() {
    return lid;
  }

  public void setLid(Integer lid) {
    this.lid = lid;
  }

  public String getLtname() {
    return ltname;
  }

  public void setLtname(String ltname) {
    this.ltname = ltname;
  }

  @Override
  public String toString() {
    return "Loantype{" +
            "ltid=" + lid +
            ", ltname='" + ltname + '\'' +
            '}';
  }
}
