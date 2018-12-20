package com.example.jsproducerloans.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class LoansLoansandhouses {

    @Id
    @GeneratedValue
    private Integer lhid;
    private Double lhmoney;
    private Double lhdownpayment;
    private Double lhcommercialmoney;
    private Integer lhdate;
    private Integer lhuid;
}
