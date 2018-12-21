package com.example.jsproducerloans.controller;

import com.example.jsproducerloans.pojo.LoansUserinfo;
import com.example.jsproducerloans.service.LoanApplication;
import com.example.jsproducerloans.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loanapplication")
public class LoanApplicationController {

    @Autowired
    private LoanApplication loanApplication;

    //申请贷款
    @PostMapping("/loanapplications")
    public Result loanApplications(@RequestBody LoansUserinfo loansUserinfo){
        return loanApplication.registerInfo(loansUserinfo);
    }
    //获取指定审核人需要审核的贷款申请
    @RequestMapping("/getTaskByUserId/{userId}")
    public Object getTaskByUserId(@PathVariable("userId") String userId) {
        //System.out.println();
        return loanApplication.getByUserId(userId);
    }
    //处理待审核的贷款申请
    @RequestMapping("/completeTask/{taskId}/{userId}/{audit}")
    public Result completeTask(@PathVariable("taskId") String taskId, @PathVariable("userId") String userId,@PathVariable("audit") String audit) {
        return loanApplication.completeTaskByUser(taskId, userId, audit);
    }
}
