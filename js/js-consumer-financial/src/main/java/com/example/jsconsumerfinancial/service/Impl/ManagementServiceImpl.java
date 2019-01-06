package com.example.jsconsumerfinancial.service.Impl;

import com.example.jsconsumerfinancial.service.ManagementService;
import org.springframework.stereotype.Component;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/4 19:31
 */
@Component
public class ManagementServiceImpl implements ManagementService {

    @Override
    public String idnumberSelectCardnumber(String idnumber) {
        return "服务异常。。。";
    }

    @Override
    public Double selectBalance(String cardnumber) {
        return -1.00;
    }

    @Override
    public boolean deposit(String cardnumber, Double core, String type) {
        return false;
    }

    @Override
    public boolean remittance(String cardnumber, Double core, String type) {
        return false;
    }

    @Override
    public String cardnumberSelectState(String cardnumber) {
        return "服务异常。。。";
    }
}
