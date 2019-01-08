package com.example.jsdengluprovider.controller;

import com.example.jsdengluprovider.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 忘记密码修改密码
 */
@RequestMapping("/forgetThePassword")
public class ForgetThePassword {

    @Autowired
    @Qualifier("userInfoServiceImpl")
    private UserInfoService userInfoService;


    /**
     * 点击忘记密码提前先清除cookie
     */
    @RequestMapping("/clearnCookie")
    public String clearnCookie(HttpServletResponse response){
        Cookie newCookie=new Cookie("forgetThePasswordPhone",null); //假如要删除名称为username的Cookie
        newCookie.setMaxAge(0); //立即删除型
        newCookie.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除
        response.addCookie(newCookie); //重新写入，将覆盖之前的
        return "200";
    }


    /**
     * 发送验证码修改密码
     * 操作状态记录 1，登录验证码 2.修改密码验证码
     */
    @RequestMapping("/VerifyTheUpdatePasswordVerificationCode")
    public String verifyTheUpdatePasswordVerificationCode(@RequestParam("phoneNumber") String phoneNumber){
        return  userInfoService.loginSendSms(phoneNumber);
    }

    /**
     * 验证修改验证码是否正确
     */
    @RequestMapping("/CodeIsItRight")
    public String codeIsItRight(@RequestParam("phoneNumber") String phoneNumber, @RequestParam("smsCode") String smsCode, HttpServletResponse response) throws Exception {
        return userInfoService.verifySMSCode(phoneNumber,smsCode,"2");
    }

    /**
     * 发送用户的姓名身份证号码验证是否正确
     * 200 成功 500失败
     */
    @RequestMapping("/authentication")
    public String sendClientNameIdNumber(String name , String IDNumber , HttpServletRequest request){
        return userInfoService.forgetPasswordAuthentication(name,IDNumber,request);
    }

    /**
     * 设置新密码
     */
    @RequestMapping("/settingNewPassword")
    public String settingNewPassWord(String onePassWord,String twoPassWord,HttpServletRequest request,HttpServletResponse response){
        return userInfoService.updateInternetBankPassword(onePassWord,twoPassWord,request,response);
    }

}
