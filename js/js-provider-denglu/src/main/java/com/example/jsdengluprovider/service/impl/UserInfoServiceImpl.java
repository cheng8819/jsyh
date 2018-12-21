package com.example.jsdengluprovider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.jsdengluprovider.dao.JsclientbankDao;
import com.example.jsdengluprovider.dao.JsclientinfoDao;
import com.example.jsdengluprovider.dao.JsclientinternetbankinfoDao;
import com.example.jsdengluprovider.pojo.Jsclientbank;
import com.example.jsdengluprovider.pojo.Jsclientinfo;
import com.example.jsdengluprovider.pojo.Jsclientinternetbankinfo;
import com.example.jsdengluprovider.service.UserInfoService;
import com.example.jsdengluprovider.util.IndustrySMS;
import com.example.jsdengluprovider.util.PassWord;
import com.example.jsdengluprovider.util.RedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.IDN;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("ALL")
@Service("userInfoServiceImpl")
public class UserInfoServiceImpl implements UserInfoService {
    private static Logger log = Logger.getLogger(UserInfoServiceImpl.class.getClass());


    @Autowired
    private JsclientinternetbankinfoDao jsclientinternetbankinfoDao;

    @Autowired
    private JsclientbankDao jsclientbankDao;

    @Autowired
    private JsclientinfoDao jsclientinfoDao;


    @Autowired
    private RedisUtil jedis;

    public RedisUtil getJedis() {
        return jedis;
    }

    public void setJedis(RedisUtil jedis) {
        this.jedis = jedis;
    }

    private JedisPool jedispool;

    public JedisPool getJedispool() {
        return jedispool;
    }

    public void setJedispool(JedisPool jedispool) {
        this.jedispool = jedispool;
    }


    final static String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
    final static String BANK_NUMBER_REG = "[0-9]{19}";


    /**
     * 对比验证码
     *
     * @param
     * @return 1 验证失败 0 验证成功
     */
    public String varParam(String phone, String paramInput) {

        String str = "1";
        String param = (String) jedis.get(phone);

        if (paramInput.equals(param)) {
            str = "0";
            jedis.del(phone);
        }
        return str;
    }

    @Override
    public String login(String name, String password, HttpServletRequest request, HttpServletResponse response) {
        String phone = getPhone(name);

        Cookie[] cookies = request.getCookies();
        String LoginEquipment = null;
        //取出cookie的加密密文与服务器进行对比，如果不对需要先进行设备验证
        for (Cookie a : cookies) {
            if (a.getName().equals(phone)) {
                LoginEquipment = a.getValue();
                break;
            } else {
                LoginEquipment = "500";
            }
        }
        Jsclientinternetbankinfo jsclientinternetbankinfo = null;
        if (LoginEquipment.equals("541789798")) {
            if (name.matches(PHONE_NUMBER_REG)) {
                //手机号登录
                jsclientinternetbankinfo = jsclientinternetbankinfoDao.phonelogin(name, password);
                if (jsclientinternetbankinfo != null) {
                    System.out.println("手机登录成功");
                    AddLoginSuccess(response, jsclientinternetbankinfo);
                    return "200";
                }
                return "403";
            } else if (name.matches(BANK_NUMBER_REG)) {
                //银行卡登录
                jsclientinternetbankinfo = jsclientinternetbankinfoDao.bankNumberLogin(name, password);
                if (jsclientinternetbankinfo != null) {
                    System.out.println("银行登录成功");
                    AddLoginSuccess(response, jsclientinternetbankinfo);
                    return "200";
                }
                return "403";
            } else {
                //用户名登录
                jsclientinternetbankinfo = jsclientinternetbankinfoDao.userNameLogin(name, password);
                if (jsclientinternetbankinfo != null) {
                    System.out.println("用户名登录成功");
                    AddLoginSuccess(response, jsclientinternetbankinfo);
                    return "200";
                }
                return "403";
            }
        } else {
            return "cookie密文认证成功";
        }
    }

    /**
     * 用户登录成功添加cookie信息
     */
    public String AddLoginSuccess(HttpServletResponse response, Jsclientinternetbankinfo jsclientinternetbankinfo) {
        Cookie cookie1 = new Cookie("loginSuccess", String.valueOf(jsclientinternetbankinfo.getJsClientid()));
        Cookie cookie2 = new Cookie("loginSuccessCookie", jsclientinternetbankinfo.getJsCookierecord());
        cookie1.setMaxAge(60 * 60);            // Cookie有效时间
        // 3.通过response对象将Cookie写入浏览器，当然需要解决中文乱码问题，否则会抛出异常
        // java.lang.IllegalArgumentException: Control character in cookie value, consider BASE64 encoding your value
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "添加成功";
    }

    /**
     * 用户查询拿到银行卡号
     */
    @Override
    public String selectClientBankNumber(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String bankNumber = null;
        String ClientBackgroundId = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("loginSuccess")) {
                //获取用户后台ID
                ClientBackgroundId = c.getValue();
                break;
            }
        }
        if (ClientBackgroundId != null) {
            return jsclientbankDao.selectBankId(Integer.parseInt(ClientBackgroundId));
        } else {
            return "该用户未办理我行卡";
        }
    }

    /**
     * 银行卡密码验证
     */
    @Override
    public String BankPasswordverification(String IDNumber, String password, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String bankNumber = null;
        String ClientBackgroundId = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("loginSuccess")) {
                //获取用户后台ID
                ClientBackgroundId = c.getValue();
                break;
            }
        }
        if (jsclientbankDao.selectBankPasswordRight(IDNumber, password, Integer.parseInt(ClientBackgroundId)) == 1) {
            Cookie cookie = new Cookie("bankpassword", IDNumber);
            cookie.setMaxAge(60 * 60);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.addCookie(cookie);
            return "成功";
        } else {
            return "失败";
        }
    }

    /**
     * 添加新密码
     *
     * @param onePassword
     * @param twoPassword
     * @param request
     * @param response
     * @return
     */

    @Override
    public String UpdateInternetBankPassword(String onePassword, String twoPassword, HttpServletRequest request, HttpServletResponse response) {
        if (onePassword.equals(twoPassword)) {
            Cookie[] cookies = request.getCookies();
            String ClientBackgroundId = null;
            //验证密码格式
            if (PassWord.PassWordFormat(onePassword)) {
                //验证密码长度
                if (PassWord.PassWordLength(onePassword)) {
                    for (Cookie c : cookies) {
                        if (c.getName().equals("loginSuccess")) {
                            //获取用户后台ID
                            ClientBackgroundId = c.getValue();
                            break;
                        }
                    }
                    int i = jsclientinternetbankinfoDao.UpdatePassWord(Integer.parseInt(ClientBackgroundId), onePassword);
                    if (i==1){
                        return "修改成功";
                    }else {
                        return "修改失败，请重新尝试";
                    }
                }else {
                    return "密码至少为8位，但不超过16位";
                }
            }else {
                return "至少包含两种以上字符";
            }
        } else {
            return "两次密码不一致";
        }
    }


    /**
     * 显示当前银行卡号的手机号
     */
    public String BankPhoneNumber(String bankNumber) {
        String phoneNum = null;
        Jsclientbank jsclientbank = jsclientbankDao.queryById(bankNumber);
        Jsclientinfo jsclientinfo = jsclientinfoDao.queryById(jsclientbank.getJsClientid());
        phoneNum = jsclientinfo.getJsPhonenumber();
        if (phoneNum.equals("") || phoneNum.equals(null)) {
            return "没有该用户";
        }
        return phoneNum;
    }

    /**
     * 验证短信验证码
     *
     * @param phone          手机号码
     * @param SMSCode        验证码
     * @param operationState 操作状态码 1 登录 2 修改密码
     */
    @Override
    public String verifySMSCode(String phone, String SMSCode, String operationState, HttpServletResponse response) {
        String s = varParam(phone + operationState, SMSCode);
        if (s.equals("0")) {
            Cookie userCookie = new Cookie(phone, "541789798");
            userCookie.setMaxAge(7 * 24 * 60 * 60); //存活期为一个月 30*24*60*60
            userCookie.setPath("/");
            response.addCookie(userCookie);
            return "200";
        }
        return "失败";
    }

    /**
     * 判断页面是否为第一次登录
     * 1为不是第一次登录
     * 0为第一次登录
     */
    public String IsThisYourFirstLogin(String name, HttpServletRequest request) {
        String phone = getPhone(name);
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals(name)) {
                c.getValue().equals("541789798");
                return "1";
            }
        }
        return "0";

    }

    /**
     * 获取手机号码
     */
    @Override
    public String getPhone(String name) {
        String phoneNum = null;
        if (name.matches(PHONE_NUMBER_REG)) {
            return name;
        } else if (name.matches(BANK_NUMBER_REG)) {
            return BankPhoneNumber(name);
        } else if (!name.matches(PHONE_NUMBER_REG) & !name.matches(BANK_NUMBER_REG)) {
            return jsclientinternetbankinfoDao.getPhone(name);
        } else {
            return "406";
        }

    }

    /**
     * 给登陆手机发送验证码
     */
    @Override
    public String loginSendSms(String phoneNum, String operationState) {
        String str = null;
        //是电话号码
        //发送短信
        if (phoneNum != "406") {
            Map<String, Object> execute = IndustrySMS.execute(phoneNum, 100);
            String result = (String) execute.get("result");
            String param = (String) execute.get("param");
            JSONObject parse = JSONObject.parseObject(result);
            String respCode = parse.getString("respCode");
            result = addToRedis(respCode, phoneNum + operationState, param, result);
            str = result;
            System.out.println(str);
            return str;
        }
        return "号码错误，短信发送失败";
    }

    /**
     * 修改密码验证码
     *
     * @param phoneNum
     * @param operationState 操作记录
     * @return
     */
    @Override
    public String UpdatePasswordSendSMS(String phoneNum, String operationState) {
        String str = null;
        //是电话号码
        //发送短信
        if (phoneNum != "406") {
            Map<String, Object> execute = IndustrySMS.execute(phoneNum, 101);
            String result = (String) execute.get("result");
            String param = (String) execute.get("param");
            JSONObject parse = JSONObject.parseObject(result);
            String respCode = parse.getString("respCode");
            result = addToRedis(respCode, phoneNum + operationState, param, result);
            str = result;
            System.out.println(str);
            return str;
        }
        return "号码错误，短信发送失败";
    }


    public String addToRedis(String respCode, String phoneNum, String param, String result) {
        try {
            if (respCode.equals("00000")) {
                System.out.println(phoneNum + " || " + param);
                jedis.set(phoneNum, param);
                // jedis.expire(phoneNum,300);
                try {
                    final Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            if (jedis.get(phoneNum).equals(null)) {
                                jedis.del(phoneNum);
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
            log.info(e);
            result = "redis error";
            return result;
        } finally {
            //getJedis().close();
            return result;
        }
    }


    /**
     * 注册
     */
    public String register(String UserName,String CertificateType,String IDNumber,String PhoneNumber){

        return "";
    }

}
