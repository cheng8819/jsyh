package com.example.jsconsumerloans.controller;

import com.example.jsconsumerloans.feign.LoanApplication;
import com.example.jsconsumerloans.pojo.LoansUserinfo;
import com.example.jsconsumerloans.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
