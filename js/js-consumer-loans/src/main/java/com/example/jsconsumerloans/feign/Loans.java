package com.example.jsconsumerloans.feign;


import com.example.jsconsumerloans.feign.impl.LoansImpl;
import com.example.jsconsumerloans.pojo.LoansTransaction;
import com.example.jsconsumerloans.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "JS-PRODUCER-LOANS",fallback = LoansImpl.class)
public interface Loans {

    @RequestMapping(value = "/loantypes/allloantype", method = RequestMethod.GET)
    Result allLoantype();

    @RequestMapping(value = "/loantypes/allloanstransactionbyuid/{uid}", method = RequestMethod.GET)
    Result allLoansTransactionByUid(@PathVariable(name = "uid")Integer uid);

    @RequestMapping(value = "/loantypes/addloanstransaction", method = RequestMethod.POST)
    Result addLoanstransaction(LoansTransaction loansTransaction);

    @RequestMapping(value = "/loantypes/updateloanstransactiontostate/{liid}/{state}", method = RequestMethod.GET)
    Result updateLoanstransactionTostate(@PathVariable("liid") Integer liid, @PathVariable("state") Integer state);
}
