package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class LoansTransaction {

    @Id
    @GeneratedValue
    private Integer liid;
    private Integer liuid;
    private Integer litype;
    private Double linumber;
    private Integer linumberofperiods;
    private Integer listate;
    private String lidate;

}
