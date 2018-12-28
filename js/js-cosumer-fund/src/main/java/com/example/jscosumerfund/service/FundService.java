package com.example.jscosumerfund.service;

import com.example.jscosumerfund.service.Impl.FundServiceImpl;
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
    public String showFunds(@RequestParam("request") HttpServletRequest request,@RequestParam("response") HttpServletResponse response);

    @ResponseBody
    @RequestMapping(value = "/selFunds",method = RequestMethod.GET)
    public String selFunds();

    @ResponseBody
    @RequestMapping(value = "/showFundDetails",method = RequestMethod.POST)
    public String showFundDetails(@RequestParam("fundName")String fundName);

}
