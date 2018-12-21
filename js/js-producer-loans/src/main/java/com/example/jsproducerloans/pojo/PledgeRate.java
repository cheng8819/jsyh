package com.example.jsproducerloans.pojo;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class PledgeRate {

  @Id
  private Integer lpid;
  private Double lproat;

}
