package com.example.jsconsumercreditcard.controller;

import com.example.jsconsumercreditcard.entity.CreditUserinfo;
import com.example.jsconsumercreditcard.service.ApplyCreditCardService;
import com.example.jsconsumercreditcard.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "信用卡申请controller", tags = {"信用卡申请操作接口"})
@RequestMapping("/applyCreditCardController")
public class ApplyCreditCardController {

    @Autowired
    private ApplyCreditCardService applyCreditCardService;

    @PostMapping("/applyData")
    @ApiOperation(value = "创建申请表单", httpMethod = "POST")
    public Result applyData(@ApiParam(name = "creditUserinfo", value = "信用卡申请表单对象json格式", required = true) @RequestBody CreditUserinfo creditUserinfo){
        return applyCreditCardService.applyCreditCard(creditUserinfo);
    }

    @GetMapping("/cardSchedule/{uid}")
    @ApiOperation(value = "获取用户的申卡进度", httpMethod = "GET")
    public Result cardSchedule(@ApiParam(name = "uid", value = "用户ID", required = true) @PathVariable("uid") Integer uid){
        return applyCreditCardService.handleCardProgress(uid);
    }
}
