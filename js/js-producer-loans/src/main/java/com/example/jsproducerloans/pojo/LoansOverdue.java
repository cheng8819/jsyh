package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class LoansOverdue implements Serializable {

    @Id
    @GeneratedValue
    private Integer loid;
    private Integer uid;
    private Integer ltid;
    private String lodate;
    private Double lomoney;
}
