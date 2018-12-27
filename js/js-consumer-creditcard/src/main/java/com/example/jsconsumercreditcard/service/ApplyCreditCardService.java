package com.example.jsconsumercreditcard.service;


import com.example.jsconsumercreditcard.entity.CreditUserinfo;
import com.example.jsconsumercreditcard.entity.LeaveInfo;
import com.example.jsconsumercreditcard.util.Result;

import java.util.List;

public interface ApplyCreditCardService {

    /**
     * 申请信用卡
     * @param creditUserinfo 表单信息
     * @return
     */
    Result applyCreditCard(CreditUserinfo creditUserinfo);

    /**
     * 以申请表单记录id添加一条流程
     * @param leid 表单记录id
     */
    void addLeaveAInfo(String leid);

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

    /**
     * 根据uid查询办卡进度
     * @param uid 用户id
     * @return
     */
    Result handleCardProgress(Integer uid);
}
