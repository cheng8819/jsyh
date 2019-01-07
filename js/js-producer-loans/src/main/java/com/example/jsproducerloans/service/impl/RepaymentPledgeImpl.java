package com.example.jsproducerloans.service.impl;

import com.alibaba.fastjson.JSON;
import com.codingapi.tx.annotation.TxTransaction;
import com.example.jsproducerloans.controllerpojo.LoansParticulars;
import com.example.jsproducerloans.dao.LoansOverdueDao;
import com.example.jsproducerloans.dao.LoansTransactionDao;
import com.example.jsproducerloans.dao.PledgeRateDao;
import com.example.jsproducerloans.pojo.LoansTransaction;
import com.example.jsproducerloans.service.Repayment;
import com.example.jsproducerloans.util.Result;
import com.example.jsproducerloans.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepaymentPledgeImpl implements Repayment {

    @Autowired
    private PledgeRateDao pledgeRateDao;
    @Autowired
    private LoansOverdueDao loansOverdueDao;
    @Autowired
    private LoansTransactionDao loansTransactionDao;

    /**
     * 根据uid和loid查询逾期订单
     *
     * @param ltid 订单ID
     * @param uid  用户ID
     * @return Result
     */
    @Override
    public Result allLoansOverdueByuidAndloid(Integer ltid, Integer uid) {
        return ResultUtil.success(JSON.toJSON(loansOverdueDao.findLoansOverduesByLoidAndUid(ltid,uid)));
    }

    /**
     * 根据用户ID查询贷款详情
     *
     * @param uid
     * @return
     */
    @Override
    public Result loanDetailsByuid(Integer uid) {
        List<LoansTransaction> loansTransactions = loansTransactionDao.findLoansTransactionsByLiuidAndLitypeAndListate(uid,2,1);
        List<LoansParticulars> loansParticulars = new ArrayList<>();
        for (LoansTransaction loansTransaction : loansTransactions) {
            LoansParticulars loansParticulars1 = new LoansParticulars();
            loansParticulars1.setLpid(loansTransaction.getLiid());
            loansParticulars1.setLitype("质押贷款");
            loansParticulars1.setLinumber(loansTransaction.getLinumberofperiods());
            loansParticulars1.setLimoney(loansTransaction.getLinumber());
            loansParticulars1.setLidate(loansTransaction.getLidate());
            // 获取利率
            System.out.println(loansTransaction.getLinumberofperiods());
            Double rate = pledgeRateDao.findPledgeRateeByLpid(loansTransaction.getLinumberofperiods()).getLproat();
            Double money = ( loansTransaction.getLinumber() + (loansTransaction.getLinumber() * rate / 1000) ) / loansTransaction.getLinumberofperiods();
            loansParticulars1.setThisMonth(money);
            loansParticulars.add(loansParticulars1);
        }
        return ResultUtil.success(loansParticulars);
    }

    /**
     * 根据订单ID还款
     *
     * @param liid
     * @return
     */
    @Override
    public Result repaymenting(Integer liid) {
        return null;
    }
}
