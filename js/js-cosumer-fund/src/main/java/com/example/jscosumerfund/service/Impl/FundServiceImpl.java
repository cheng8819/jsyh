package com.example.jscosumerfund.service.Impl;

import com.example.jscosumerfund.pojo.*;
import com.example.jscosumerfund.service.FundService;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/26 22:06
 */
@Component
public class FundServiceImpl implements FundService {

    @Override
    public String showNewFunds() {
        return "服务异常";
    }

    @Override
    public String showFunds(String fundType) {
        return "服务异常";
    }

    @Override
    public String selFunds() {
        return "服务异常";
    }

    @Override
    public String showFundDetails(String fundName) {
        return "服务异常";
    }

    @Override
    public String fundAccount(FundUser fundUser) {
        return "服务异常";
    }

    @Override
    public String showBuyFund(String username, String fund_number) {
        return "服务异常";
    }
}
