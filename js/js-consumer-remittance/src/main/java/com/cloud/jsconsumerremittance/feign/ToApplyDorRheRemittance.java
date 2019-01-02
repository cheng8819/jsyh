package com.cloud.jsconsumerremittance.feign;

import com.cloud.jsconsumerremittance.pojo.RemittanceTransaction;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "js-producer-remittance" )
public interface ToApplyDorRheRemittance {
    @PostMapping(value = "/addmessage")
    public RemittanceTransaction addMessage(@RequestBody RemittanceTransaction remittanceTransaction);
    @PostMapping(value = "addgeneralremittance")
    public RemittanceTransaction addGeneralRemittance(@RequestBody RemittanceTransaction remittanceTransaction);
    @PutMapping("/updateState")
    public String updateState(@RequestBody RemittanceTransaction remittanceTransaction);
}
