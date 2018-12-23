package com.example.jsconsumerloans.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RepaymentType implements Serializable {

    private Integer rtid;
    private String rtname;
}
