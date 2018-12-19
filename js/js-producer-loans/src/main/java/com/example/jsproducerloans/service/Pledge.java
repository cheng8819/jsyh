package com.example.jsproducerloans.service;

import com.example.jsproducerloans.pojo.Loantype;

import java.util.List;


public interface Pledge {
    /**
     * 全部贷款种类
     * @return 贷款种类集合
     */
    List<Loantype> allLoantype();
}
