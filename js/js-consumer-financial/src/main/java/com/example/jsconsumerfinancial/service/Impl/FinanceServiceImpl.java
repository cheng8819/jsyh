package com.example.jsconsumerfinancial.service.Impl;

import com.example.jsconsumerfinancial.pojo.BrowsingHistory;
import com.example.jsconsumerfinancial.pojo.Finance;
import com.example.jsconsumerfinancial.service.FinanceService;
import org.springframework.stereotype.Component;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/26 22:16
 */
@Component
public class FinanceServiceImpl implements FinanceService {

    @Override
    public String showFinance(Finance finance, Integer index) {
        return "服务错误";
    }

    @Override
    public String showFinancialDetails(String financeName) {
        return "服务错误";
    }

    @Override
    public String buyFinance(Finance finance, String username, Double money) {
        return "服务错误";
    }

    @Override
    public String showBuyFinancial(String username) {
        return "服务错误";
    }

    @Override
    public String sellFinancial(Finance finance, String username) {
        return "服务错误";
    }

    @Override
    public String addBrowsingHistory(Finance finance, String username) {
        return "服务错误";
    }

    @Override
    public String showBrowsingHistory(BrowsingHistory browsingHistory) {
        return "服务错误";
    }

    @Override
    public String calculateEarnings(Finance finance, String username) {
        return "服务错误";
    }
}
