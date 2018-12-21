package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Education implements Serializable {

  @Id
  @GeneratedValue
  private Integer eid;
  private String ename;
}
