package com.example.jsproducerloans.service.impl;

import com.example.jsproducerloans.dao.LoantypeDao;
import com.example.jsproducerloans.pojo.Loantype;
import com.example.jsproducerloans.service.Pledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PledgeImpl implements Pledge {

    @Autowired
    private LoantypeDao loantypeDao;
    /**
     * 全部贷款种类
     *
     * @return 贷款种类集合
     */
    @Override
    public List<Loantype> allLoantype() {
        return loantypeDao.selectAll();
    }
}
