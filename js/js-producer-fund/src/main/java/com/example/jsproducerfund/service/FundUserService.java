package com.example.jsproducerfund.service;

import com.example.jsproducerfund.pojo.FundUser;
import com.example.jsproducerfund.pojo.RiskAppetite;

public interface FundUserService {

    /**
     * 风险承受能力测试接口
     * @param riskAppetite 风险承受能力调查问卷对象
     * @return
     */
    String riskToleranceTest(RiskAppetite riskAppetite);

    /**
     * 基金开户接口
     * 1.填写必要资料，进行判断
     * 2.发送验证码
     * 3.添加客户开户信息
     * @param fundUser 基金开户对象
     * @return
     */
    String addFundAccount(FundUser fundUser);

}
