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
     * 以申请表单记录id添加一条流程
     * @param leid 表单记录id
     */
//    void addLeaveAInfo(Integer leid);
}
