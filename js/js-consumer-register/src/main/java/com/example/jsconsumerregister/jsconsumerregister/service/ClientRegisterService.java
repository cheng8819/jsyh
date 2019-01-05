package com.example.jsconsumerregister.jsconsumerregister.service;

import com.service.pojo.ClientRegister;
import com.service.pojo.ClientRegisterBankInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ClientRegisterService {
    /**
     * 用户注册
     *
     * @param clientRegister
     * @return
     */
    String clientRegister(ClientRegister clientRegister, HttpServletResponse response);

    /**
     * 发送注册时的验证码
     */
    String sendRegisterSMS(String bankIdCard,String phone);

    /**
     * 验证短信码
     *
     * @param phone
     * @param code
     * @param response
     * @return
     */
    String registerSmsVerificationCodeJudgment(String phone, String code, HttpServletResponse response);

    /**
     * 用户注册添加验证银行卡信息
     */
    String clientRegisterAddBankIdCardInfo(ClientRegisterBankInfo clientRegisterBankInfo, HttpServletRequest request);
    /**
     * 银行卡页面发送短信验证码
     * Bank card page to send SMS verification code
     */

    String bankCardPageToSendSmsVerificationCode(HttpServletRequest request,String internetBankPhone,String bankIdCard);
}