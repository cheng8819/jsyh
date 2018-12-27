package com.example.jsproducerloans.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerloans.controllerpojo.LoansTransactionCon;
import com.example.jsproducerloans.dao.LoansTransactionDao;
import com.example.jsproducerloans.dao.LoantypeDao;
import com.example.jsproducerloans.dao.RepaymentTypeDao;
import com.example.jsproducerloans.pojo.LoansTransaction;
import com.example.jsproducerloans.pojo.RepaymentType;
import com.example.jsproducerloans.service.Pledge;
import com.example.jsproducerloans.util.Result;
import com.example.jsproducerloans.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class PledgeImpl implements Pledge {

    @Autowired
    private LoantypeDao loantypeDao;
    @Autowired
    private LoansTransactionDao loansTransactionDao;
    @Autowired
    private RepaymentTypeDao repaymentTypeDao;

    /**
     * 全部贷款种类
     *
     * @return 贷款种类集合
     */
    @Override
    public Result allLoantype() {
//        return ResultUtil.success(JSON.toJSON(loantypeDao.selectAll()));
        return ResultUtil.success(JSON.toJSON(loantypeDao.findAll()));
    }

    /**
     * 查看指定用户ID的所有贷款
     *
     * @return 所有贷款集合
     */
    @Override
    public Result allLoansTransactionByUid(Integer uid) {
        List<LoansTransaction> loansTransactions = loansTransactionDao.findLoansTransactionsByLiuidAndListate(uid,1);
        List<LoansTransactionCon> loansTransactionCons = new ArrayList<>();
        for (int i = 0; i < loansTransactions.size(); i++) {
            LoansTransactionCon loansTransactionCon = new LoansTransactionCon();
            loansTransactionCon.setLiid(loansTransactions.get(i).getLiid());
            loansTransactionCon.setLiuid(loansTransactions.get(i).getLiuid());
            RepaymentType repaymentType = repaymentTypeDao.findRepaymentTypeByRtid(loansTransactions.get(i).getLitype());
            loansTransactionCon.setLitype(repaymentType.getRtname());
            loansTransactionCon.setLinumberofperiods(loansTransactions.get(i).getLinumberofperiods());
            loansTransactionCon.setLinumber(loansTransactions.get(i).getLinumber());
            loansTransactionCon.setLidate(loansTransactions.get(i).getLidate());
            loansTransactionCon.setLiapplicationdata(loansTransactions.get(i).getLiapplicationdata());
            loansTransactionCons.add(loansTransactionCon);
        }
        return ResultUtil.success(JSON.toJSONString(loansTransactionCons));
    }

    /**
     * 生成订单
     *
     * @param loansTransaction 订单对象
     * @return Result
     */
    @Override
    public Result addLoansTransaction(LoansTransaction loansTransaction) {
        if(loansTransaction.getLinumber() == null){
            return ResultUtil.success("金额不能为null");
        }
        loansTransaction.setListate(0);
        loansTransaction.setLinumberofnoperiods(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        loansTransaction.setLidate(simpleDateFormat.format(new Date()));
        LoansTransaction loansTransaction1 = loansTransactionDao.save(loansTransaction);
        if (loansTransaction1 != null) {
            return ResultUtil.success(JSON.toJSON(new String("生成订单成功")));
        } else {
            return ResultUtil.success(JSON.toJSON(new String("生成订单失败")));
        }
    }

    /**
     * 根据订单ID修改订单状态
     *
     * @param lid   订单ID
     * @param state 订单状态
     * @return
     */
    @Override
    public Result updateLoansTransactionToState(Integer lid, Integer state) {
        if (state > 1 || state < 0) {
            return ResultUtil.success(JSON.toJSON(new String("状态码有误")));
        }
        if(lid == null){
            System.out.println("空");
        }
        System.out.println(lid);
        LoansTransaction loansTransaction = loansTransactionDao.findLoansTransactionsByLiid(lid);
        if (loansTransaction == null) {
            return ResultUtil.success(JSON.toJSON(new String("订单不存在")));
        }
        loansTransaction.setListate(state);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        loansTransaction.setLidate(simpleDateFormat.format(new Date()));
        LoansTransaction loansTransaction1 = loansTransactionDao.save(loansTransaction);
        if (loansTransaction1 != null) {
            return ResultUtil.success(JSON.toJSON(new String("修改订单状态成功")));
        } else {
            return ResultUtil.success(JSON.toJSON(new String("修改订单状态失败")));
        }
    }

    /**
     * 根据订单ID查询订单
     *
     * @param id
     * @return
     */
    @Override
    public Result selectLoansTransactionByid(Integer id) {
        return ResultUtil.success(JSON.toJSONString(loansTransactionDao.findLoansTransactionsByLiid(id)));
    }

    /**
     * 根据申请资料查询订单
     *
     * @param id
     * @return
     */
    @Override
    public Result selectLoansTransactionByData(String id) {
        return ResultUtil.success(JSON.toJSONString(loansTransactionDao.findLoansTransactionsByLiapplicationdata(id)));
    }
}
