package com.cloud.jsconsumerremittance.controller;

import com.cloud.jsconsumerremittance.pojo.RemittanceTransaction;
import com.cloud.jsconsumerremittance.service.AddRemittanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Remittance {
    @Autowired
    private AddRemittanceService addRemittanceService;
    @PostMapping("/addremittance")
    public String addRemittance(RemittanceTransaction remittanceTransaction){

        return addRemittanceService.ChooseTheRemittance(remittanceTransaction);
    }
}
