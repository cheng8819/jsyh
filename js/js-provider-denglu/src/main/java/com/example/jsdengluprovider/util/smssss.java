package com.example.jsdengluprovider.util;

import java.net.URLEncoder;

public class smssss {
    /**
     * 验证码通知短信接口
     *
     * @ClassName: IndustrySMS
     * @Description: 验证码通知短信接口
     *
     */
        private static String operation = "/industrySMS/sendSMS";

        private static String accountSid = Config.ACCOUNT_SID;
        private static String to = "17603452718";
        private static String smsContent = "【晋商银行】尊敬的用户您正在登录操作，若非本人操作谨防诈骗短信，您的验证码为{1}";

        /**
         * 验证码通知短信
         */
        public static void execute()
        {
            String tmpSmsContent = null;
            try{
                tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
            }catch(Exception e){

            }
            String url = Config.BASE_URL + operation;
            String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
                    + HttpUtil.createCommonParam();

            // 提交请求
            String result = HttpUtil.post(url, body);
            System.out.println("result:" + System.lineSeparator() + result);
        }

}
