package com.example.jscosumerfund.service;

import com.example.jscosumerfund.pojo.FundUser;
import com.example.jscosumerfund.pojo.RiskAppetite;
import com.example.jscosumerfund.service.Impl.FundUserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "js-producer-fund",fallback = FundUserServiceImpl.class)
public interface FundUserService {

    @ApiOperation(value = "风险承受能力测试",notes = "12个选项必填")
    @ResponseBody
    @RequestMapping(value = "/riskToleranceTest",method = RequestMethod.GET)
    public String riskToleranceTest(@RequestBody(required = false) RiskAppetite riskAppetite);

    @ApiOperation(value = "基金开户",notes = "基金开户，短信验证")
    @ResponseBody
    @RequestMapping(value = "/fundAccount",method = RequestMethod.POST)
    public String fundAccount(@RequestBody(required = false) FundUser fundUser);

}
