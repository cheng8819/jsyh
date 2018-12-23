package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class LoansTransaction implements Serializable {

    @Id
    @GeneratedValue
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
