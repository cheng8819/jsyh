package com.example.jscosumerfund.controller;

import com.example.jscosumerfund.pojo.FundUser;
import com.example.jscosumerfund.service.FundService;
import feign.Param;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @auther: 666先生的救赎
 * @date: 2018/12/26 22:19
 */
@RestController
public class FundController {

    @Autowired
    private FundService fundService;

    @Autowired
    private HttpServletRequest request;


    @RequestMapping(value = "/showNewFunds",method = RequestMethod.GET)
    public String showNewFunds(HttpServletRequest request,HttpServletResponse response){
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        return fundService.showNewFunds();
    }

    @RequestMapping(value = "/showFunds",method = RequestMethod.GET)
    public String showFunds(@RequestParam("fundType") String fundType,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return fundService.showFunds(fundType);
    }

    @RequestMapping(value = "/selFunds",method = RequestMethod.GET)
    public String selFunds(HttpServletRequest request, HttpServletResponse response){
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        return fundService.selFunds();
    }

    @RequestMapping(value = "/showFundDetails",method = RequestMethod.POST)
    public String showFundDetails(@RequestParam("fundName")String fundName){
        return fundService.showFundDetails(fundName);
    }

    @ApiOperation(value = "基金开户",notes = "基金开户，短信验证")
    @RequestMapping(value = "/fundAccount",method = RequestMethod.POST)
    public String fundAccount(@RequestBody FundUser fundUser,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return fundService.fundAccount(fundUser);
    }

    @ApiOperation(value = "查看购买基金信息",notes = "查询购买基金信息")
    @ResponseBody
    @RequestMapping(value = "/showBuyFund",method = RequestMethod.GET)
    public String showBuyFund(@RequestParam("username") String username, @RequestParam("fundNumber") String fundNumber,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return fundService.showBuyFund(username,fundNumber);
    }

}
