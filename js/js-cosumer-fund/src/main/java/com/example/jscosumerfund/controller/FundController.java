package com.example.jscosumerfund.controller;

import com.alibaba.fastjson.JSON;
import com.example.jscosumerfund.pojo.FundInfo;
import com.example.jscosumerfund.service.FundService;
import com.example.jscosumerfund.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @auther: 666先生的救赎
 * @date: 2018/12/26 22:19
 */
@RestController
@CrossOrigin(origins="*", maxAge = 3600,allowCredentials = "true")
public class FundController {

    @Autowired
    private FundService fundService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/showNewFunds",method = RequestMethod.GET)
    public String showNewFunds(){
        return fundService.showNewFunds();
    }

    @RequestMapping(value = "/showOldFunds",method = RequestMethod.GET)
    public String showFunds(@RequestParam("fundType") String fundType){
        return fundService.showOldFunds(fundType);
    }

    @RequestMapping(value = "/showAllFunds",method = RequestMethod.POST)
    public String showAllFunds(FundInfo fundInfo){
        return fundService.showAllFunds(fundInfo);
    }

    @RequestMapping(value = "/showFundDetails",method = RequestMethod.GET)
    public String showFundDetails(@RequestParam("fundNumber")String fundNumber){
        return fundService.showFundDetails(fundNumber);
    }

    @RequestMapping(value = "/setKey",method = RequestMethod.POST)
    public boolean setKey(String key,Object object){
        return redisUtil.set(key,object);
    }

    @RequestMapping(value = "/getKey",method = RequestMethod.POST)
    public String getKey(String key){
        return JSON.toJSONString(redisUtil.get(key));
    }

}
