package com.example.jsproducerloans.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerloans.dao.LoansOverdueDao;
import com.example.jsproducerloans.pojo.LoansOverdue;
import com.example.jsproducerloans.service.Repayment;
import com.example.jsproducerloans.util.Result;
import com.example.jsproducerloans.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import tk.mybatis.mapper.entity.Example;

@Service
public class RepaymentImpl implements Repayment {

    @Autowired
    private LoansOverdueDao loansOverdueDao;


    /**
     * 根据uid和loid查询逾期订单
     *
     * @param ltid 订单ID
     * @param uid  用户ID
     * @return
     */
    @Override
    public Result allLoansOverdueByuidAndloid(Integer ltid, Integer uid) {
//        Example example = new Example(LoansOverdue.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("loid", ltid);
//        criteria.andEqualTo("uid", uid);
//        return ResultUtil.success(JSON.toJSON(loansOverdueDao.selectByExample(example)));
        return ResultUtil.success(JSON.toJSON(loansOverdueDao.findLoansOverduesByLoidAndUid(ltid,uid)));
    }
}
