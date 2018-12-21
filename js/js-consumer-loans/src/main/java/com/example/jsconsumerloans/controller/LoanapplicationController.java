package com.example.jsconsumerloans.controller;

import com.example.jsconsumerloans.feign.LoanApplication;
import com.example.jsconsumerloans.pojo.LoansUserinfo;
import com.example.jsconsumerloans.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "贷款申请controller", tags = {"贷款申请操作接口"})
@RestController
@RequestMapping("/loanapplication")
public class LoanapplicationController {

    @Autowired
    private LoanApplication loanApplication;

    @ApiOperation(value = "创建申请表单", httpMethod = "POST")
    @PostMapping("/loanapplications")
    public Result loanApplications(@ApiParam(name = "loansUserinfo", value = "贷款申请表单对象json格式", required = true) @RequestBody LoansUserinfo loansUserinfo){
        return loanApplication.loanApplications(loansUserinfo);
    }

    @ApiOperation(value = "获取指定审核人需要审核的贷款申请", httpMethod = "GET")
    @RequestMapping("/getTaskByUserId/{userId}")
    public Object getTaskByUserId(@ApiParam(name = "userId", value = "审核人ID", required = true) @PathVariable("userId") String userId) {
        return loanApplication.getTaskByUserId(userId);
    }

    @ApiOperation(value = "处理待审核的贷款申请", httpMethod = "GET")
    @RequestMapping("/completeTask/{taskId}/{userId}/{audit}")
    public Result completeTask(@ApiParam(name = "taskId", value = "审批的任务id", required = true) @PathVariable("taskId") String taskId,
                               @ApiParam(name = "userId", value = "审核人ID", required = true) @PathVariable("userId") String userId,
                               @ApiParam(name = "audit", value = "审核结果通过（cg）未通过（sb）", required = true) @PathVariable("audit") String audit) {
        return loanApplication.completeTask(taskId, userId, audit);
    }
}
