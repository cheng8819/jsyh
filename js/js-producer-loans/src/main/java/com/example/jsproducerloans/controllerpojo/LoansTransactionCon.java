package com.example.jsproducerloans.controllerpojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class LoansTransactionCon {

    @Id
    private Integer liid;
    private Integer liuid;
    private String litype;
    private Double linumber;
    private Integer linumberofperiods;
    private String lidate;
}
