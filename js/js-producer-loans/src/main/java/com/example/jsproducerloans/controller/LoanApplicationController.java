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

    /**
     * 根据uid查询用户贷款申请进度
     * @param uid
     * @return
     */
    @GetMapping("/loanScheduleCon/{uid}")
    public Result LoanScheduleCon(@PathVariable("uid") Integer uid){
        return loanApplication.SelectLoanSchedule(uid);
    }

}
