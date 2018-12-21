package com.example.jsproducerloans.service;

import com.example.jsproducerloans.pojo.LeaveInfo;
import com.example.jsproducerloans.pojo.LoansUserinfo;
import com.example.jsproducerloans.util.Result;

import java.util.List;

public interface LoanApplication {

    /**
     * 录入登记信息
     * @param loansUserinfo
     * @return
     */
    Result registerInfo(LoansUserinfo loansUserinfo);

    /**
     * 以申请表单记录id添加一条流程
     * @param leid 表单记录id
     */
    void addLeaveAInfo(Integer leid);

    /**
     * 获取当前用户的任务
     * @param userId
     * @return
     */
    List<LeaveInfo> getByUserId(String userId);

    /**
     * 执行审批操作
     * @param taskId 审批的任务id
     * @param userId 审批人的名字
     * @param audit 审批通过（cg）/未通过(sb)
     * @return
     */
    Result completeTaskByUser(String taskId, String userId, String audit);
}
