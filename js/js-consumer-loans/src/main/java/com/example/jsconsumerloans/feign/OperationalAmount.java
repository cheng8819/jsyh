package com.example.jsconsumerloans.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "js-producer-management")
public interface OperationalAmount {

    //查银行卡号
    @RequestMapping(value ="/card/idnumberSelectCardnumber" )
    String idnumberSelectCardnumber(String idnumber);

    //查余额
    @RequestMapping(value ="/card/selectBalance" )
    Double selectBalance(String cardnumber);

    //加余额
    @RequestMapping(value ="/card/deposit" )
    boolean deposit(String cardnumber,Double core,String type);

    //减余额
    @RequestMapping(value ="/card/remittance" )
    boolean remittance(String cardnumber,Double core ,String type);

    //查银行卡状态
    @RequestMapping(value ="/card/cardnumberSelectState")
    String cardnumberSelectState(String cardnumber);
}
