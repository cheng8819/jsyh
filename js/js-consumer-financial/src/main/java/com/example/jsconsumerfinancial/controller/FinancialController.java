package com.example.jsconsumerfinancial.controller;

import com.example.jsconsumerfinancial.service.FinanceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/26 22:11
 */
@RestController
public class FinancialController {

    @Autowired
    private FinanceService financeService;

    @ApiOperation(value = "查询理财产品信息",notes = "多字段查询，分页")
    @RequestMapping(value = "/showFinance",method = RequestMethod.GET)
    public String showFinance(@RequestParam("index") Integer index, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return financeService.showFinance(index);
    }

}
