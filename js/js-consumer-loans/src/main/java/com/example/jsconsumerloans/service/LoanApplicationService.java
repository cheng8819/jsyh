package com.example.jsconsumerloans.service;

import com.example.jsconsumerloans.pojo.LoansUserinfo;
import com.example.jsconsumerloans.util.Result;

public interface LoanApplicationService {

    /**
     * 申请贷款
     * @param loansUserinfo
     * @return
     */
    Result loanApplica(LoansUserinfo loansUserinfo);
}
