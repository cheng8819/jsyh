package com.example.jsconsumerloans.feign;


import com.example.jsconsumerloans.feign.impl.LoansImpl;
import com.example.jsconsumerloans.pojo.LoansTransaction;
import com.example.jsconsumerloans.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "JS-PRODUCER-LOANS",fallback = LoansImpl.class)
public interface Loans {

    //全部贷款类型
    @RequestMapping(value = "/loantypes/allloantype", method = RequestMethod.GET)
    Result allLoantype();

    //指定用户ID的所有贷款
    @RequestMapping(value = "/loantypes/allloanstransactionbyuid/{uid}", method = RequestMethod.GET)
    Result allLoansTransactionByUid(@PathVariable(name = "uid")Integer uid);

    //生成订单
    @RequestMapping(value = "/loantypes/addloanstransaction", method = RequestMethod.POST)
    Result addLoanstransaction(LoansTransaction loansTransaction);

    //修改订单状态
    @RequestMapping(value = "/loantypes/updateloanstransactiontostate/{liid}/{state}", method = RequestMethod.GET)
    Result updateLoanstransactionTostate(@PathVariable("liid") Integer liid, @PathVariable("state") Integer state);

    //根据订单ID查询订单
    @RequestMapping(value = "/loantypes/selectLoansTransactionByid/{id}",method = RequestMethod.GET)
    Result selectLoansTransactionByid(@PathVariable("id") Integer id);

    //根据申请资料查询订单
    @RequestMapping(value = "/loantypes/selectLoansTransactionByData/{id}",method = RequestMethod.GET)
    Result selectLoansTransactionByData(@PathVariable("id") String id);

    //全部住房贷款种类
    @GetMapping("/loantypes/slectAllLoansType")
    Result slectAllLoansType();

    //全部学历
    @GetMapping("/loantypes/selectAllEducation")
    Result selectAllEducation();

    //全部职业
    @GetMapping("/loantypes/selectAllJobs")
    Result selectAllJobs();
}
