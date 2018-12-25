package com.example.jsproducerfund.controller;

import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.*;
import java.util.List;
import com.example.jsproducerfund.service.Impl.FundServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
    private FundDao fundDao;

    @Autowired
    private FundServiceImpl fundService;

    @ApiOperation(value = "查询新发布基金产品信息",notes = "支持分页查询、多字段查询")
    @ResponseBody
    @RequestMapping(value = "/showNewFunds",method = RequestMethod.GET)
    public List<FundInfo> show(FundInfo fundInfo,Integer index){
        return fundService.showNewFunds(fundInfo,index);
    }

    /**
     *
     * @param fundInfo 多字段
     * @param index 1:上一页   -1:下一页
     * @return
     */
    @ApiOperation(value = "查询已上市基金产品信息",notes = "支持多字段查询，支持分页查询,index参数 1:上一页  -1:下一页")
    @ResponseBody
    @RequestMapping(value = "/showFunds",method = RequestMethod.GET)
    public List<Performance> showFunds(Performance fundInfo,Integer index){
        return fundService.showFunds(fundInfo,index);
    }

    /**
     * @return
     */
    @ApiOperation(value = "查询已上市基金产品净值",notes = "支持多字段查询，支持分页查询,index参数 1:上一页  -1:下一页")
    @ResponseBody
    @RequestMapping(value = "/selFunds",method = RequestMethod.GET)
    public List<Performance> selFunds(HttpServletRequest request, HttpServletResponse response){
        return fundService.selFunds(request,response);
    }

    /**
     * 收藏基金
     * @param fundInfo 基金信息
     * @param username 用户名/真实姓名
     * @return result
     *
     * @desc:谁点的收藏？收藏哪个基金？
     */
    @ApiOperation(value = "收藏基金产品",notes = "收藏")
    @ResponseBody
    @RequestMapping(value = "/collectFund",method = RequestMethod.GET)
    public String collectFund(FundInfo fundInfo,String username){
        return fundService.collectFund(fundInfo,username);
    }

    @ApiOperation(value = "收藏基金产品展示",notes = "收藏基金展示")
    @ResponseBody
    @RequestMapping(value = "/showCollection",method = RequestMethod.GET)
    public List<CollectInfo> showCollection(CollectInfo collection){
        return fundService.selCollection(collection);
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
    public List<Buy> showBuyFund(@Param("username") String username, @Param("fund_number") String fund_number){
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
