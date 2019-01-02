package com.example.demo2.service;


import com.example.demo2.dao.depositDao;
import com.example.demo2.pojo.CardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bankingInterface {
    @Autowired
    private depositDao depositDao;
    public void addch(CardNumber cardNumber){
        depositDao.save(cardNumber);
    }
    public void update(CardNumber cardNumber){
        depositDao.update(cardNumber.getCardnumberid(),cardNumber.getMoney());
    }
    public CardNumber show(String carenumbername,String carenumbermark){
        return depositDao.findByCarenumbernameAndCarenumbermark(carenumbername, carenumbermark);
    }


}
