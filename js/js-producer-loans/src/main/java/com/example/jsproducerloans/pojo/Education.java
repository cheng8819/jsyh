package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Education {

  @Id
  @GeneratedValue
  private Integer eid;
  private String ename;
}
