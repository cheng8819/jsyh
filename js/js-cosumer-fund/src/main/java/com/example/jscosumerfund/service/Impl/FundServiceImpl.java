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
    public List<FundInfo> show(FundInfo fundInfo, Integer index) {
        return null;
    }

    @Override
    public List<Performance> showFunds(Performance fundInfo, Integer index) {
        return null;
    }

    @Override
    public List<Performance> selFunds(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public String collectFund(FundInfo fundInfo, String username) {
        return "服务错误";
    }

    @Override
    public List<CollectInfo> showCollection(CollectInfo collection) {
        return null;
    }

    @Override
    public String buyFund(FundInfo fundInfo, String username, Double fund_money) {
        return "服务错误";
    }

    @Override
    public String selFund(String fundName, String username) {
        return "服务错误";
    }

    @Override
    public List<Buy> showBuyFund(String username, String fund_number) {
        return null;
    }

    @Override
    public String riskToleranceTest(RiskAppetite riskAppetite) {
        return "服务错误";
    }

    @Override
    public String fundAccount(FundUser fundUser) {
        return "服务错误";
    }

    @Override
    public String AIP(String jobName, String time) {
        return "服务错误";
    }
}
