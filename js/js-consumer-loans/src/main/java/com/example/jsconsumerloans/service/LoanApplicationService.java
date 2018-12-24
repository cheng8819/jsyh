package com.example.jsconsumerloans.service;

import com.example.jsconsumerloans.pojo.LeaveInfo;
import com.example.jsconsumerloans.pojo.LoansTransaction;
import com.example.jsconsumerloans.pojo.LoansUserinfo;
import com.example.jsconsumerloans.util.Result;

import java.util.List;

public interface LoanApplicationService {

    /**
     * 申请贷款
     * @param loansUserinfo
     * @param id 临时订单id
     * @return
     */
    Result loanApplica(LoansUserinfo loansUserinfo,Long id);

    /**
     * 生成订单
     * @param loansTransaction
     * @return
     */
    Result createOrder(LoansTransaction loansTransaction);

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
}
