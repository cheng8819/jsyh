package com.cloud.jsconsumerremittance.feign;

import com.cloud.jsconsumerremittance.pojo.RemittanceTransaction;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "js-producer-remittance" )
public interface ToApplyDorRheRemittance {
    @PostMapping(value = "/addmessage")
    public RemittanceTransaction addMessage(RemittanceTransaction remittanceTransaction);
    @PostMapping(value = "addgeneralremittance")
    public RemittanceTransaction addGeneralRemittance(RemittanceTransaction remittanceTransaction);
}
