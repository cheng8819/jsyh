package com.example.jsdengluprovider.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.encryption.SHAUtil;
import com.example.jsdengluprovider.dao.JsclientbankDao;
import com.example.jsdengluprovider.dao.JsclientinfoDao;
import com.example.jsdengluprovider.dao.JsclientinternetbankinfoDao;
import com.example.jsdengluprovider.pojo.Jsclientbank;
import com.example.jsdengluprovider.pojo.Jsclientinfo;
import com.example.jsdengluprovider.pojo.Jsclientinternetbankinfo;
import com.example.jsdengluprovider.service.UserInfoService;
import com.example.jsdengluprovider.util.*;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.nimbusds.jose.JOSEException;
import org.apache.log4j.Logger;
import org.apache.shiro.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

import java.text.ParseException;
import java.util.*;

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


    public final static String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
    public final static String BANK_NUMBER_REG = "[0-9]{19}";


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

    /**
     * @param name     用户名
     * @param password 密码
     * @param request  cookie密文  判断是否需要验证手机号码
     * @param response
     * @return
     */
    @Override
    public String login(String name, String password,HttpServletRequest requests) {
        String phone = getPhone(name);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();
        response.addHeader("P3P", "CP=CAO PSA OUR");
        //取出cookie的加密密文与服务器进行对比，如果不对需要先进行设备验证,获取登录手机验证码
        Cookie[] cookies = requests.getCookies();
        System.out.println("request"  + request.getHeader("phone"));
        //if (cookies != null) {
        /*if (cookies!=null) {
            for (Cookie a : cookies) {
                if (a.getName().equals(phone)) {
                    System.out.println("a.getName()" + a.getName() + phone);
                    try {
                        System.out.println("a.getValue()" + SHAUtil.shaEncode(phone));

                        if (!a.getValue().equals(SHAUtil.shaEncode(phone))) {
                            System.out.println("12");
                            return "请先发送验证码验证";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return "请重新登陆";
                    }
                }else {
                    return "请先发送验证码验证";
                }
            }
        } else {
            System.out.println("qingfasongyanzhenga ");
            return "请先发送验证码验证";
        }*/
        Jsclientinternetbankinfo jsclientinternetbankinfo = null;

        if (name.matches(PHONE_NUMBER_REG)) {
            //手机号登录
            System.out.println("手机号登陆");
            jsclientinternetbankinfo = jsclientinternetbankinfoDao.phonelogin(name, password);
            if (jsclientinternetbankinfo != null) {
                System.out.println("手机登录成功");
                loginSuccess(phone, request, response);
                //AddLoginSuccess(response, jsclientinternetbankinfo);
                return "200";
            }
            return "403";
        } else if (name.matches(BANK_NUMBER_REG)) {
            //银行卡登录
            System.out.println("银行卡登录");
            jsclientinternetbankinfo = jsclientinternetbankinfoDao.bankNumberLogin(name, password);
            if (jsclientinternetbankinfo != null) {
                System.out.println("银行登录成功");
                loginSuccess(phone, request, response);
                //AddLoginSuccess(response, jsclientinternetbankinfo);
                return "200";
            }
            return "403";
        } else {
            //用户名登录
            System.out.println("用户名登录");
            jsclientinternetbankinfo = jsclientinternetbankinfoDao.userNameLogin(name, password);
            if (jsclientinternetbankinfo != null) {
                System.out.println("用户名登录成功");
                loginSuccess(phone, request, response);
                //AddLoginSuccess(response, jsclientinternetbankinfo);
                return "200";
            }
            return "403";
        }

    }

    @Override
    public String tokenGetIdCard(String token) throws ParseException, JOSEException {
        if (token != null) {
            Map<String, Object> validMap = TokenUtils.valid(token);
            int i = (int) validMap.get("Result");
            if (i == 0) {
                System.out.println("token解析成功");
                net.minidev.json.JSONObject jsonObject = (net.minidev.json.JSONObject) validMap.get("data");
                System.out.println("phone是" + jsonObject.get("idcard"));
                System.out.println("idcard是" + jsonObject.get("idcard"));
                System.out.println("exp是" + jsonObject.get("exp"));
                return (String) jsonObject.get("idcard");
            } else if (i == 2) {
                return "403";
            }
        }
        return "403";
    }

    /**
     * 银行卡密码验证
     */
    @Override
    public String bankPasswordverification(String IDNumber, String password, HttpServletRequest request, HttpServletResponse response) {
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
     * 忘记密码服务添加新密码
     *
     * @param onePassword
     * @param twoPassword
     * @param request
     * @return
     */
    @Override
    public String updateInternetBankPassword(String onePassword, String twoPassword, HttpServletRequest request, HttpServletResponse response) {
        if (onePassword.equals(twoPassword)) {
            Cookie[] cookies = request.getCookies();
            String phone = null;
            //验证密码格式
            if (PassWord.PassWordFormat(onePassword)) {
                //验证密码长度
                if (PassWord.PassWordLength(onePassword)) {
                    for (Cookie c : cookies) {
                        if (c.getName().equals("forgetThePasswordPhone")) {
                            //获取用户后台ID
                            phone = c.getValue();
                            break;
                        }
                    }
                    //通过手机号码查询用户后台的id
                    int clientid = jsclientinfoDao.throughPhoneNumberClientID(phone);
                    int i = jsclientinternetbankinfoDao.UpdatePassWord(clientid, onePassword);
                    if (i == 1) {
                        //清除cookie的忘记密码手机号
                        Cookie newCookie = new Cookie("forgetThePasswordPhone", null); //假如要删除名称为username的Cookie

                        newCookie.setMaxAge(0); //立即删除型

                        newCookie.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除

                        response.addCookie(newCookie); //重新写入，将覆盖之前的

                        return "操作成功，请使用新密码登录";
                    } else {
                        return "操作失败，请重新尝试";
                    }
                } else {
                    return "密码至少为8位，但不超过16位";
                }
            } else {
                return "至少包含两种以上字符";
            }
        } else {
            return "两次密码不一致";
        }
    }

    /**
     * 忘记密码身份验证
     */
    public String forgetPasswordAuthentication(String name, String IDNumber, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String ClientPhone = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("forgetThePasswordPhone")) {
                //获取用户后台ID
                ClientPhone = c.getValue();
                break;
            }
        }
        if (ClientPhone != null) {
            //查询姓名和身份证的手机号码和该用户是否匹配
            String Daophone = jsclientinfoDao.throughNameIDNumberGetPhoneNumber(name, IDNumber);
            if (Daophone.equals(ClientPhone)) {
                //验证通过
                return "200";
            }
        }
        return "500";
    }

    /**
     * 登录状态获取用户信息
     */
    @Override
    public String getLoginStateInfo(HttpServletRequest request) throws ParseException, JOSEException {
        Cookie[] cookies = request.getCookies();
        String token = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("SSOTOKENID")) {
                token = c.getValue();
            }
        }
        Map<String, Object> valid = null;
        if (token != null) {
            valid = TokenUtils.valid(token);
        }
        if (valid != null) {
            Object uid = valid.get("uid");
            //查询身份证号码
            return jsclientinternetbankinfoDao.selectIdCard(String.valueOf(uid));
        } else {
            return "请登录";
        }
    }

    /**
     * 登录成功的策略
     *
     * @return
     */
    @Override
    public String loginSuccess(String name, HttpServletRequest request, HttpServletResponse response) {
        //获取生成token

        Map<String, Object> map = new HashMap<>();
        String idcard = jsclientinternetbankinfoDao.selectIdCard(name);
        //建立载荷，这些数据根据业务，自己定义。
        map.put("phone", name);
        map.put("idcard", idcard);
        //生成时间
        map.put("sta", new Date().getTime());
        //过期时间
        map.put("exp", new Date().getTime() + 1000 * 60 * 1);
        try {
            String token = TokenUtils.creatToken(map);
            HttpSession session = request.getSession();
            //session.setAttribute("REDIS_TOKEN", token);
            System.out.println("token=" + token);
            //jedis.set(request.getSession().getId(), JSON.toJSONString(session) ,ShiroSessionRedisConstant.SHIROSESSION_REDIS_EXTIRETIME);
            //Cookie sessionId = new Cookie(ShiroSessionRedisConstant.SSOTOKEN_COOKIE_KEY, request.getSession().getId());
//            Cookie tokenCookie = new Cookie("TOKEN", token);
            try {
//                Cookie smsphone = new Cookie(name, SHAUtil.shaEncode(name));
//                smsphone.setMaxAge(1000 * 60);
//                smsphone.setPath("/");
//                tokenCookie.setPath("/");
//                tokenCookie.setMaxAge(1000*60);
                //response.addCookie(smsphone);
                //response.addCookie(tokenCookie);
                CookieUtils.writeCookie(response,"TOKEN",token);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //sessionId.setMaxAge(10000);
            //sessionId.setPath("/");
            //tokenCookie.setMaxAge(10000);
            //tokenCookie.setPath("/");
            //response.addCookie(sessionId);
            //response.addCookie(tokenCookie);
            return token;
        } catch (JOSEException e) {
            System.out.println("生成token失败");
            e.printStackTrace();
            return "生成token失败";
        }
    }

    /**
     * 显示当前银行卡号的手机号
     */
    public String bankPhoneNumber(String bankNumber) {
        String phoneNum = null;
        Jsclientbank jsclientbank = jsclientbankDao.queryById(bankNumber);
        if (jsclientbank != null) {
            Jsclientinfo jsclientinfo = jsclientinfoDao.queryById(jsclientbank.getJsClientid());
            if (jsclientinfo != null) {
                phoneNum = jsclientinfo.getJsPhonenumber();
                if (phoneNum.equals("") || phoneNum.equals(null)) {
                    return "没有该用户";
                }
            }
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
    public String verifySMSCode(String phone, String SMSCode, String operationState) throws Exception {
        operationState = operationState.equals("1") ? phone + "LOGIN_PHONE" : "2";
        String s = varParam(operationState, SMSCode);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();
        response.addHeader("P3P", "CP=CAO PSA OUR");
        //String s = "0";
        if (operationState.equals(phone + "LOGIN_PHONE")) {
            if (s.equals("0")) {
                // 541789798 为手机号加密的  加密完成存入数据库cookie密文
                //Cookie userCookie = new Cookie(phone, SHAUtil.shaEncode(phone));
                jsclientinternetbankinfoDao.updateCookieRecord(phone, SHAUtil.shaEncode(phone));
                /*userCookie.setMaxAge(7 * 24 * 60 * 60); //存活期为一个月 30*24*60*60
                userCookie.setPath("/");
                response.addCookie(userCookie);*/
                System.out.println("cookieyanzhengmima");
                CookieUtils.writeCookie(response,phone,SHAUtil.shaEncode(phone));
                return "200";
            }
        } else if (operationState.equals("2")) {
            if (s.equals("0")) {
                Cookie userCookie = new Cookie("forgetThePasswordPhone", phone);
                userCookie.setMaxAge(5 * 60); //存活期为一个月 5分钟
                userCookie.setPath("/");
                response.addCookie(userCookie);
                return "200";
            }
        }
        return "短信失败";
    }

    /**
     * 判断页面是否为第一次登录
     * 1为不是第一次登录
     * 0为第一次登录
     */
    public String isThisYourFirstLogin(String name, HttpServletRequest request) {
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
        try {
            if (name.matches(PHONE_NUMBER_REG)) {
                return name;
            } else if (name.matches(BANK_NUMBER_REG)) {
                if (bankPhoneNumber(name) != null)
                    return bankPhoneNumber(name);
            } else if (!name.matches(PHONE_NUMBER_REG) & !name.matches(BANK_NUMBER_REG)) {

                String phone = jsclientinternetbankinfoDao.getPhone(name);
                if (phone != null || phone != "") {
                    return phone;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "406";
        }
        return "406";

    }

    /**
     * 给要登陆的手机发送验证码
     */
    @Override
    public String loginSendSms(String phoneNum) {
        String str = null;
        //是电话号码
        //发送短信
        if (phoneNum != "406") {
            System.out.println(phoneNum);
            Map<String, Object> execute = IndustrySMS.execute(phoneNum, 100);
            String result = (String) execute.get("result");
            String param = (String) execute.get("param");
            JSONObject parse = JSONObject.parseObject(result);
            String respCode = parse.getString("respCode");
            result = addToRedis(respCode, phoneNum + "LOGIN_PHONE", param, result);
            str = result;
            System.out.println("str" + str);
            return str;
        }
        return "500";
    }

    /**
     * 修改密码验证码
     *
     * @param phoneNum
     * @param operationState 操作记录
     * @return
     */
    @Override
    public String updatePasswordSendSMS(String phoneNum, String operationState) {
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
                jedis.set(phoneNum, param, 5000);
                // jedis.expire(phoneNum,300);
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
    public String register(String UserName, String CertificateType, String IDNumber, String PhoneNumber) {

        return "";
    }


    /**
     * 查询用户是否存在
     */
    //public Jsclientinternetbankinfo
}
