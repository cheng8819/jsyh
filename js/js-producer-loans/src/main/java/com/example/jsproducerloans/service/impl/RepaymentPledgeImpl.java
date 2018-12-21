package com.example.jsproducerloans.service.impl;

import com.example.jsproducerloans.service.Repayment;
import com.example.jsproducerloans.util.Result;
import org.springframework.stereotype.Service;

@Service
public class RepaymentPledgeImpl implements Repayment {
    /**
     * 根据uid和loid查询逾期订单
     *
     * @param ltid 订单ID
     * @param uid  用户ID
     * @return Result
     */
    @Override
    public Result allLoansOverdueByuidAndloid(Integer ltid, Integer uid) {
        return null;
    }

    /**
     * 根据用户ID查询贷款详情
     *
     * @param uid
     * @return
     */
    @Override
    public Result loanDetailsByuid(Integer uid) {
        return null;
    }

    /**
     * 根据订单ID还款
     *
     * @param liid
     * @return
     */
    @Override
    public Result repaymenting(Integer liid) {
        return null;
    }
}
