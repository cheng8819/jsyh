package com.example.jsconsumerloans.feign;

import com.example.jsconsumerloans.feign.impl.OperationalAmountImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "js-producer-management",fallback = OperationalAmountImpl.class)
public interface OperationalAmount {

    //查银行卡号
    @RequestMapping(value ="/card/idnumberSelectCardnumber" )
    String idnumberSelectCardnumber(@RequestParam("idnumber") String idnumber);

    //查余额
    @RequestMapping(value ="/card/selectBalance" )
    Double selectBalance(@RequestParam("cardnumber") String cardnumber);

    //加余额
    @RequestMapping(value ="/card/deposit" )
    boolean deposit(@RequestParam("cardnumber") String cardnumber,@RequestParam("core") Double core,@RequestParam("type") String type);

    //减余额
    @RequestMapping(value ="/card/remittance" )
    boolean remittance(@RequestParam("cardnumber")String cardnumber,@RequestParam("core") Double core ,@RequestParam("type") String type);

    //查银行卡状态
    @RequestMapping(value ="/card/cardnumberSelectState")
    String cardnumberSelectState(@RequestParam("cardnumber") String cardnumber);
}
