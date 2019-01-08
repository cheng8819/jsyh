package com.example.jsdengluprovider.controller;

import com.example.jsdengluprovider.service.UserInfoService;

import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

@RestController
@CrossOrigin(origins = "*",allowCredentials="true")
public class UserInfoController {

    @Autowired
    @Qualifier("userInfoServiceImpl")
    private UserInfoService userInfoService;

    private HttpSession httpsession;

    /**
     *     用户登录接口
     * @param name 用户名/手机号/银行卡号
     * @param password 网银密码
     *                先判断用户名密码是否正确，正确后再判断cookie密文是否第一次登录，如果不是需要进行第二次验证
     */
    @RequestMapping("/login")
    public String login(@RequestParam("name") String name,@RequestParam("password") String password,HttpServletRequest request) throws Exception {
        //System.out.println("*********"+request.getSession().getId());
        String login = userInfoService.login(name, password,request);
        System.out.println("111");
        //httpsession = request.getSession();
        //System.out.println("sessionid === "  + request.getSession().getId());
        return login;
        /*try {
            //获取subject
            Subject subject = SecurityUtils.getSubject();
            //封装用户数据

            UsernamePasswordToken token = new UsernamePasswordToken(name,password);

            subject.login(token);
            //登录成功
            userInfoService.loginSuccess(name,response);
            return "登录成功";
        }catch (UnknownAccountException e){
            //登录失败
            return "用户名不存在";
        }catch (IncorrectCredentialsException e){
            return "密码错误";
        }catch (Exception e){
            return "未授权";
        }*/
    }

    /**
     * 获取登录状态
     * @param request
     * @return
     * @throws ParseException
     * @throws JOSEException
     */
    @RequestMapping("/getLoginStateInfo")
    public String getLoginStateInfo(HttpServletRequest request) throws ParseException, JOSEException {
        return userInfoService.getLoginStateInfo(request);
    }

    /**
     * 根据token获取身份证号码
     * @param token
     * @return
     * @throws ParseException
     * @throws JOSEException
     */
    @RequestMapping("/tokenGetIdCard")
    public String tokenGetIdCard(String token) throws ParseException, JOSEException {
        return userInfoService.tokenGetIdCard(token);
    }

    /**
     * 登录验证码发送
     * 操作状态记录 1，登录验证码 2.修改密码验证码
     *
     */
    @RequestMapping("/loginsms")
    public String loginsms(@RequestParam("phoneNumber") String phoneNumber){
        return userInfoService.loginSendSms(phoneNumber);
    }

    /**
     * 登录状态下修改密码短信验证码
     * @param phoneNumber 手机号码
     * 操作状态记录 1，登录验证码 2.修改密码验证码
     * @return
     */
    @RequestMapping("/updatePassword")
    public String updatePasword(String phoneNumber){
        return userInfoService.updatePasswordSendSMS(phoneNumber,"2");
    }

    /**
     * 查询当前登录用户名手机号
     */
    @RequestMapping("/getNamePhone")
    public String getNamePhone(String name){
        return userInfoService.getPhone(name);
    }

    /**
     * 验证登录验证码是否正确
     * 200成功
     * VerifyTheLoginVerificationCode?phoneNumber=17603452718&smsCode=
     */
    @RequestMapping("/VerifyTheLoginVerificationCode")
    public String verifyTheLoginVerificationCode(@RequestParam("phoneNumber") String phoneNumber,@RequestParam("smsCode") String smsCode,HttpServletResponse response) throws Exception {
        return userInfoService.verifySMSCode(phoneNumber,smsCode,"1");
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
    public String verifyUserUdentityUnformation(String phone,String clientName,String IDNumber,String IDType){
        return "";
    }
    /**
     * 银行卡密码验证
     */
    @RequestMapping("BankPasswordverification")
    public String bankPasswordverification(String IDNumber,String password,HttpServletRequest request,HttpServletResponse response){
         return userInfoService.bankPasswordverification(IDNumber,password,request,response);
    }


/*    *//**
     * 通过用户后台id查询银行卡账号
     *//*
    @RequestMapping("/selectClientBankNumber")
    public String selectClientBankNumber(HttpServletRequest request){
        return userInfoService.selectClientBankNumber(request);
    }*/

    /**
     * 获取登录名的手机号码
     */
    @RequestMapping("/GetLoginNamePhoneNumber")
    public String getLoginNamePhoneNumber(String name){
        return userInfoService.getPhone(name);
    }

    /**
     * 判断当前页面是否为第一次登录
     * request 获取cookie值，不正确需要发送验证码
     * 0为第一次
     * 1为不是第一次
     */
    @RequestMapping("/IsThisYourFirstLogin")
    public String isThisYourFirstLogin(String name,HttpServletRequest request){
        //userInfoService.IsThisYourFirstLogin(name,request);
        return userInfoService.isThisYourFirstLogin(name,request);
    }


    @RequestMapping("/gettokenww")
    public String gnjnskf(HttpServletRequest request,HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();

        String userid = request.getHeader("userid");
        String userids = request.getHeader("idcard");
        System.out.println(userid);
        System.out.println(userids);
        try {
            for (Cookie c : cookies) {
                if (c.getName().equals("TOKEN")) {
                    return c.getValue();
                }
            }
        } catch (Exception x) {
            return "11a";
        }
        return "11b";
    }

    /**
     * 获取token
     */
    @RequestMapping("/getToken")
    public String a(HttpServletRequest request){
        return request.getHeader("TOKEN")==null?"请登录":request.getHeader("TOKEN");
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
    public String changePassWord(String phone,String Passbefore,String NewPassword,HttpServletRequest request){

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
