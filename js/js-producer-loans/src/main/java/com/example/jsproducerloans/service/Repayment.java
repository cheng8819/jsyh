package com.example.jsproducerloans.service;

import com.example.jsproducerloans.util.Result;

public interface Repayment {
    /**
     * 根据uid和loid查询逾期订单
     *
     * @param ltid 订单ID
     * @param uid  用户ID
     * @return Result
     */
    Result allLoansOverdueByuidAndloid(Integer ltid, Integer uid);

    /**
     * 根据用户ID查询贷款详情
     * @param uid
     * @return
     */
    Result loanDetailsByuid(Integer uid);

    /**
     * 根据订单ID还款
     * @return
     */
    Result repaymenting(Integer liid);
}
