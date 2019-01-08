package com.example.jsconsumerfinancial.service.Impl;

import com.example.jsconsumerfinancial.pojo.BrowsingHistory;
import com.example.jsconsumerfinancial.pojo.Finance;
import com.example.jsconsumerfinancial.service.FinanceService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/26 22:16
 *
 * 理财产品服务生产者
 */
@Component
public class FinanceServiceImpl implements FinanceService {
    @Override
    public String showFinance(Integer index) {
        return "服务异常...";
    }

    @Override
    public String buyFinance(String financeName, String username, Double money) {
        return "服务异常...";
    }

    @Override
    public String sellFinancial(String financeName, String username) {
        return "服务异常...";
    }
}
