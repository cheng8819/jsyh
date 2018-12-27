package com.example.jsproducerloans.service;

import com.example.jsproducerloans.pojo.LoansUserinfo;
import com.example.jsproducerloans.util.Result;


public interface LoanApplication {

    /**
     * 录入登记信息
     * @param loansUserinfo
     * @return
     */
    Result registerInfo(LoansUserinfo loansUserinfo);

    /**
     * 查询指定用户的贷款申请进度
     * @return
     */
    Result SelectLoanSchedule(Integer uid);

}
