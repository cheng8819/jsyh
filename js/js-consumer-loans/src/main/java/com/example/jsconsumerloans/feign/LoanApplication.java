package com.example.jsconsumerloans.feign;

import com.example.jsconsumerloans.pojo.LoansUserinfo;
import com.example.jsconsumerloans.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "JS-PRODUCER-LOANS")
public interface LoanApplication {

    @PostMapping("/loanapplication/loanapplications")
    Result loanApplications(LoansUserinfo loansUserinfo);
}
