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

    @RequestMapping("/allloantype")
    public Result allLoantype() {
        return pledge.allLoantype();
    }

    @RequestMapping("/allloanstransactionbyuid/{uid}")
    public Result allLoansTransactionByUid(@PathVariable(name = "uid")Integer uid) {
        return pledge.allLoansTransactionByUid(uid);
    }

    @PostMapping(value = "/addloanstransaction")
    public Result addLoanstransaction(@RequestBody LoansTransaction loansTransaction) {
        return pledge.addLoansTransaction(loansTransaction);
    }

    @RequestMapping("/updateloanstransactiontostate/{liid}/{state}")
    public Result updateLoanstransactionTostate(@PathVariable("liid") Integer liid, @PathVariable("state") Integer state) {
        return pledge.updateLoansTransactionToState(liid, state);
    }
}
