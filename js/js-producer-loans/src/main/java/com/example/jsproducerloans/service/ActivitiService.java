package com.example.jsproducerloans.service;

import com.example.jsproducerloans.pojo.Auditor;
import com.example.jsproducerloans.pojo.LeaveInfo;

import java.util.List;

public interface ActivitiService {
    /**
     * 获取全部审核人
     * @return
     */
    List<Auditor> getAuditorsAll();

    /**
     * 根据申请单id查询申请单
     * @param id
     * @return
     */
    LeaveInfo findLeaveInfoById (String id);

    /**
     * 修改申请单状态
     * @param leaveInfo
     */
    String updateLeaveInfoState(LeaveInfo leaveInfo);


}
