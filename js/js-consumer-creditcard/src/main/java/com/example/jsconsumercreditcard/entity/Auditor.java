package com.example.jsconsumercreditcard.entity;

import java.io.Serializable;

/**
 * (Auditor)实体类
 *
 * @author makejava
 * @since 2018-12-25 17:44:17
 */
public class Auditor implements Serializable {
    private static final long serialVersionUID = -88835467927867499L;
    
    private Integer aid;
    //审核人姓名
    private String aname;


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

}