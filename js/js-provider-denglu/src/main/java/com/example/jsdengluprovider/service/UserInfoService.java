package com.example.jsdengluprovider.service;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserInfoService {
    /**
     * 登录验证
     *
     * @param name     用户名
     * @param password 密码
     * @param request  cookie密文  判断是否需要验证手机号码
     * @return
     */
    public String login(String name, String password, HttpServletRequest request,HttpServletResponse response);

    /**
     * 验证短信验证码
     *
     * @param phone   手机号码
     * @param SMSCode 验证码
     */
    public String verifySMSCode(String phone, String SMSCode,String operationState, HttpServletResponse response);

    /**
     * @param name 用户名获取手机号码
     *             <p>
     *             获取手机号码
     */
    public String getPhone(String name);

    /**
     * 给登陆手机发送验证码
     * @param operationState 操作状态码
     */
    public String loginSendSms(String phoneNum,String operationState);


    public String addToRedis(String respCode, String phoneNum, String param, String result);

    /**
     * 判断页面是否为第一次登录
     * 1为不是第一次登录
     * 0为第一次登录
     */
    public String IsThisYourFirstLogin(String name,HttpServletRequest request);

    /**
     * 修改密码短信验证码
     * @param phoneNum 手机号码
     *
     */
    public String UpdatePasswordSendSMS(String phoneNum,String operationState);

    /**
     * 用户查询拿到银行卡号
     */
    public String selectClientBankNumber(HttpServletRequest request);

    /**
     * 银行卡密码验证
     */
    public String BankPasswordverification(String IDNumber,String password,HttpServletRequest request,HttpServletResponse response);

    /**
     * 修改密码
     */
    String UpdateInternetBankPassword(String onePassword,String twoPassword,HttpServletRequest request,HttpServletResponse response);

    /**
     * 注册
     */
    String register(String UserName,String CertificateType,String IDNumber,String PhoneNumber);
}
