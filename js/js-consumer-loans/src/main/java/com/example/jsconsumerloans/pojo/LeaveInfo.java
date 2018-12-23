package com.example.jsconsumerloans.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LeaveInfo implements Serializable {

  private String id;
  private String status;
  private String loansid;
  private String taskId;

}
