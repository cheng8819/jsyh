package com.cloud.jsproducerremittance.service.impl;

import com.cloud.jsproducerremittance.config.GeneralRemittance;
import com.cloud.jsproducerremittance.entity.RemittanceTransaction;
import com.cloud.jsproducerremittance.service.ApplicationInformationService;
import com.cloud.jsproducerremittance.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationInformationServiceImpl implements ApplicationInformationService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public RemittanceTransaction addApplicationInformationService(RemittanceTransaction remittanceTransaction) {

        boolean hset = redisUtil.hset(GeneralRemittance.REMITTANCE_INFORMATION, remittanceTransaction.getRemittancetransactioncardnumber(), remittanceTransaction);
        if (!hset){
            return null;
        }
        return remittanceTransaction;
    }
}
