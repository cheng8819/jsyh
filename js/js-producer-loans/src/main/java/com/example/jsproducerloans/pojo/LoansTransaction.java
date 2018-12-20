package com.example.jsproducerloans.pojo;

import lombok.Data;

@Data
public class LoansTransaction {

    private Integer liid;
    private Integer liuid;
    private Integer litype;
    private Double linumber;
    private Integer linumberofperiods;
    private Integer listate;
    private String lidate;

}
