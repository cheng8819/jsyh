package com.example.jsconsumerloans.feign;

import com.example.jsconsumerloans.feign.impl.LoanApplicationImpl;
import com.example.jsconsumerloans.pojo.LoansUserinfo;
import com.example.jsconsumerloans.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "JS-PRODUCER-LOANS",fallback = LoanApplicationImpl.class)
public interface LoanApplication {

     //贷款申请
    @PostMapping("/loanapplication/loanapplications")
    Result loanApplications(LoansUserinfo loansUserinfo);

    /**
     * 根据uid查询用户贷款申请进度
     * @param uid
     * @return
     */
    @GetMapping("/loanScheduleCon/{uid}")
    Result LoanScheduleCon(@PathVariable("uid") Integer uid);
}
