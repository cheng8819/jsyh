package com.example.jsproducerloans.service;

import com.example.jsproducerloans.dao.LoansTransactionDao;
import com.example.jsproducerloans.pojo.LoansTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test {

    @Autowired
    private LoansTransactionDao loansTransactionDao;

    public LoansTransaction hehe(){
        return loansTransactionDao.selectAll().get(0);
    }
}
