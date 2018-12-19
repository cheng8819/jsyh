package com.cloud.jsproducerremittance.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.cloud.jsproducerremittance.config.GeneralRemittance;
import com.cloud.jsproducerremittance.dao.RemittancetransactionDao;
import com.cloud.jsproducerremittance.entity.RemittanceTransaction;
import com.cloud.jsproducerremittance.service.GeneralRemittanceService;
import com.cloud.jsproducerremittance.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GeneralRemittanceServiceImpl implements GeneralRemittanceService {
    @Autowired
    private RemittancetransactionDao remittancetransactionDao;
    @Autowired
    private RedisUtil redisUtil;
    private int iteartor = 0;

    @Override
    public void addGeneralRemittance(RemittanceTransaction remittanceTransaction) {
        Map<Object, Object> hmget = redisUtil.hmget(GeneralRemittance.REGULAR_PAY);

        int count = 0;
        for (Object o : hmget.values()) {
            remittanceTransaction = (RemittanceTransaction) o;
            System.out.println(remittanceTransaction.getRemittancetransactioncardnumber());
            remittancetransactionDao.saveAndFlush(remittanceTransaction);
            count++;
        }
        System.out.println(count == hmget.size());
        if (count != hmget.size()){
            GeneralRemittanceServiceImpl grsi = new GeneralRemittanceServiceImpl();
            grsi.addGeneralRemittance(remittanceTransaction);
        }
    }
    @Override
    public RemittanceTransaction addGeneralRemittancerecord(RemittanceTransaction remittanceTransaction) {
        boolean flage = true;
        boolean hset = redisUtil.hset(GeneralRemittance.REGULAR_PAY, remittanceTransaction.getRemittancetransactioncardnumber() + iteartor++, remittanceTransaction);
        boolean hset1 = redisUtil.hset(GeneralRemittance.REGULAR_PAY, remittanceTransaction.getRemittancetransactionnumber() + iteartor++, remittanceTransaction);
        if (!(hset && hset1)){
            flage = false;
        }
        if (!flage){
            return null;
        }
        return remittanceTransaction;
    }
}
