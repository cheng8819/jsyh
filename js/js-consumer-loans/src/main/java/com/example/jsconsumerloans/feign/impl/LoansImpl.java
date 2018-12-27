package com.example.jsconsumerloans.feign.impl;

import com.example.jsconsumerloans.feign.Loans;
import com.example.jsconsumerloans.pojo.LoansTransaction;
import com.example.jsconsumerloans.util.Result;
import com.example.jsconsumerloans.util.ResultUtil;
import org.springframework.stereotype.Component;

@Component
public class LoansImpl implements Loans {
    @Override
    public Result allLoantype() {
        return ResultUtil.success("超时重试");
    }

    @Override
    public Result allLoansTransactionByUid(Integer uid) {
        return ResultUtil.success("超时重试");
    }

    @Override
    public Result addLoanstransaction(LoansTransaction loansTransaction) {
        return ResultUtil.success("超时重试");
    }

    @Override
    public Result updateLoanstransactionTostate(Integer liid, Integer state) {
        return ResultUtil.success("超时重试");
    }

    @Override
    public Result selectLoansTransactionByid(Integer id) {
        return ResultUtil.success("超时重试");
    }

    @Override
    public Result selectLoansTransactionByData(String id) {
        return ResultUtil.success("超时重试");
    }
}
