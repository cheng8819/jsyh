package com.example.jscosumerfund.service;

import com.example.jscosumerfund.service.Impl.BuyServiceImpl;
import com.example.jscosumerfund.service.Impl.FundServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "js-producer-fund",fallback = BuyServiceImpl.class)
public interface BuyService {

    @ApiOperation(value = "购买基金产品",notes = "购买基金")
    @ResponseBody
    @RequestMapping(value = "/buyFund",method = RequestMethod.GET)
    public String buyFund(@RequestParam("fund_number") String fund_number,@RequestParam("username") String username,@RequestParam("fund_money") Double fund_money);

    @ApiOperation(value = "赎回基金产品",notes = "赎回基金")
    @ResponseBody
    @RequestMapping(value = "/selFund",method = RequestMethod.GET)
    public String selFund(@RequestParam("fundName") String fundName,@RequestParam("username") String username);

    @ApiOperation(value = "查看购买基金信息",notes = "查询购买基金信息")
    @ResponseBody
    @RequestMapping(value = "/showBuyFund",method = RequestMethod.GET)
    public String showBuyFund(@RequestParam("username") String username, @RequestParam(value = "fund_number",required = false) String fund_number);

}
