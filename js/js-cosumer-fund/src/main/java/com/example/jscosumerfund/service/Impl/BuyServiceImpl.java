package com.example.jscosumerfund.service.Impl;

import com.example.jscosumerfund.service.BuyService;
import org.springframework.stereotype.Component;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 21:44
 */
@Component
public class BuyServiceImpl implements BuyService {

    @Override
    public String buyFund(String fund_number, String username, Double fund_money) {
        return "服务异常";
    }

    @Override
    public String selFund(String fundName, String username) {
        return "服务异常";
    }

    @Override
    public String showBuyFund(String username, String fund_number) {
        return "服务异常";
    }
}
