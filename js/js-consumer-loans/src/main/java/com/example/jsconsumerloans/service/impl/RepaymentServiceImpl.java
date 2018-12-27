package com.example.jsconsumerloans.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsconsumerloans.controllerpojo.LoansParticulars;
import com.example.jsconsumerloans.feign.Loans;
import com.example.jsconsumerloans.feign.OperationalAmount;
import com.example.jsconsumerloans.feign.Overdue;
import com.example.jsconsumerloans.pojo.LoansTransaction;
import com.example.jsconsumerloans.service.RepaymentService;
import com.example.jsconsumerloans.util.Result;
import com.example.jsconsumerloans.util.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepaymentServiceImpl implements RepaymentService {

    @Resource
    private OperationalAmount operationalAmount;
    @Resource
    private Loans loans;
    @Resource
    private Overdue overdue;

    /**
     * 根据订单ID还款
     *
     * @param id
     * @return
     */
    @Override
    public Result repaymentById(Integer id,Integer uid) {
        String idNumber = operationalAmount.idnumberSelectCardnumber("");
        String result = (String) loans.selectLoansTransactionByid(id).getData();
        LoansTransaction loansTransaction = JSON.parseObject(result,LoansTransaction.class);
        String result1;
        if(loansTransaction.getLitype() == 2) {
            result1 = (String) overdue.loanDetailsByuidCon(uid).getData();
        }else{
            result1 = (String) overdue.loanDetailsByuidConz(uid).getData();
        }
        List<LoansParticulars> loansParticulars = JSON.parseArray(result1, LoansParticulars.class);
        LoansParticulars loansParticular2 = null;
        for(LoansParticulars loansParticular1 : loansParticulars){
            if(loansParticular1.getLpid() == id){
                loansParticular2 = loansParticular1;
                break;
            }
        }
        if(loansParticular2 != null){
            if(operationalAmount.remittance(idNumber,loansParticular2.getThisMonth().doubleValue(),loansParticular2.getLitype())
            && "还款成功".equals(overdue.repaymenting(id))){
                return ResultUtil.success("还款成功");
            }else{
                return ResultUtil.success("还款失败");
            }
        }else{
            return ResultUtil.success("订单不存在");
        }
    }
}
