package com.example.jsconsumerloans.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoansOverdue implements Serializable {

    private Integer loid;
    private Integer uid;
    private Integer ltid;
    private String lodate;
    private Double lomoney;
}
