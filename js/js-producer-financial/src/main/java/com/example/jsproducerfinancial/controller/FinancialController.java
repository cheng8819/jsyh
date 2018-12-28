package com.example.jsproducerfinancial.controller;

import com.example.jsproducerfinancial.pojo.BrowsingHistory;
import com.example.jsproducerfinancial.pojo.Finance;
import com.example.jsproducerfinancial.service.Impl.FinancialServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/21 11:19
 */
@Api("理财产品相关api")
@RestController
public class FinancialController {

    @Autowired
    private FinancialServiceImpl financialService;

    @ApiOperation(value = "查询理财产品信息",notes = "多字段查询，分页")
    @RequestMapping(value = "/showFinance",method = RequestMethod.GET)
    public String showFinance(@RequestBody Finance finance,@RequestParam Integer index){
        return financialService.showFinancial(finance,index);
    }

    @ApiOperation(value = "查询单个理财产品详情",notes = "根据产品名称查询")
    @RequestMapping(value = "/showFinancialDetails",method = RequestMethod.POST)
    public String showFinancialDetails(@RequestParam ("financeName")String financeName){
        return financialService.showFinancialDetails(financeName);
    }

    @ApiOperation(value = "购买理财产品",notes = "三个主要参数：产品信息、用户标识、金额")
    @ResponseBody
    @RequestMapping(value = "/buyFinance",method = RequestMethod.GET)
    public String buyFinance(Finance finance,String username,Double money){
        return financialService.buyFinancial(finance,username,money);
    }

    @ApiOperation(value = "查询已购买理财产品信息",notes = "根据用户标识查询")
    @ResponseBody
    @RequestMapping(value = "/showBuyFinancial",method = RequestMethod.GET)
    public String showBuyFinancial(String username){
        return financialService.showBuyFinancial(username);
    }

    @ApiOperation(value = "赎回理财产品",notes = "产品信息、用户标识")
    @ResponseBody
    @RequestMapping(value = "/sellFinancial",method = RequestMethod.GET)
    public String sellFinancial(Finance finance,String username){
        return financialService.sellFinancial(finance,username);
    }

    @ApiOperation(value = "添加浏览记录",notes = "产品信息、用户标识")
    @ResponseBody
    @RequestMapping(value = "/addBrowsingHistory",method = RequestMethod.GET)
    public String addBrowsingHistory(Finance finance,String username){
        return financialService.addBrowsingHistory(finance,username);
    }

    @ApiOperation(value = "添加浏览记录",notes = "产品信息、用户标识")
    @ResponseBody
    @RequestMapping(value = "/showBrowsingHistory",method = RequestMethod.GET)
    public String showBrowsingHistory(BrowsingHistory browsingHistory){
        return financialService.showBrowsingHistory(browsingHistory);
    }

    @ApiOperation(value = "计算理财产品收益",notes = "产品信息、用户标识")
    @ResponseBody
    @RequestMapping(value = "/calculateEarnings",method = RequestMethod.GET)
    public String calculateEarnings(Finance finance,String username){
        return financialService.calculateEarnings(finance,username);
    }

}
