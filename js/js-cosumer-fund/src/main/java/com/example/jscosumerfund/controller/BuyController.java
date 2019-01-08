package com.example.jscosumerfund.controller;

import com.example.jscosumerfund.service.BuyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 21:43
 */

@RestController
@CrossOrigin(origins="*")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @ApiOperation(value = "购买基金产品",notes = "购买基金")
    @RequestMapping(value = "/buyFund",method = RequestMethod.GET)
    public String buyFund(@RequestParam("fund_number") String fund_number,@RequestParam("username") String username,@RequestParam("fund_money") Double fund_money){
        return buyService.buyFund(fund_number,username,fund_money);
    }

    @ApiOperation(value = "赎回基金产品",notes = "赎回基金")
    @RequestMapping(value = "/selFund",method = RequestMethod.GET)
    public String selFund(@RequestParam("fundName") String fundName,@RequestParam("username") String username){
        return buyService.selFund(fundName,username);
    }

    @ApiOperation(value = "查看购买基金信息",notes = "查询购买基金信息")
    @RequestMapping(value = "/showBuyFund",method = RequestMethod.GET)
    public String showBuyFund(@RequestParam("username") String username, @RequestParam(value = "fund_number",required = false) String fund_number){
        return buyService.showBuyFund(username,fund_number);
    }

}
