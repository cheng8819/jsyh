package com.example.jsconsumerloans.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsconsumerloans.feign.LoanApplication;
import com.example.jsconsumerloans.feign.Loans;
import com.example.jsconsumerloans.pojo.LoansTransaction;
import com.example.jsconsumerloans.pojo.LoansUserinfo;
import com.example.jsconsumerloans.service.LoanApplicationService;
import com.example.jsconsumerloans.util.IdWorker;
import com.example.jsconsumerloans.util.RedisUtil;
import com.example.jsconsumerloans.util.Result;
import com.example.jsconsumerloans.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

    @Autowired
    private RedisUtil redisUtil;
    @Resource
    private Loans loans;
    @Resource
    private LoanApplication loanApplication;
    /**
     * 申请贷款
     *
     * @param loansUserinfo
     * @param id
     * @return
     */
    @Override
    public Result loanApplica(LoansUserinfo loansUserinfo,Long id) {
        String loanstran = (String) redisUtil.get(id.toString());
        System.out.println(loanstran);
        Result result2;
        if("null".equals(loanstran) || loanstran == null){
            return ResultUtil.success("临时订单不存在,重新申请");
        }else{
            LoansTransaction loansTransaction = JSON.parseObject(loanstran,LoansTransaction.class);
            IdWorker idWorker = new IdWorker(15);
            String id1 = "";
            try {
                id1 = new Long(idWorker.nextId()).toString();
            }catch (Exception e){
                return ResultUtil.success("内部错误");
            }
            loansTransaction.setLiapplicationdata(id1);
            loansUserinfo.setLuid(id1);
            Result result = loans.addLoanstransaction(loansTransaction);
            Result result1 = loanApplication.loanApplications(loansUserinfo);
            if("生成订单成功".equals(result.getData()) && "提交成功".equals(result1.getData())){
                result2 = ResultUtil.success("申请提交成功");
            }else{
                result2 = ResultUtil.success("申请提交失败，请重新提交");
            }
        }
        return result2;
    }

    /**
     * 生成订单
     *
     * @param loansTransaction
     * @return
     */
    @Override
    public Result createOrder(LoansTransaction loansTransaction) {
        String str = "";
        String loansTrsns = JSON.toJSONString(loansTransaction);
        IdWorker idWorker = new IdWorker(15);
        boolean flag = true;
        String id = "";
        try {
            id = new Long(idWorker.nextId()).toString();
            //将临时订单放入redis
            flag = redisUtil.set(id, loansTrsns,1800);
        }catch (Exception e){
            return ResultUtil.success("创建订单失败");
        }
        if(flag){
            str = id;
        }else{
            str = "失败";
        }
        return ResultUtil.success(str);
    }
}
