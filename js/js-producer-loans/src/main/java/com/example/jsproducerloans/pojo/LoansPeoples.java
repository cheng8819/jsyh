package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class LoansPeoples implements Serializable {
    @Id
    @GeneratedValue
    private Integer lpid;
    private String lpnumber;
}
