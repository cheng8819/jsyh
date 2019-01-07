package com.example.jsconsumerloans.feign.impl;

import com.example.jsconsumerloans.feign.LoanApplication;
import com.example.jsconsumerloans.pojo.LoansUserinfo;
import com.example.jsconsumerloans.util.Result;
import com.example.jsconsumerloans.util.ResultUtil;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationImpl implements LoanApplication {
    @Override
    public Result loanApplications(LoansUserinfo loansUserinfo) {
        return ResultUtil.success("超时重试");
    }

    /**
     * 根据uid查询用户贷款申请进度
     *
     * @param uid
     * @return
     */
    @Override
    public Result LoanScheduleCon(Integer uid) {
        return null;
    }
}
