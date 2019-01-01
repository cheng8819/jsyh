package com.example.jscosumerfund.service;

import com.example.jscosumerfund.pojo.FundUser;
import com.example.jscosumerfund.service.Impl.FundServiceImpl;
import feign.Param;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(value = "js-producer-fund",fallback = FundServiceImpl.class)
public interface FundService {

    @ResponseBody
    @RequestMapping(value = "/showNewFunds",method = RequestMethod.GET)
    public String showNewFunds();

    @ResponseBody
    @RequestMapping(value = "/showFunds",method = RequestMethod.GET)
    public String showFunds(@RequestParam("fundType") String fundType);

    @ResponseBody
    @RequestMapping(value = "/selFunds",method = RequestMethod.GET)
    public String selFunds();

    @ResponseBody
    @RequestMapping(value = "/showFundDetails",method = RequestMethod.POST)
    public String showFundDetails(@RequestParam("fundName")String fundName);

    @ResponseBody
    @RequestMapping(value = "/fundAccount",method = RequestMethod.POST)
    public String fundAccount(@RequestBody FundUser fundUser);

    @ResponseBody
    @RequestMapping(value = "/showBuyFund",method = RequestMethod.GET)
    public String showBuyFund(@RequestParam("username") String username, @RequestParam("fund_number") String fund_number);

}
