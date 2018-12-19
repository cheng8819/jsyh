package com.example.jsproducerloans.service;

import com.example.jsproducerloans.util.Result;

public interface Repayment {
    /**
     * 根据uid和loid查询逾期订单
     * @param ltid 订单ID
     * @param uid 用户ID
     * @return Result
     */
    public Result allLoansOverdueByuidAndloid(Integer ltid,Integer uid);
}
