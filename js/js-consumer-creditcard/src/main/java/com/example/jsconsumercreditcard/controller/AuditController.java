package com.example.jsconsumercreditcard.controller;

import com.example.jsconsumercreditcard.service.ApplyCreditCardService;
import com.example.jsconsumercreditcard.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "信用卡审批controller", tags = {"信用卡审批操作接口"})
@RequestMapping("/AuditController")
public class AuditController {

    @Autowired
    private ApplyCreditCardService applyCreditCardService;

    @ApiOperation(value = "获取指定审核人需要审核的贷款申请", httpMethod = "GET")
    @RequestMapping("/getTaskByUserId/{userId}")
    public Object getTaskByUserId(@ApiParam(name = "userId", value = "审核人ID", required = true) @PathVariable("userId") String userId) {
        return applyCreditCardService.getByUserId(userId);
    }

    @ApiOperation(value = "处理待审核的贷款申请", httpMethod = "GET")
    @RequestMapping("/completeTask/{taskId}/{userId}/{audit}")
    public Result completeTask(@ApiParam(name = "taskId", value = "审批的任务id", required = true) @PathVariable("taskId") String taskId,
                               @ApiParam(name = "userId", value = "审核人ID", required = true) @PathVariable("userId") String userId,
                               @ApiParam(name = "audit", value = "审核结果通过（cg）未通过（sb）", required = true) @PathVariable("audit") String audit) {
        return applyCreditCardService.completeTaskByUser(taskId, userId, audit);
    }
}
