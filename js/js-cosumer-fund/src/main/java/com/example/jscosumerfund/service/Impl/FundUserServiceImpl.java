package com.example.jscosumerfund.service.Impl;

import com.example.jscosumerfund.pojo.FundUser;
import com.example.jscosumerfund.pojo.RiskAppetite;
import com.example.jscosumerfund.service.FundUserService;
import org.springframework.stereotype.Component;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 22:30
 */
@Component
public class FundUserServiceImpl implements FundUserService {

    @Override
    public String riskToleranceTest(RiskAppetite riskAppetite) {
        return "服务走丢了。。。";
    }

    @Override
    public String fundAccount(FundUser fundUser) {
        return "服务走丢了。。。";
    }
}
