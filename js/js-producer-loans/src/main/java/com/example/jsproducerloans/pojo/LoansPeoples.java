package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class LoansPeoples {
    @Id
    @GeneratedValue
    private Integer lpid;
    private String lpnumber;
}
