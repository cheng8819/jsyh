package com.example.jsconsumerloans.controller;

import com.example.jsconsumerloans.feign.LoanApplication;
import com.example.jsconsumerloans.pojo.LoansUserinfo;
import com.example.jsconsumerloans.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loanapplication")
public class LoanapplicationController {

    @Autowired
    private LoanApplication loanApplication;

    @PostMapping("/loanapplications")
    public Result loanApplications(@RequestBody LoansUserinfo loansUserinfo){
        return loanApplication.loanApplications(loansUserinfo);
    }
}
