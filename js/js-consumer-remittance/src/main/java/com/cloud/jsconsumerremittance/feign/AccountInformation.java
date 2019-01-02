package com.cloud.jsconsumerremittance.feign;

import org.springframework.web.bind.annotation.RequestMapping;

public interface AccountInformation {
    //查银行卡号
    @RequestMapping(value ="/idnumberSelectCardnumber" )
    public String idnumberSelectCardnumber(String idnumber);
    //查余额
    @RequestMapping(value ="/selectBalance" )
    public Double selectBalance(String cardnumber);
    //加余额
    @RequestMapping(value ="/deposit" )
    public boolean deposit(String cardnumber,Double core,String type);
    //减余额
    @RequestMapping(value ="/remittance" )
    public boolean remittance(String cardnumber,Double core ,String type);
    //查银行卡状态
    @RequestMapping(value ="/cardnumberSelectState" )
    public String cardnumberSelectState(String cardnumber);
}
