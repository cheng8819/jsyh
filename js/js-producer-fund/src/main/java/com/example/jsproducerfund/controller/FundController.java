package com.example.jsproducerfund.controller;

import com.example.jsproducerfund.pojo.*;
import java.util.List;
import com.example.jsproducerfund.service.Impl.FundServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 11:49
 */
@Api("基金相关api")
@Controller
public class FundController {

    @Autowired
    private FundServiceImpl fundService;

    @ApiOperation(value = "查询新发布基金产品信息",notes = "支持分页查询、多字段查询")
    @ResponseBody
    @RequestMapping(value = "/showNewFunds",method = RequestMethod.GET)
    public String showNewFunds(){
        return fundService.showNewFunds();
    }

    /**
     * @return
     */
    @ApiOperation(value = "查询已上市基金产品信息",notes = "支持多字段查询，支持分页查询,index参数 1:上一页  -1:下一页")
    @ResponseBody
    @RequestMapping(value = "/showFunds",method = RequestMethod.GET)
    public String showFunds(@RequestParam("fundType") String fundType){
        return fundService.showFunds(fundType);
    }

    /**
     * @return
     */
    @ApiOperation(value = "查询已上市基金产品净值",notes = "支持多字段查询，支持分页查询,index参数 1:上一页  -1:下一页")
    @ResponseBody
    @RequestMapping(value = "/selFunds",method = RequestMethod.GET)
    public String selFunds(){
        return fundService.selFunds();
    }

    @ApiOperation(value = "查询基金产品详情",notes = "根据基金名称查找")
    @ResponseBody
    @RequestMapping(value = "/showFundDetails",method = RequestMethod.POST)
    public String showFundDetails(@RequestParam("fundName") String fundName){
        return fundService.showFundDetails(fundName);
    }

    /**
     * 收藏基金
     * @param fund_name 基金名称
     * @param fund_number 基金代码
     * @param username 用户名/真实姓名
     * @return result
     *
     * @desc:谁点的收藏？收藏哪个基金？
     */
    @ApiOperation(value = "收藏基金产品",notes = "收藏")
    @ResponseBody
    @RequestMapping(value = "/collectFund",method = RequestMethod.GET)
    public String collectFund(String fund_name,String fund_number,String username){
        return fundService.collectFund(fund_name,fund_number,username);
    }

    @ApiOperation(value = "收藏基金产品展示",notes = "收藏基金展示")
    @ResponseBody
    @RequestMapping(value = "/showCollection",method = RequestMethod.GET)
    public String showCollection(String username){
        return fundService.selCollection(username);
    }

    @ApiOperation(value = "购买基金产品",notes = "购买基金")
    @ResponseBody
    @RequestMapping(value = "/buyFund",method = RequestMethod.GET)
    public String buyFund(FundInfo fundInfo,String username,Double fund_money){
        return fundService.buyFund(fundInfo,username,fund_money);
    }

    @ApiOperation(value = "赎回基金产品",notes = "赎回基金")
    @ResponseBody
    @RequestMapping(value = "/selFund",method = RequestMethod.GET)
    public String selFund(String fundName,String username){
        return fundService.sellFund(fundName,username);
    }

    @ApiOperation(value = "查看购买基金信息",notes = "查询购买基金信息")
    @ResponseBody
    @RequestMapping(value = "/showBuyFund",method = RequestMethod.GET)
    public String showBuyFund(@RequestParam("username") String username, @RequestParam("fund_number") String fund_number){
        return fundService.selBuyFund(username,fund_number);
    }

    @ApiOperation(value = "风险承受能力测试",notes = "12个选项必填")
    @ResponseBody
    @RequestMapping(value = "/riskToleranceTest",method = RequestMethod.GET)
    public String riskToleranceTest(RiskAppetite riskAppetite){
        return fundService.riskToleranceTest(riskAppetite);
    }

    @ApiOperation(value = "基金开户",notes = "基金开户，短信验证")
    @ResponseBody
    @RequestMapping(value = "/fundAccount",method = RequestMethod.GET)
    public String fundAccount(FundUser fundUser){
        return fundService.addFundAccount(fundUser);
    }

    @ApiOperation(value = "基金定投",notes = "任务名称，执行时间")
    @ResponseBody
    @RequestMapping(value = "/AIP",method = RequestMethod.GET)
    public String AIP(String jobName,String time){
        return fundService.automaticInvestmentPlan(jobName,time);
    }

}
