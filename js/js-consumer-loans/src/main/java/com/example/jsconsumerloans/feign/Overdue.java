package com.example.jsconsumerloans.feign;

import com.example.jsconsumerloans.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "JS-PRODUCER-LOANS")
public interface Overdue {

    @RequestMapping(value = "/overduecontroller/allloansoverduebyuidandloid/{uid}/{ltid}", method = RequestMethod.GET)
    Result allLoansOverdueByuidAndloid(@PathVariable("uid") Integer uid, @PathVariable("ltid") Integer ltid);
}
