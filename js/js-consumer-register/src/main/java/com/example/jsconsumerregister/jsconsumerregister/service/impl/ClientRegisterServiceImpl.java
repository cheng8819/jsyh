package com.example.jsconsumerregister.jsconsumerregister.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.encryption.Encryption;
import com.example.jsconsumerregister.jsconsumerregister.feign.ClientRegisterFeign;
import com.example.jsconsumerregister.jsconsumerregister.service.ClientRegisterService;
import com.example.jsconsumerregister.jsconsumerregister.util.IndustrySMS;
import com.example.jsconsumerregister.jsconsumerregister.util.RedisUtil;
import com.service.pojo.ClientRegister;
import com.service.pojo.ClientRegisterBankInfo;
import com.service.pojo.ClientRegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("ALL")
@Service("clientRegisterServiceImpl")
public class ClientRegisterServiceImpl implements ClientRegisterService {

    /**
     * 用户注册服务
     */
    @Autowired
    private ClientRegisterFeign clientRegisterFeign;

    /**
     * 查询用户的银行卡
     */
//    @Autowired
//    private BankCardFeign bankCardFeign;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 用户注册将第一个页面信息保存在cookie
     *
     * @param clientRegister
     * @return
     */
    @Override
    public String clientRegister(ClientRegister clientRegister, HttpServletResponse response) {
        String s1 = clientRegisterFeign.registerPhoneExists(clientRegister.getJsPhonenumber(), clientRegister.getJsIdnumber());

        if ("200".equals(s1)) {
            if (true) {//判断用户是否有银行卡
                Cookie cookie = new Cookie("USER_INFO_IDCARD", clientRegister.getJsIdnumber());
                cookie.setMaxAge(60 * 5);
                cookie.setPath("/");
                Cookie cookie1 = new Cookie("USER_INFO_NAME", clientRegister.getJsClientname());
                cookie.setMaxAge(60 * 5);
                cookie.setPath("/");
                Cookie cookie2 = new Cookie("USER_INFO_PHONE", clientRegister.getJsPhonenumber());
                cookie.setMaxAge(60 * 5);
                cookie.setPath("/");
                response.addCookie(cookie);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                return "200";
            } else {
                return "您尚未在我行办理银行卡，请先办理";
            }
        } else if ("500".equals(s1)) {
            return "身份证号已之策网银，请直接登录";
        } else {
            return "手机号已注册请直接登录";
        }
    }

    /**
     * 银行卡页面发送短信验证码
     * Bank card page to send SMS verification code
     */
    @Override
    public String bankCardPageToSendSmsVerificationCode(HttpServletRequest request, String bankPhone, String bankIdCard) {
        Cookie[] cookies = request.getCookies();
        String idNumber = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("USER_INFO_IDCARD")) {
                    idNumber = c.getValue();
                }
            }
        }
        String str = null;
        if (true) {//判断身份证号的银行卡号的手机号是否正确
            Map<String, Object> execute = IndustrySMS.execute(bankPhone, 101);
            String result = (String) execute.get("result");
            String param = (String) execute.get("param");
            JSONObject parse = JSONObject.parseObject(result);
            String respCode = parse.getString("respCode");
            result = addToRedis(respCode, bankPhone + "_REGISTER_SMS", param, result);
            str = result;
            System.out.println(str);
            return "发送成功";
        } else {
            return "银行卡或者预留信息错误";
        }
    }

    /**
     * 用户注册添加验证银行卡信息
     */
    @Transactional
    @Override
    public String clientRegisterAddBankIdCardInfo(ClientRegisterBankInfo clientRegisterBankInfo, HttpServletRequest request) {
        //判断cookie里的用户是否有这张银行卡
        //判断银行卡号和密码是否正确
        //用户名是否与数据库重复
        //短信验证码发送时判断银行卡号的手机号是否正确，这里只做判断验证码正确判断
        Cookie[] cookies = request.getCookies();
        String idCard = null;//身份证号码
        String name = null;//身份证名字
        String phone = null;//注册网银手机号
        String smsExists = null; //查看cookie是否正确

        idCard = clientRegisterBankInfo.getiDCard();

                name = clientRegisterBankInfo.getUsername();

                phone = clientRegisterBankInfo.getInternetBankPhone();
        System.out.println(idCard + "***" + name + "***" + phone);


        if (varParam(clientRegisterBankInfo.getBankCardReservationPhone() + "_REGISTER_SMS",clientRegisterBankInfo.getSmsVerificationCode())) {
            //判断银行卡短信验证码是否正确
            //phone!=null&idCard!=null&phone!=null?true:false
            if (true) {//调用根据身份证号查询银行卡号，与传进来的银行卡号是否正确，错误没有该卡
                if (true) {//传入用户身份证号和银行卡号、密码判断密码账号是否正确
                    if (true) {//用户名是否重复

                            ClientRegisterUser clientRegisterUser = new ClientRegisterUser();
                            //客户姓名
                            clientRegisterUser.setJsClientname(name);
                            //客户级别
                            //clientRegisterUser.setJsClientrank();
                            //客户证件类型
                            //clientRegisterUser.setJsCretificatetype();
                            //证件号码
                            clientRegisterUser.setJsIdnumber(idCard);
                            //客户网银密码
                            clientRegisterUser.setJsInternetbankpassword(clientRegisterBankInfo.getInternetBankPassword());
                            //客户网银手机号
                            clientRegisterUser.setJsInternetBankPhone(phone);
                            //客户网银开通状态 0关闭 1开通
                            //clientRegisterUser.setJsInternetOpenType();
                            //客户网银用户名
                            clientRegisterUser.setJsInternetbankusername(clientRegisterBankInfo.getClientUserName());
                            //注册方式
                            //clientRegisterUser.setJsRegisterway();
                            //性别
                            //clientRegisterUser.setJsSex();
                            //电话号码
                            clientRegisterUser.setJsPhonenumber(phone);
                            return clientRegisterFeign.addInternetUser(clientRegisterUser);

                    } else {
                        return "用户名已存在请重新输入";
                    }
                } else {
                    return "银行卡号或密码错误";
                }
            } else {
                return "未查询到此银行卡，请确认后重新输入";
            }
        } else {
            return "验证码错误";
        }
    }


    /**
     * 发送注册时的验证码
     *
     * @param phone
     * @param response
     * @return
     */
    @Override
    public String sendRegisterSMS(String bankIdCard, String phone) {
        if (true) {//判断银行卡号的预留手机号与手机号是否正确
            String str = null;
            Map<String, Object> execute = IndustrySMS.execute(phone, 100);
            String result = (String) execute.get("result");
            String param = (String) execute.get("param");
            JSONObject parse = JSONObject.parseObject(result);
            String respCode = parse.getString("respCode");
            result = addToRedis(respCode, phone + "_REGISTER_SMS", param, result);
            str = result;
            System.out.println(str);
            return str;
        } else {
            return "银行卡输入错误或者预留信息错误";
        }
    }


    /**
     * 对比验证码
     *
     * @param
     * @return 1 验证失败 0 验证成功
     */
    public boolean varParam(String phone, String paramInput) {

        String str = "1";
        String param = (String) redisUtil.get(phone);

        if (paramInput.equals(param)) {
            str = "0";
            redisUtil.del(phone);
            return true;
        }
        return false;
    }

    /**
     * 注册手机短信验证码验证
     *
     * @return
     */
    @Override
    public String registerSmsVerificationCodeJudgment(String phone, String code, HttpServletResponse response) {

        if (varParam(phone + "_REGISTER", code)){
            Cookie cookie = new Cookie("REGISTER_SMS_SUCCESS", Encryption.encryptBasedDes(phone));
            cookie.setMaxAge(60 * 10);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "成功";
        }
        return "失败";
    }


    public String addToRedis(String respCode, String phoneNum, String param, String result) {
        try {
            if (respCode.equals("00000")) {
                System.out.println(phoneNum + " || " + param);
                redisUtil.set(phoneNum, param, 5000);
                // jedis.expire(phoneNum,300);
                try {
                    final Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            if (redisUtil.get(phoneNum).equals(null)) {
                                redisUtil.del(phoneNum);
                            }
                            System.out.println("phoneNum删除成功");
                            //jedis.close();
                            timer.cancel();
                        }
                    }, 1 * 60 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {

            result = "redis error";
            return result;
        } finally {
            //getJedis().close();
            return result;
        }
    }
}
