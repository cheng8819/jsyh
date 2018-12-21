package com.example.jsproducerloans.controller;

import com.example.jsproducerloans.pojo.LoansTransaction;
import com.example.jsproducerloans.service.Pledge;
import com.example.jsproducerloans.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/loantypes")
@RestController
public class LoantController {

    @Autowired
    private Pledge pledge;

    //全部贷款类型
    @RequestMapping("/allloantype")
    public Result allLoantype() {
        return pledge.allLoantype();
    }

    //指定用户ID的所有贷款
    @RequestMapping("/allloanstransactionbyuid/{uid}")
    public Result allLoansTransactionByUid(@PathVariable(name = "uid")Integer uid) {
        return pledge.allLoansTransactionByUid(uid);
    }
    //生成订单
    @PostMapping(value = "/addloanstransaction")
    public Result addLoanstransaction(@RequestBody LoansTransaction loansTransaction) {
        return pledge.addLoansTransaction(loansTransaction);
    }

    //修改订单状态
    @RequestMapping("/updateloanstransactiontostate/{liid}/{state}")
    public Result updateLoanstransactionTostate(@PathVariable("liid") Integer liid, @PathVariable("state") Integer state) {
        return pledge.updateLoansTransactionToState(liid, state);
    }
}
