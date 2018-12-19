package com.example.jsproducerloans.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerloans.service.Pledge;
import com.example.jsproducerloans.util.Result;
import com.example.jsproducerloans.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value="贷款controller",tags={"贷款操作接口"})
@RestController
@RequestMapping("loantypes")
public class LoantypeController {

    @Autowired
    private Pledge pledge;

    @ApiOperation(value="获取全部贷款类型",httpMethod = "GET")
    @RequestMapping("allloantype")
    public Result allLoantype(){
        return ResultUtil.success(JSON.toJSON(pledge.allLoantype()));
    }
}
