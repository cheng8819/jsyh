package com.example.jsconsumerloans.service.impl;

import com.alibaba.fastjson.JSON;
import com.codingapi.tx.annotation.TxTransaction;
import com.example.jsconsumerloans.controllerpojo.LoansParticulars;
import com.example.jsconsumerloans.feign.Loans;
import com.example.jsconsumerloans.feign.OperationalAmount;
import com.example.jsconsumerloans.feign.Overdue;
import com.example.jsconsumerloans.pojo.LoansTransaction;
import com.example.jsconsumerloans.service.RepaymentService;
import com.example.jsconsumerloans.util.Result;
import com.example.jsconsumerloans.util.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DecimalFormat;
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
    @TxTransaction(isStart = true)
    @Transactional
    public Result repaymentById(Integer id,Integer uid){
//        String idNumber = operationalAmount.idnumberSelectCardnumber("");
        String result = (String) loans.selectLoansTransactionByid(id).getData();
        LoansTransaction loansTransaction = JSON.parseObject(result,LoansTransaction.class);
        String result1;
        if(loansTransaction.getLitype() == 2) {
            result1 = overdue.loanDetailsByuidCon(uid).getData().toString();
        }else{
            result1 = overdue.loanDetailsByuidConz(uid).getData().toString();
        }
        System.out.println(result1);
        List<LoansParticulars> loansParticulars = JSON.parseArray(result1, LoansParticulars.class);
        LoansParticulars loansParticular2 = null;
        for(LoansParticulars loansParticular1 : loansParticulars){
            if(loansParticular1.getLpid() == id){
                loansParticular2 = loansParticular1;
                break;
            }
        }
        String flag1 = overdue.repaymenting(id).getData().toString();
        DecimalFormat df = new DecimalFormat("#.00");
        double moneys = new Double(df.format(loansParticular2.getThisMonth().doubleValue())).doubleValue();
        boolean flag = operationalAmount.remittance("6228211659001411572",moneys,loansParticular2.getLitype());
        if(!flag){
            throw  new RuntimeException("扣款失败");
        }
        if(loansParticular2 != null){
            if(flag && "还款成功".equals(flag1)){
                return ResultUtil.success("还款成功");
            }else{
                return ResultUtil.success("还款失败");
            }
        }else{
            return ResultUtil.success("订单不存在");
        }
    }
}
