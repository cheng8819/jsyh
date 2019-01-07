package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class LoansUserinfo implements Serializable {

    @Id
    private String luid;
    private Integer luuid;
    private Integer lueducation;
    private Integer lujob;
    private String luunit;
    private Integer lumarriage;
    private Integer lufamilynum;
    private Double lufamilyincome;
}
