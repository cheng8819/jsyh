package com.example.jsconsumercreditcard.entity;

import java.io.Serializable;

/**
 * (LeaveInfo)实体类
 *
 * @author makejava
 * @since 2018-12-25 16:50:33
 */
public class LeaveInfo implements Serializable {
    private static final long serialVersionUID = 679970311354356351L;
    
    private String id;
    
    private String status;
    
    private String loansid;
    
    private String taskId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoansid() {
        return loansid;
    }

    public void setLoansid(String loansid) {
        this.loansid = loansid;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

}