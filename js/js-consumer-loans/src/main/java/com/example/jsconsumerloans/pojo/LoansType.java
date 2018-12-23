package com.example.jsconsumerloans.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class LoansType implements Serializable {

    private Integer ltid;
    private String lttype;
}
