package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class LoansUserinfo {

    @Id
    @GeneratedValue
    private Integer luid;
    private Integer luuid;
    private Integer lueducation;
    private Integer lujob;
    private String luunit;
    private Integer lumarriage;
    private Integer lufamilynum;
    private Double lufamilyincome;
}
