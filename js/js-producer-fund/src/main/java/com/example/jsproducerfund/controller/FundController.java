package com.example.jsproducerfund.controller;

import com.example.jsproducerfund.pojo.FundInfo;
import com.example.jsproducerfund.service.Impl.FundServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 11:49
 */
@Api("基金信息api")
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
    @ApiOperation(value = "查询已上市基金产品信息",notes = "按类型字段查询，支持分页查询,index参数 1:上一页  -1:下一页")
    @ResponseBody
    @RequestMapping(value = "/showOldFunds",method = RequestMethod.GET)
    public String showOldFunds(@RequestParam("fundType") String fundType){
        return fundService.showOldFunds(fundType);
    }

    /**
     * @return
     */
    @ApiOperation(value = "查询全部基金产品信息",notes = "支持多字段查询，支持分页查询,index参数 1:上一页  -1:下一页")
    @ResponseBody
    @RequestMapping(value = "/showAllFunds",method = RequestMethod.POST)
    public String showAllFunds(FundInfo fundInfo){
        return fundService.showAllFunds(fundInfo);
    }

    @ApiOperation(value = "查询基金产品详情",notes = "根据基金名称查找")
    @ResponseBody
    @RequestMapping(value = "/showFundDetails",method = RequestMethod.GET)
    public String showFundDetails(@RequestParam("fundNumber") String fundNumber){
        return fundService.showFundDetails(fundNumber);
    }

    @ApiOperation(value = "查询基金走势信息",notes = "根据基金名称查找")
    @ResponseBody
    @RequestMapping(value = "/showFundPerformance",method = RequestMethod.GET)
    public String showFundPerformance(@RequestParam("fundNumber") String fundNumber){
        return fundService.showFundPerformance(fundNumber);
    }

}
