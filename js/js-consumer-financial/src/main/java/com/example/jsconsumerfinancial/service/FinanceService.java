package com.example.jsconsumerfinancial.service;

import com.example.jsconsumerfinancial.pojo.BrowsingHistory;
import com.example.jsconsumerfinancial.pojo.Finance;
import com.example.jsconsumerfinancial.service.Impl.FinanceServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "js-producer-financial",fallback = FinanceServiceImpl.class)
public interface FinanceService {

    @ApiOperation(value = "查询理财产品信息",notes = "多字段查询，分页")
    @ResponseBody
    @RequestMapping(value = "/showFinance",method = RequestMethod.GET)
    public String showFinance(Finance finance,Integer index);

    @ApiOperation(value = "查询单个理财产品详情",notes = "根据产品名称查询")
    @ResponseBody
    @RequestMapping(value = "/showFinancialDetails",method = RequestMethod.GET)
    public String showFinancialDetails(String financeName);

    @ApiOperation(value = "购买理财产品",notes = "三个主要参数：产品信息、用户标识、金额")
    @ResponseBody
    @RequestMapping(value = "/buyFinance",method = RequestMethod.GET)
    public String buyFinance(Finance finance, String username, Double money);

    @ApiOperation(value = "查询已购买理财产品信息",notes = "根据用户标识查询")
    @ResponseBody
    @RequestMapping(value = "/showBuyFinancial",method = RequestMethod.GET)
    public String showBuyFinancial(String username);

    @ApiOperation(value = "赎回理财产品",notes = "产品信息、用户标识")
    @ResponseBody
    @RequestMapping(value = "/sellFinancial",method = RequestMethod.GET)
    public String sellFinancial(Finance finance,String username);

    @ApiOperation(value = "添加浏览记录",notes = "产品信息、用户标识")
    @ResponseBody
    @RequestMapping(value = "/addBrowsingHistory",method = RequestMethod.GET)
    public String addBrowsingHistory(Finance finance,String username);

    @ApiOperation(value = "添加浏览记录",notes = "产品信息、用户标识")
    @ResponseBody
    @RequestMapping(value = "/showBrowsingHistory",method = RequestMethod.GET)
    public String showBrowsingHistory(BrowsingHistory browsingHistory);

    @ApiOperation(value = "计算理财产品收益",notes = "产品信息、用户标识")
    @ResponseBody
    @RequestMapping(value = "/calculateEarnings",method = RequestMethod.GET)
    public String calculateEarnings(Finance finance,String username);

}