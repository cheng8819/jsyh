package com.example.jsproducerloans.controller;

import com.example.jsproducerloans.service.Repayment;
import com.example.jsproducerloans.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/overduecontroller")
public class OverdueController {

    @Qualifier("repaymentHouseImpl")
    @Autowired
    private Repayment repayment;

    @RequestMapping("/allloansoverduebyuidandloid/{uid}/{ltid}")
    public Result allLoansOverdueByuidAndloid(@PathVariable("uid") Integer uid, @PathVariable("ltid") Integer ltid) {
        return repayment.allLoansOverdueByuidAndloid(uid, ltid);
    }

    @RequestMapping("/loandetailsbyuidcon")
    public Result loanDetailsByuidCon(Integer uid){
        return repayment.loanDetailsByuid(uid);
    }

    @RequestMapping("/repaymenting")
    public Result repaymenting(Integer liid){
        return repayment.repaymenting(liid);
    }
}
