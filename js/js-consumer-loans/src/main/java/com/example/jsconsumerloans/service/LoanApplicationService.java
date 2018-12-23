package com.example.jsconsumerloans.service;

import com.example.jsconsumerloans.pojo.LoansTransaction;
import com.example.jsconsumerloans.pojo.LoansUserinfo;
import com.example.jsconsumerloans.util.Result;

public interface LoanApplicationService {

    /**
     * 申请贷款
     * @param loansUserinfo
     * @param id 临时订单id
     * @return
     */
    Result loanApplica(LoansUserinfo loansUserinfo,Long id);

    /**
     * 生成订单
     * @param loansTransaction
     * @return
     */
    Result createOrder(LoansTransaction loansTransaction);
}
