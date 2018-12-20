package com.example.jsproducerloans.controller;

import com.example.jsproducerloans.pojo.LoansUserinfo;
import com.example.jsproducerloans.service.LoanApplication;
import com.example.jsproducerloans.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loanapplication")
public class LoanApplicationController {

    @Autowired
    private LoanApplication loanApplication;

    @PostMapping("/loanapplications")
    public Result loanApplications(@RequestBody LoansUserinfo loansUserinfo){
        return loanApplication.registerInfo(loansUserinfo);
    }
}
