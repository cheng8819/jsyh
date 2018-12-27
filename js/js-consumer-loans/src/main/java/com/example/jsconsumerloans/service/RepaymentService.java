package com.example.jsconsumerloans.service;

import com.example.jsconsumerloans.util.Result;

public interface RepaymentService {

    /**
     * 根据订单ID还款
     * @param id
     * @return
     */
    Result repaymentById(Integer id,Integer uid);
}
