package com.example.jsproducerloans.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerloans.controllerpojo.LoansParticulars;
import com.example.jsproducerloans.dao.HousingRateDao;
import com.example.jsproducerloans.dao.LoansOverdueDao;
import com.example.jsproducerloans.dao.LoansTransactionDao;
import com.example.jsproducerloans.pojo.LoansTransaction;
import com.example.jsproducerloans.service.Repayment;
import com.example.jsproducerloans.util.Result;
import com.example.jsproducerloans.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepaymentHouseImpl implements Repayment {

    @Autowired
    private LoansOverdueDao loansOverdueDao;
    @Autowired
    private LoansTransactionDao loansTransactionDao;
    @Autowired
    private HousingRateDao housingRateDao;

    /**
     * 根据uid和loid查询逾期订单
     *
     * @param ltid 订单ID
     * @param uid  用户ID
     * @return
     */
    @Override
    public Result allLoansOverdueByuidAndloid(Integer ltid, Integer uid) {
        return ResultUtil.success(JSON.toJSON(loansOverdueDao.findLoansOverduesByLoidAndUid(ltid,uid)));
    }

    /**
     * 根据用户ID查询住房贷款详情
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
            loansParticulars1.setLitype("住房贷款");
            loansParticulars1.setLinumber(loansTransaction.getLinumberofperiods());
            loansParticulars1.setLimoney(loansTransaction.getLinumber());
            loansParticulars1.setLidate(loansTransaction.getLidate());
            // 获取利率
            // System.out.println(loansTransaction.getLinumberofperiods());
            Double rate = housingRateDao.findHousingRateByLrid(loansTransaction.getLinumberofperiods()).getLrratemonth();
            //获取时间并计算距离查询时的时间
//            String date = loansTransaction.getLidate();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
//            Date storagetime = simpleDateFormat.parse(date, new ParsePosition(0));
//            Long time = storagetime.getTime();
//            Date outtime = new Date();
//            time = outtime.getTime() - time;
//            if(time/1000/60/60/24/30 >= 1){
//
//            }
            Double money = ( loansTransaction.getLinumber() + (loansTransaction.getLinumber() * rate / 1000) ) / loansTransaction.getLinumberofperiods();
            loansParticulars1.setThisMonth(money);
            loansParticulars.add(loansParticulars1);
        }
        return ResultUtil.success(JSON.toJSONString(loansParticulars));
    }

    /**
     * 根据订单ID还款
     *
     * @param liid
     * @return
     */
    @Override
    public Result repaymenting(Integer liid) {
        String str = "";
        LoansTransaction loansTransactionsByLiid = loansTransactionDao.findLoansTransactionsByLiid(liid);
        if(loansTransactionsByLiid.getLinumberofperiods() == loansTransactionsByLiid.getLinumberofnoperiods()){
            return ResultUtil.success("贷款已还清,无需再还");
        }
        if(loansTransactionsByLiid.getLinumberofperiods() - 1 == loansTransactionsByLiid.getLinumberofnoperiods()){
            loansTransactionsByLiid.setListate(0);
        }
        loansTransactionsByLiid.setLinumberofnoperiods(loansTransactionsByLiid.getLinumberofnoperiods() + 1);
        loansTransactionsByLiid = loansTransactionDao.save(loansTransactionsByLiid);
        if(loansTransactionsByLiid != null){
            str = "还款成功";
        }else{
            str = "还款失败";
        }
        return ResultUtil.success(str);
    }
}
