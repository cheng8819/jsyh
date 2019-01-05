package com.example.jsdengluprovider.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 验证码通知短信接口
 *
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 */
public class IndustrySMS {
    private static String operation = "/industrySMS/sendSMS";

    private static String accountSid = Config.ACCOUNT_SID;
    private static String tologin = "806491708";//登录
    private static String updatepassword = "806491708";//修改密码
    //private static String smsContent = "【秒嘀科技】您的验证码是345678，30分钟输入有效。";
    private static String param =  new Random().nextInt(1000000)+"";

    /**
     * 验证码通知短信
     * 100 登录
     * 101 修改密码
     */
    public static Map<String, Object> execute(String to, Integer state){
        Map<String, Object> map = new HashMap<>();
        String tmpSmsContent = null;
        String url = Config.BASE_URL + operation;
        String body = null;
        try {
            if (100 == state) {
                tmpSmsContent = URLEncoder.encode(tologin, "UTF-8");
                body = "accountSid=" + accountSid + "&to=" + to + "&templateid="+ tologin+HttpUtil.createCommonParam() +
                        "&param="+param ;

            } else if (101 == state) {
                tmpSmsContent = URLEncoder.encode(updatepassword, "UTF-8");
                body = "accountSid=" + accountSid + "&to=" + to + "&templateid=" + updatepassword + HttpUtil.createCommonParam() +
                        "&param=" + param;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // 提交请求
        String result = HttpUtil.post(url, body);
        System.out.println("result:" + System.lineSeparator() + result);
        //System.out.println("result:" + System.lineSeparator() + result);
        map.put("result", result);
        map.put("param", param);
        return map;
    }
}
