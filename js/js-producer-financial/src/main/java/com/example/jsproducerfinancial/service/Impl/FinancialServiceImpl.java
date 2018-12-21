package com.example.jsproducerfinancial.service.Impl;

import com.example.jsproducerfinancial.dao.FinancialDao;
import com.example.jsproducerfinancial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/21 11:20
 */
@Service
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    private FinancialDao financialDao;

    @Override
    public String buyFinancial() {
        return null;
    }

    @Override
    public String sellFinancial() {
        return null;
    }

    @Override
    public String showBuyFinancial() {
        return null;
    }

    @Override
    public String showFinancial() {
        return null;
    }

    @Override
    public String calculateEarnings() {
        return null;
    }

    @Override
    public String addBrowsingHistory() {
        return null;
    }

    @Override
    public String showBrowsingHistory() {
        return null;
    }
}
