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
}
