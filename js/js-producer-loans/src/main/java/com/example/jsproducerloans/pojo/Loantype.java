package com.example.jsproducerloans.pojo;

import lombok.Data;

@Data
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

}
