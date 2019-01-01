package com.example.jscosumerfund.controller;

import com.example.jscosumerfund.pojo.FundUser;
import com.example.jscosumerfund.pojo.RiskAppetite;
import com.example.jscosumerfund.service.FundUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 22:27
 */

@RestController
@CrossOrigin(origins="*", maxAge = 3600,allowCredentials = "true")
public class FundUserController {

    @Autowired
    private FundUserService fundUserService;

    @ApiOperation(value = "风险承受能力测试",notes = "12个选项必填")
    @RequestMapping(value = "/riskToleranceTest",method = RequestMethod.POST)
    public String riskToleranceTest(@RequestBody(required = false) RiskAppetite riskAppetite){
        return fundUserService.riskToleranceTest(riskAppetite);
    };

    @ApiOperation(value = "基金开户",notes = "基金开户，短信验证")
    @RequestMapping(value = "/fundAccount",method = RequestMethod.POST)
    public String fundAccount(@RequestBody(required = false) FundUser fundUser){
        return fundUserService.fundAccount(fundUser);
    }

}
