package com.example.jsproducerfund.service.Impl;

import com.example.jsproducerfund.dao.FundUserDao;
import com.example.jsproducerfund.pojo.FundUser;
import com.example.jsproducerfund.pojo.RiskAppetite;
import com.example.jsproducerfund.service.FundUserService;
import com.example.jsproducerfund.util.RiskRatingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 16:37
 */
@Service
public class FundUserServiceImpl implements FundUserService {

    @Autowired
    private FundUserDao fundUserDao;

    @Override
    public String riskToleranceTest(RiskAppetite riskAppetite) {
        //根据调查问卷算出承受风险等级
        String result = RiskRatingAlgorithm.Algorithm(riskAppetite);
        //将风险等级写入对应用户风险等级栏
        String username = riskAppetite.getName();
        Integer count = fundUserDao.updRiskGrade(result,username);
        if(count <= 0){
            return "风险等级修改失败";
        }
        return result;
    }

    @Override
    public String addFundAccount(FundUser fundUser) {
        try {
            //调用短信验证码接口进行身份验证
            if(fundUser.getUsername() == null || fundUser.getPhone() == null ||
                    fundUser.getCard_number() == null || fundUser.getCard_type() == null ||
                    fundUser.getBeneficial_owner() == null || fundUser.getSex() == null ||
                    fundUser.getCapital_source() == null)
            {
                return "开户信息不与允许为空";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer result = fundUserDao.addFundAccount(fundUser);
        if(result <= 0){
            return "开户失败";
        }
        return "开户成功";
    }

}
