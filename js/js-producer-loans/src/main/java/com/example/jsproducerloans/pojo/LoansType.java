package com.example.jsproducerloans.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class LoansType {

    @Id
    @GeneratedValue
    private Integer ltid;
    private String lttype;
}
