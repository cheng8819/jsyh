package com.example.jsproducerfund.controller;

import com.example.jsproducerfund.pojo.FundInfo;
import com.example.jsproducerfund.service.Impl.BuyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 18:25
 */

@Api("基金购买/赎回操作api")
@Controller
public class BuyController {

    @Autowired
    private BuyServiceImpl buyService;

    @ApiOperation(value = "购买基金产品",notes = "购买基金")
    @ResponseBody
    @RequestMapping(value = "/buyFund",method = RequestMethod.GET)
    public String buyFund(@RequestParam("fund_number") String fund_number,@RequestParam("username") String username,@RequestParam("fund_money") Double fund_money){
        return buyService.buyFund(fund_number,username,fund_money);
    }

    @ApiOperation(value = "赎回基金产品",notes = "赎回基金")
    @ResponseBody
    @RequestMapping(value = "/sellFund",method = RequestMethod.GET)
    public String sellFund(@RequestParam("fundName") String fundName,@RequestParam("num") Integer num,@RequestParam("username") String username){
        return buyService.sellFund(fundName,num,username);
    }

    @ApiOperation(value = "查看购买基金信息",notes = "查询购买基金信息")
    @ResponseBody
    @RequestMapping(value = "/showBuyFund",method = RequestMethod.GET)
    public String showBuyFund(@RequestParam("username") String username, @RequestParam(value = "fund_number",required = false) String fund_number){
        return buyService.selBuyFund(username,fund_number);
    }

    @ApiOperation(value = "基金定投",notes = "任务名称，执行时间")
    @ResponseBody
    @RequestMapping(value = "/AIP",method = RequestMethod.GET)
    public String AIP(String jobName,String time){
        return buyService.automaticInvestmentPlan(jobName,time);
    }


    @ApiOperation(value = "按时间区间查询基金购买记录",notes = "用户标识，开始时间，结束时间")
    @ResponseBody
    @RequestMapping(value = "/showBuyInfoByTime",method = RequestMethod.GET)
    public String showBuyInfoByTime(@RequestParam("username") String username,@RequestParam("startTime") String startTime,@RequestParam("stopTime") String stopTime){
        return buyService.showBuyInfoByTime(username,startTime,stopTime);
    }


    @ApiOperation(value = "按时间区间查询基金赎回记录",notes = "用户标识，开始时间，结束时间")
    @ResponseBody
    @RequestMapping(value = "/showSellInfoByTime",method = RequestMethod.GET)
    public String showSellInfoByTime(@RequestParam("username") String username,@RequestParam("startTime") String startTime,@RequestParam("stopTime") String stopTime){
        return buyService.showSellInfoByTime(username,startTime,stopTime);
    }

}
