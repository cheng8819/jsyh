package com.example.jsproducerloans.service;

import com.example.jsproducerloans.pojo.LoansTransaction;
import com.example.jsproducerloans.util.Result;

public interface Pledge {
    /**
     * 全部贷款种类
     *
     * @return Result
     */
    Result allLoantype();

    /**
     * 查看指定用户ID的所有申请成功贷款
     *
     * @return Result
     */
    Result allLoansTransactionByUid(Integer uid);

    /**
     * 生成订单 默认状态申请未成功
     *
     * @param loansTransaction 订单对象
     * @return Result
     */
    Result addLoansTransaction(LoansTransaction loansTransaction);

    /**
     * 根据订单ID修改订单状态
     *
     * @param lid   订单ID
     * @param state 订单状态
     * @return
     */
    Result updateLoansTransactionToState(Integer lid, Integer state);

    /**
     *根据订单ID查询订单
     * @param id
     * @return
     */
    Result selectLoansTransactionByid(Integer id);

    /**
     * 根据申请资料查询订单
     * @param id
     * @return
     */
    Result selectLoansTransactionByData(String id);
}
