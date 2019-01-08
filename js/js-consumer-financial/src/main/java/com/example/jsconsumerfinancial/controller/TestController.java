package com.example.jsconsumerfinancial.controller;

import com.example.jsconsumerfinancial.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/7 14:34
 */
@RestController
public class TestController {

    @Autowired
    private ManagementService managementService;

    @ResponseBody
    @RequestMapping(value = "/selectBalance")
    public String test(@RequestParam("cardnumber") String cardnumber){
        /*228211659001411572*/
        Double balance = managementService.selectBalance(cardnumber);
        return String.valueOf(balance);
    }

    @RequestMapping(value = "/remittance")
    public boolean remittance(@RequestParam("cardnumber") String cardnumber,
                             @RequestParam("core") Double core,
                             @RequestParam("type") String type){
        boolean flag = managementService.remittance(cardnumber,core,type);
        return flag;
    }

    @RequestMapping(value = "/deposit")
    public boolean deposit(@RequestParam("cardnumber") String cardnumber,
                              @RequestParam("core") Double core,
                              @RequestParam("type") String type){
        boolean flag = managementService.deposit(cardnumber,core,type);
        return flag;
    }

    /*@RequestMapping(value = "/solr")
    *//*public String add(){
        *//**//*return SolrUtil.addDocument();*//**//*
    }*/

}
