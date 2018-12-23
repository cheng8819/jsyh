package com.example.jsconsumerloans.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Loantype implements Serializable {

    private Integer lid;
    private String ltname;
}
