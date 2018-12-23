package com.example.jsconsumerloans.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoansUserinfo implements Serializable {

    private String luid;
    private Integer luuid;
    private Integer lueducation;
    private Integer lujob;
    private String luunit;
    private Integer lumarriage;
    private Integer lufamilynum;
    private Double lufamilyincome;
}
