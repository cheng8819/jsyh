package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class LeaveInfo {

  @Id
  private String id;
  private String status;
  private Integer loansid;

}
