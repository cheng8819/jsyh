package com.example.jscosumerfund.controller;

import com.example.jscosumerfund.service.FundService;
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


    @RequestMapping(value = "/showNewFunds",method = RequestMethod.GET)
    public String showNewFunds(HttpServletRequest request,HttpServletResponse response){
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        return fundService.showNewFunds();
    }

    @RequestMapping(value = "/showFunds",method = RequestMethod.GET)
    public String showFunds(HttpServletRequest request, HttpServletResponse response){
        return fundService.showFunds(request,response);
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

}
