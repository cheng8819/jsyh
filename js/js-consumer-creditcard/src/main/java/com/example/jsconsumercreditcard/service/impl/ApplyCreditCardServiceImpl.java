package com.example.jsconsumercreditcard.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsconsumercreditcard.entity.CreditUserinfo;
import com.example.jsconsumercreditcard.entity.CurrentType;
import com.example.jsconsumercreditcard.entity.LeaveInfo;
import com.example.jsconsumercreditcard.feign.ApplyCreditCardFeign;
import com.example.jsconsumercreditcard.pojocontroller.CardProgress;
import com.example.jsconsumercreditcard.service.ApplyCreditCardService;
import com.example.jsconsumercreditcard.service.ov.ApplyCreaditService;
import com.example.jsconsumercreditcard.util.IdWorker;
import com.example.jsconsumercreditcard.util.Result;
import com.example.jsconsumercreditcard.util.ResultUtil;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplyCreditCardServiceImpl implements ApplyCreditCardService {

    @Resource
    private ApplyCreditCardFeign applyCreditCardFeign;
    @Autowired
    private ApplyCreaditService applyCreaditService;
    @Resource
    private RuntimeService runtimeService;

    /**
     * 申请信用卡
     *
     * @param creditUserinfo 表单信息
     * @return
     */
    @Override
    public Result applyCreditCard(CreditUserinfo creditUserinfo) {
        Long id = null;
        try {
            id = new IdWorker(15).nextId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        creditUserinfo.setCuid(id.toString());
        Result result = applyCreditCardFeign.addCreditUserinfo(creditUserinfo);
        if(result.getData() != null){
            addLeaveAInfo(id.toString());
            return ResultUtil.success("申请提交成功");
        }else{
            return ResultUtil.success("申请提交失败");
        }
    }

    /**
     * 以申请表单记录id添加一条流程
     *
     * @param leid 表单记录id
     */
    @Override
    public void addLeaveAInfo(String leid) {
        LeaveInfo leaveInfo = new LeaveInfo();
        leaveInfo.setLoansid(leid);
        Long id = null;
        try {
            id = new IdWorker(15).nextId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        leaveInfo.setId(id.toString());
        //新增一条记录至数据库中
        applyCreditCardFeign.addLeaveInfo(leaveInfo);
        //启动流程引擎
        applyCreaditService.startProcess(id.toString());
    }

    /**
     * 获取当前用户的任务
     *
     * @param userId
     * @return
     */
    @Override
    public List<LeaveInfo> getByUserId(String userId) {
        ArrayList<LeaveInfo> leaveInfoList = new ArrayList<>();
        List<Task> list = applyCreaditService.findTaskByUserId(userId);
        for (Task task : list) {
            ProcessInstance result = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
            //获得业务流程的bussinessKey
            String businessKey = result.getBusinessKey();
            String results = (String) applyCreditCardFeign.selectOneLeaveInfo(businessKey).getData();
            LeaveInfo leaveInfo = JSON.parseObject(results,LeaveInfo.class);
            if(leaveInfo != null) {
                leaveInfo.setTaskId(task.getId());
                leaveInfoList.add(leaveInfo);
            }
        }
        return leaveInfoList;
    }

    /**
     * 执行审批操作
     *
     * @param taskId 审批的任务id
     * @param userId 审批人的名字
     * @param audit  审批通过（cg）/未通过(sb)
     * @return
     */
    @Override
    public Result completeTaskByUser(String taskId, String userId, String audit) {
        return ResultUtil.success(applyCreaditService.completeTaskByUser(taskId, userId, audit));
    }

    /**
     * 根据uid查询办卡进度
     *
     * @param uid 用户id
     * @return
     */
    @Override
    public Result handleCardProgress(Integer uid) {
        String str ;
        String result = (String) applyCreditCardFeign.creditUserinfoByUid(uid).getData();
        List<CreditUserinfo> creditUserinfos = JSON.parseArray(result,CreditUserinfo.class);
        List<CardProgress> cardProgresses = new ArrayList<>();
        for(CreditUserinfo creditUserinfo : creditUserinfos){
            CardProgress cardProgress = new CardProgress();
            String result1 = (String) applyCreditCardFeign.findCurrentTypeById(creditUserinfo.getCucardtype()).getData();
            CurrentType currentType = JSON.parseObject(result1,CurrentType.class);
            cardProgress.setCardType(currentType.getCtname());
            String result2 = (String) applyCreditCardFeign.findLeaveInfoByCuid(creditUserinfo.getCuid()).getData();
            LeaveInfo leaveInfo = JSON.parseObject(result2,LeaveInfo.class);
            switch (leaveInfo.getStatus()){
                case "pass":
                    str = "申请通过";
                    break;
                case "sb":
                    str = "申请不通过";
                    break;
                case "ing":
                    str = "审核中";
                    break;
                default:
                    str = "";
            }
            cardProgress.setRateOfProgress(str);
            cardProgresses.add(cardProgress);
        }
        return ResultUtil.success(cardProgresses);
    }
}
