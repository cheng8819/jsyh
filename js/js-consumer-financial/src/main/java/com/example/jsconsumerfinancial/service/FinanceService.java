package com.example.jsconsumerfinancial.service;

import com.example.jsconsumerfinancial.pojo.BrowsingHistory;
import com.example.jsconsumerfinancial.pojo.Finance;
import com.example.jsconsumerfinancial.service.Impl.FinanceServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "js-producer-financial",fallback = FinanceServiceImpl.class)
public interface FinanceService {

    @RequestMapping(value = "/showFinancialDetails",method = RequestMethod.POST)
    public String showFinancialDetails(@RequestParam("financeName") String financeName);

//
//    @RequestMapping(value = "/showFinancialDetails",method = RequestMethod.GET)
//    public String showFinancialDetails(@RequestParam("financeName")String financeName);
//
//
//    @RequestMapping(value = "/buyFinance",method = RequestMethod.GET)
//    public String buyFinance(Finance finance, String username, Double money);
//
//
//    @RequestMapping(value = "/showBuyFinancial",method = RequestMethod.GET)
//    public String showBuyFinancial(String username);
//
//
//    @RequestMapping(value = "/sellFinancial",method = RequestMethod.GET)
//    public String sellFinancial(Finance finance,String username);
//
//
//    @RequestMapping(value = "/addBrowsingHistory",method = RequestMethod.GET)
//    public String addBrowsingHistory(Finance finance,String username);
//
//
//    @RequestMapping(value = "/showBrowsingHistory",method = RequestMethod.GET)
//    public String showBrowsingHistory(BrowsingHistory browsingHistory);
//
//
//    @RequestMapping(value = "/calculateEarnings",method = RequestMethod.GET)
//    public String calculateEarnings(Finance finance,String username);

}
