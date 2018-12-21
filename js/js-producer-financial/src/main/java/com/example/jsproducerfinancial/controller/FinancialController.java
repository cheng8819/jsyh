package com.example.jsproducerfinancial.controller;

import com.example.jsproducerfinancial.service.Impl.FinancialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/21 11:19
 */
@Controller
public class FinancialController {

    @Autowired
    private FinancialServiceImpl financialService;

}
