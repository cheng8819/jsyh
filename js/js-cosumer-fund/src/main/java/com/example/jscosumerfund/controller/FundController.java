package com.example.jscosumerfund.controller;

import com.example.jscosumerfund.pojo.FundInfo;
import com.example.jscosumerfund.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @auther: 666先生的救赎
 * @date: 2018/12/26 22:19
 */
@RestController
@CrossOrigin(origins="*", maxAge = 3600,allowCredentials = "true")
public class FundController {

    @Autowired
    private FundService fundService;


    @RequestMapping(value = "/showNewFunds",method = RequestMethod.GET)
    public String showNewFunds(HttpServletRequest request,HttpServletResponse response){
        //解决跨域问题
        //response.setHeader("Access-Control-Allow-Origin", "*");
        return fundService.showNewFunds();
    }

    @RequestMapping(value = "/showOldFunds",method = RequestMethod.GET)
    public String showFunds(@RequestParam("fundType") String fundType,HttpServletResponse response){
        //response.setHeader("Access-Control-Allow-Origin", "*");
        return fundService.showOldFunds(fundType);
    }

    @RequestMapping(value = "/showAllFunds",method = RequestMethod.POST)
    public String showAllFunds(@RequestBody(required = false) FundInfo fundInfo, HttpServletResponse response){
        //解决跨域问题
        //response.setHeader("Access-Control-Allow-Origin", "*");
        return fundService.showAllFunds(fundInfo);
    }

    @RequestMapping(value = "/showFundDetails",method = RequestMethod.GET)
    public String showFundDetails(@RequestParam("fundNumber")String fundNumber){
        return fundService.showFundDetails(fundNumber);
    }

}
