package com.example.jsproducerloans.controller;

import com.example.jsproducerloans.service.Repayment;
import com.example.jsproducerloans.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/overduecontroller")
public class OverdueController {

    @Qualifier("repaymentHouseImpl")
    @Autowired
    private Repayment repayment;
    @Qualifier("repaymentPledgeImpl")
    @Autowired
    private Repayment repayment1;

    //指定用户ID和订单ID查询逾期订单
    @RequestMapping("/allloansoverduebyuidandloid/{uid}/{ltid}")
    public Result allLoansOverdueByuidAndloid(@PathVariable("uid") Integer uid, @PathVariable("ltid") Integer ltid) {
        return repayment.allLoansOverdueByuidAndloid(uid, ltid);
    }

    //指定用户ID所有的住房贷款
    @RequestMapping("/loandetailsbyuidcon/{uid}")
    public Result loanDetailsByuidCon(@PathVariable("uid") Integer uid){
        return repayment.loanDetailsByuid(uid);
    }

    //指定用户ID所有的质押贷款
    @RequestMapping("/loandetailsbyuidconz/{uid}")
    public Result loanDetailsByuidConz(@PathVariable("uid") Integer uid){
        return repayment1.loanDetailsByuid(uid);
    }

    //指定订单的还款
    @RequestMapping("/repaymenting/{liid}")
    public Result repaymenting(@PathVariable("liid") Integer liid){
        return repayment.repaymenting(liid);
    }
}
