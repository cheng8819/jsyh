package com.example.jsconsumerloans.feign.impl;

import com.example.jsconsumerloans.feign.OperationalAmount;
import org.springframework.stereotype.Component;

@Component
public class OperationalAmountImpl implements OperationalAmount {
    @Override
    public String idnumberSelectCardnumber(String idnumber) {
        return null;
    }

    @Override
    public Double selectBalance(String cardnumber) {
        return null;
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
        return null;
    }
}
