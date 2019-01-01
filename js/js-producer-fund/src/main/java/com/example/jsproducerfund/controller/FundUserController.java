package com.example.jsproducerfund.controller;

import com.example.jsproducerfund.pojo.FundUser;
import com.example.jsproducerfund.pojo.RiskAppetite;
import com.example.jsproducerfund.service.Impl.FundUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 18:25
 */

@Api("基金用户操作api")
@Controller
public class FundUserController {

    @Autowired
    private FundUserServiceImpl fundUserService;

    @ApiOperation(value = "风险承受能力测试",notes = "12个选项必填")
    @ResponseBody
    @RequestMapping(value = "/riskToleranceTest",method = RequestMethod.GET)
    public String riskToleranceTest(@RequestBody(required = false) RiskAppetite riskAppetite){
        return fundUserService.riskToleranceTest(riskAppetite);
    }

    @ApiOperation(value = "基金开户",notes = "基金开户，短信验证")
    @ResponseBody
    @RequestMapping(value = "/fundAccount",method = RequestMethod.POST)
    public String fundAccount(@RequestBody(required = false) FundUser fundUser){
        return fundUserService.addFundAccount(fundUser);
    }

}
