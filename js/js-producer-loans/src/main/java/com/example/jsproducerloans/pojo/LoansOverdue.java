package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class LoansOverdue {

    @Id
    @GeneratedValue
    private Integer loid;
    private Integer uid;
    private Integer ltid;
    private String lodate;
    private Double lomoney;
}
