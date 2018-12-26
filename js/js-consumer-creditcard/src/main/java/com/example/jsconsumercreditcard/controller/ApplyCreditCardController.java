package com.example.jsconsumercreditcard.controller;

import com.example.jsconsumercreditcard.entity.CreditUserinfo;
import com.example.jsconsumercreditcard.service.ApplyCreditCardService;
import com.example.jsconsumercreditcard.util.Result;
import com.example.jsconsumercreditcard.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "信用卡申请controller", tags = {"信用卡申请操作接口"})
public class ApplyCreditCardController {

    @Autowired
    private ApplyCreditCardService applyCreditCardService;

    @PostMapping("/test")
    @ApiOperation(value = "创建申请表单", httpMethod = "POST")
    public Result applyData(@ApiParam(name = "creditUserinfo", value = "信用卡申请表单对象json格式", required = true) @RequestBody CreditUserinfo creditUserinfo){
        return ResultUtil.success(applyCreditCardService.applyCreditCard(creditUserinfo));
    }
}
