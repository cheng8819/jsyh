package com.example.jsproducerloans.controllerpojo;

import lombok.Data;

import javax.persistence.Id;

@Data
public class LoansTransactionSchedule {

    @Id
    private Integer liid;
    private String litype;
    private Double linumber;
    private Integer linumberofperiods;
    private String lidate;
    private String schedule;
}
