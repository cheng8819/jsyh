package com.example.jsdengluprovider.controller;

import com.example.jsdengluprovider.service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserInfoController {

    @Autowired
    @Qualifier("userInfoServiceImpl")
    private UserInfoService userInfoService;

    /**
     *     用户登录接口
     * @param name 用户名/手机号/银行卡号
     * @param password 网银密码
     * @param request 获取cookie值，不正确返回错误信息
     *                先判断用户名密码是否正确，正确后再判断cookie密文是否第一次登录，如果是需要进行第二次验证
     */
    @RequestMapping("/login")
    public String login(@RequestParam("name") String name,@RequestParam("password") String password, HttpServletRequest request,HttpServletResponse response){
        String login = userInfoService.login(name, password, request,response);
        return null;
    }
    /**
     * 登录验证码发送
     * 操作状态记录 1，登录验证码 2.修改密码验证码
     *
     */
    @RequestMapping("/loginsms")
    public String loginsms(@RequestParam("phoneNumber") String phoneNumber){
        return  userInfoService.loginSendSms(phoneNumber,"1");
    }

    /**
     * 修改密码短信验证码
     * @param phoneNumber 手机号码
     * 操作状态记录 1，登录验证码 2.修改密码验证码
     * @return
     */
    @RequestMapping("/UpdatePassword")
    public String UpdatePasword(String phoneNumber){
        return userInfoService.UpdatePasswordSendSMS(phoneNumber,"2");
    }

    /**
     * 验证登录验证码是否正确
     * 200成功
     * VerifyTheLoginVerificationCode?phoneNumber=17603452718&smsCode=
     */
    @RequestMapping("/VerifyTheLoginVerificationCode")
    public String VerifyTheLoginVerificationCode(@RequestParam("phoneNumber") String phoneNumber,@RequestParam("smsCode") String smsCode,HttpServletResponse response){
        return userInfoService.verifySMSCode(phoneNumber,smsCode,"1",response);
    }

    /**
     * 验证修改验证码是否正确
     */
    @RequestMapping("/VerifyTheUpdatePasswordVerificationCode")
    public String VerifyTheUpdatePasswordVerificationCode(@RequestParam("phoneNumber") String phoneNumber,@RequestParam("smsCode") String smsCode,HttpServletResponse response){
        return userInfoService.verifySMSCode(phoneNumber,smsCode,"2",response);
    }

    /**
     *
     * @param phone 电话
     * @param clientName 姓名
     * @param IDNumber  证件号码
     * @param IDType    证件类型
     * @return
     */
    @RequestMapping("VerifyUserUdentityUnformation")
    public String VerifyUserUdentityUnformation(String phone,String clientName,String IDNumber,String IDType){

        return "";
    }
    /**
     * 银行卡密码验证
     */
    @RequestMapping("BankPasswordverification")
    public String BankPasswordverification(String IDNumber,String password,HttpServletRequest request,HttpServletResponse response){
         return userInfoService.BankPasswordverification(IDNumber,password,request,response);
    }
    /**
     * 设置密码
     */
    @RequestMapping("UpdateInternetBankPassword")
    public String UpdateInternetBankPassword(String onePassword,String twoPassword,HttpServletRequest request,HttpServletResponse response){

        return null;
    }

    /**
     * 通过用户后台id查询银行卡账号
     */
    @RequestMapping("/selectClientBankNumber")
    public String selectClientBankNumber(HttpServletRequest request){
        return userInfoService.selectClientBankNumber(request);
    }

    /**
     * 获取登录名的手机号码
     */
    @RequestMapping("/GetLoginNamePhoneNumber")
    public String GetLoginNamePhoneNumber(String name){
        return userInfoService.getPhone(name);
    }

    /**
     * 判断当前页面是否为第一次登录
     * request 获取cookie值，不正确需要发送验证码
     * 0为第一次
     * 1为不是第一次
     */
    @RequestMapping("/IsThisYourFirstLogin")
    public String IsThisYourFirstLogin(String name,HttpServletRequest request){
        //userInfoService.IsThisYourFirstLogin(name,request);
        return userInfoService.IsThisYourFirstLogin(name,request);
    }



    /**
     * 绑定银行卡
     * @return
     */
    @RequestMapping("/bindBankCard")
    public String bindBankCard(){

        return null;
    }

    /**
     *  修改网银密码
     * @param phone  用户名/手机号/银行卡
     * @param Passbefore    用户之前的网银密码
     * @param NewPassword   用户新的网银密码
     * @return
     */
    @RequestMapping("/ChangePassWord")
    public String ChangePassWord(String phone,String Passbefore,String NewPassword,HttpServletRequest request){

        return null;
    }

    /**注册
     * @param UserName 客户姓名
     * @param CertificateType 证件类型
     * @param IDNumber  证件号码
     * @param PhoneNumber 手机号码
     * @return
     */
    @RequestMapping("/register")
    public String register(String UserName,String CertificateType,String IDNumber,String PhoneNumber){

        return null;
    }

}
