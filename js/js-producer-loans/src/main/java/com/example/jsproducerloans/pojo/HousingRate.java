package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class HousingRate {

  @Id
  private Integer lrid;
  private Double lrratemonth;
  private Double lrrateyear;
}
