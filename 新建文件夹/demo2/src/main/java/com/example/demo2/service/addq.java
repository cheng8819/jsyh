package com.example.demo2.service;


import com.example.demo2.dao.deposit;
import com.example.demo2.pojo.CardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addq {
    @Autowired
    private deposit deposit;
    public void addch(CardNumber cardNumber){
        deposit.save(cardNumber);
    }
    public void update(CardNumber cardNumber){
        deposit.saveAndFlush(cardNumber);
    }
    public CardNumber show(String Carenumbermark,String Carenumbername){
        return deposit.findByCarenumbermarkAAndCarenumbername(Carenumbermark, Carenumbername);
    }
}
