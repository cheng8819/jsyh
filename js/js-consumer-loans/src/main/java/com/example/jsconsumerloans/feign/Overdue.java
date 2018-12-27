package com.example.jsconsumerloans.feign;

import com.example.jsconsumerloans.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "JS-PRODUCER-LOANS")
public interface Overdue {

    //指定用户ID和订单ID查询逾期订单
    @RequestMapping(value = "/overduecontroller/allloansoverduebyuidandloid/{uid}/{ltid}", method = RequestMethod.GET)
    Result allLoansOverdueByuidAndloid(@PathVariable("uid") Integer uid, @PathVariable("ltid") Integer ltid);

    //指定用户ID所有的住房贷款
    @RequestMapping(value = "/overduecontroller/loandetailsbyuidcon/{uid}",method = RequestMethod.GET)
    Result loanDetailsByuidCon(@PathVariable("uid") Integer uid);

    //指定用户ID所有的质押贷款
    @RequestMapping(value = "/overduecontroller/loandetailsbyuidconz/{uid}",method = RequestMethod.GET)
    Result loanDetailsByuidConz(@PathVariable("uid") Integer uid);

    //指定订单的还款
    @RequestMapping(value = "/overduecontroller/repaymenting/{liid}",method = RequestMethod.GET)
    Result repaymenting(@PathVariable("liid") Integer liid);
}
