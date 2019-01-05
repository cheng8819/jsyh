package com.example.jsconsumerregister.jsconsumerregister.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsconsumerregister.jsconsumerregister.service.ClientRegisterService;
import com.service.pojo.ClientRegister;
import com.service.pojo.ClientRegisterBankInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Api(value="信息",tags={"as"} )
@RestController
@CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
public class ClientRegistersController {

    @Autowired
    @Qualifier("clientRegisterServiceImpl")
    private ClientRegisterService clientRegisterService;

    /**
     * 用户注册
     * 传入参数
     * 姓名
     * 身份证号码
     * 手机号
     * 证件类型
     */
    @ApiOperation(value="one",notes="qw")
    @RequestMapping(value = "/registers",method = RequestMethod.POST)
    public String clientRegister(@RequestBody ClientRegister clientRegister,HttpServletResponse response){
        System.out.println(JSON.toJSONString(clientRegister));
        String s = clientRegisterService.clientRegister(clientRegister,response);
        if (s.equals("200")){
            return "200";
        }
       return "403";
    }

    /**
     * 用户注册添加银行卡信息
     * 参数
     * 银行卡号
     * 银行卡密码
     * 用户登录名
     * 银行卡预留电话
     * 网银登录密码
     * 短信验证码
     */
    @RequestMapping(value = "/clientRegisterAddBankIdCardInfos",method = RequestMethod.POST)
    public String clientRegisterAddBankIdCardInfo(@RequestBody ClientRegisterBankInfo clientRegisterBankInfo, HttpServletRequest request){
        return clientRegisterService.clientRegisterAddBankIdCardInfo(clientRegisterBankInfo,request);
    }

    /**
     * 银行卡页面发送短信验证码
     * Bank card page to send SMS verification code
     */
    @RequestMapping(value = "/BankCardPageToSendSmsVerificationCodes",method = RequestMethod.GET)
    public String bankCardPageToSendSmsVerificationCode(HttpServletRequest request,@RequestParam("internetBankPhone") String internetBankPhone,@RequestParam("bankIdCard") String bankIdCard){
        return clientRegisterService.bankCardPageToSendSmsVerificationCode(request,internetBankPhone,bankIdCard);
    }


    /**
     * 发送注册时的短信验证码
     */
/*    @RequestMapping(value = "/SendRegisterSMSs",method = RequestMethod.GET)
    public String sendRegisterSMS(@RequestParam("bankIdCard") String bankIdCard,@RequestParam("phone") String phone){
        return clientRegisterService.sendRegisterSMS(bankIdCard,phone);
    }*/

    /**
     * 用户注册添加验证银行卡信息
     */

    /**
     * 验证注册时银行卡的短信验证码
     */

    /**
     * 查询该银行卡柜面预留的手机号
     * Check the mobile phone number reserved on the bank card counter
     */
    @RequestMapping(value = "/CheckTheMobilePhoneNumberReservedOnTheBankCardCounters",method = RequestMethod.GET)
    public String CheckTheMobilePhoneNumberReservedOnTheBankCardCounter(String bankNumber){
        return "";
    }

}
