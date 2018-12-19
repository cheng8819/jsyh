package com.cloud.jsproducerremittance.controller;

import com.cloud.jsproducerremittance.entity.RemittanceTransaction;
import com.cloud.jsproducerremittance.service.impl.ApplicationInformationServiceImpl;
import com.cloud.jsproducerremittance.service.impl.GeneralRemittanceServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "单笔汇款")
@RestController
public class ToApplyDorRheRemittance {
    @Autowired
    private ApplicationInformationServiceImpl applicationInformationService;
    @Autowired
    private GeneralRemittanceServiceImpl generalRemittanceService;
    @PostMapping(value = "/addmessage")
    public RemittanceTransaction addMessage(@ApiParam(required = true, name = "remittanceTransaction", value = "添加收款人信息") @RequestBody RemittanceTransaction remittanceTransaction){
        return applicationInformationService.addApplicationInformationService(remittanceTransaction);
    }
    @PostMapping(value = "addgeneralremittance")
    public RemittanceTransaction addGeneralRemittance(@ApiParam(required = true, name = "remittanceTransaction", value = "添加收款人信息") @RequestBody RemittanceTransaction remittanceTransaction){
        return generalRemittanceService.addGeneralRemittancerecord(remittanceTransaction);
    }
    @PostMapping(value = "aaa")
    public String all(@ApiParam(required = true, name = "remittanceTransaction", value = "添加收款人信息") @RequestBody RemittanceTransaction remittanceTransaction){
        generalRemittanceService.addGeneralRemittance(remittanceTransaction);
        return "啊啊啊";
    }

}
