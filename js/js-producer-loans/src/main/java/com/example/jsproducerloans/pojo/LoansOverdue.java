package com.example.jsproducerloans.pojo;

import lombok.Data;

@Data
public class LoansOverdue {

    private Integer loid;
    private Integer uid;
    private Integer ltid;
    private String lodate;
    private Double lomoney;
}
