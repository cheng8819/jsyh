package com.example.jsconsumerloans.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoansTransaction implements Serializable {

    private Integer liid;
    private Integer liuid;
    private Integer litype;
    private Double linumber;
    private Integer linumberofperiods;
    private Integer listate;
    private String lidate;
    private String liapplicationdata;
    private Integer linumberofnoperiods;

}
