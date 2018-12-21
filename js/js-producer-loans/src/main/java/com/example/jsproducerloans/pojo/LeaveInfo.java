package com.example.jsproducerloans.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class LeaveInfo implements Serializable {

  @Id
  private String id;
  private String status;
  private Integer loansid;
  private String taskId;

}
