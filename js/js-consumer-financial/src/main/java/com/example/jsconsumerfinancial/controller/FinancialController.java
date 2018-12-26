package com.example.jsconsumerfinancial.controller;

import com.example.jsconsumerfinancial.pojo.Finance;
import com.example.jsconsumerfinancial.service.Impl.FinanceServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/26 22:11
 */
@RestController
public class FinancialController {

    @Autowired
    private FinanceServiceImpl financeService;

    @ApiOperation(value = "查询理财产品信息",notes = "多字段查询，分页")
    @RequestMapping(value = "/showFinance",method = RequestMethod.GET)
    public String showFinance(Finance finance, Integer index){
        return financeService.showFinance(finance,index);
    }

}
