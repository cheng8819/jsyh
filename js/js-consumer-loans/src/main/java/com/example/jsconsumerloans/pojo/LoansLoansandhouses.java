package com.example.jsconsumerloans.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class LoansLoansandhouses implements Serializable {

    private Integer lhid;
    private Double lhmoney;
    private Double lhdownpayment;
    private Double lhcommercialmoney;
    private Integer lhdate;
    private Integer lhuid;
}
