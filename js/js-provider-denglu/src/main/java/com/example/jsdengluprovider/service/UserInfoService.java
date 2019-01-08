package com.example.jsdengluprovider.service;

import com.nimbusds.jose.JOSEException;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

public interface UserInfoService {
    /**
     * 登录验证
     *
     * @param name     用户名
     * @param password 密码
     *
     * @return
     */
    String login(String name, String password,HttpServletRequest request) throws Exception;

    /**
     * 验证短信验证码
     *
     * @param phone   手机号码
     * @param SMSCode 验证码
     */
    String verifySMSCode(String phone, String SMSCode,String operationState) throws Exception;

    /**
     * @param name 用户名获取手机号码
     *             <p>
     *             获取手机号码
     */
    String getPhone(String name);

    /**
     * 给登陆手机发送验证码
     *
     */
    String loginSendSms(String phoneNum);


    String addToRedis(String respCode, String phoneNum, String param, String result);

    /**
     * 判断页面是否为第一次登录
     * 1为不是第一次登录
     * 0为第一次登录
     */
    String isThisYourFirstLogin(String name,HttpServletRequest request);

    /**
     * 修改密码短信验证码
     * @param phoneNum 手机号码
     *
     */
    String updatePasswordSendSMS(String phoneNum,String operationState);


    /**
     * 银行卡密码验证
     */
    String bankPasswordverification(String IDNumber,String password,HttpServletRequest request,HttpServletResponse response);

    /**
     * 忘记密码服务修改密码
     */
    String updateInternetBankPassword(String onePassword,String twoPassword,HttpServletRequest request,HttpServletResponse response);

    /**
     * 注册
     */
    String register(String UserName,String CertificateType,String IDNumber,String PhoneNumber);

    /**
     * 忘记密码身份验证
     */
    String forgetPasswordAuthentication(String name, String IDNumber, HttpServletRequest request);

    /**
     * 登录成功后的策略
     */
    String loginSuccess(String name,HttpServletRequest request,HttpServletResponse response);

    /**
     * 登录状态获取用户信息
     */
    String getLoginStateInfo(HttpServletRequest request) throws ParseException, JOSEException;

    /**
     * token获取用户身份证号码
     */
    String tokenGetIdCard(String token) throws ParseException, JOSEException;
}