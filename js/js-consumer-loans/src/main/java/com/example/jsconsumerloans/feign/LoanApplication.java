package com.example.jsconsumerloans.feign;

import com.example.jsconsumerloans.feign.impl.LoanApplicationImpl;
import com.example.jsconsumerloans.pojo.LoansUserinfo;
import com.example.jsconsumerloans.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "JS-PRODUCER-LOANS",fallback = LoanApplicationImpl.class)
public interface LoanApplication {

     //贷款申请
    @PostMapping("/loanapplication/loanapplications")
    Result loanApplications(LoansUserinfo loansUserinfo);

    //获取指定审核人需要审核的贷款申请
    @RequestMapping("/loanapplication/getTaskByUserId/{userId}")
    Object getTaskByUserId(@PathVariable("userId") String userId);

    //处理待审核的贷款申请
    @RequestMapping("/loanapplication/completeTask/{taskId}/{userId}/{audit}")
    Result completeTask(@PathVariable("taskId") String taskId, @PathVariable("userId") String userId, @PathVariable("audit") String audit);
}
