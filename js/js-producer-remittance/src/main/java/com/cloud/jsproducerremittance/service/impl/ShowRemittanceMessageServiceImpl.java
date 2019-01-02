package com.cloud.jsproducerremittance.service.impl;

import com.cloud.jsproducerremittance.dao.remittancetransactionDao;
import com.cloud.jsproducerremittance.entity.RemittanceTransaction;
import com.cloud.jsproducerremittance.service.ShowRemittanceMessageService;
import com.cloud.jsproducerremittance.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ShowRemittanceMessageServiceImpl implements ShowRemittanceMessageService {
    @Autowired
    private remittancetransactionDao remittancetransactionDao;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public List<RemittanceTransaction> showRemittance(String cardNumber) {
        List<RemittanceTransaction> all = remittancetransactionDao.findByRemittancetransactionnumber(cardNumber);
        Map<Object, Object> hmget = redisUtil.hmget(cardNumber);
        for (Object o : hmget.values()) {
            RemittanceTransaction remittanceTransaction= (RemittanceTransaction) o;
            if (remittanceTransaction.getRemittancetransactionnumber().equals(cardNumber)){
                all.add((RemittanceTransaction) o);
            }
        }
        return all;
    }

    @Override
    public List<RemittanceTransaction> showGathering(String cardNumber) {
        List<RemittanceTransaction> all = remittancetransactionDao.findByRemittancetransactioncardnumber(cardNumber);
        Map<Object, Object> hmget = redisUtil.hmget(cardNumber);
        for (Object o : hmget.values()) {
            RemittanceTransaction remittanceTransaction= (RemittanceTransaction) o;
            if (remittanceTransaction.getRemittancetransactioncardnumber().equals(cardNumber)){
                all.add((RemittanceTransaction) o);
            }
        }
        return all;
    }
}