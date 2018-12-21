package com.example.jsdengluprovider.util;

public class PassWord {
    //两个以上字符类型
    private static final String a =  "^(?![A-Z]+$)(?![a-z]+$)(?!\\d+$)(?![\\W_]+$)\\S+$";
    //长度判断
    private static final String b =  "^[a-zA-Z0-9]{6,16}$";
    /**
     * 密码格式认证
     */
    public static boolean PassWordFormat(String passWord){
        return passWord.matches(a);
    }
    /**
     * 密码长度认证
     */
    public static boolean PassWordLength(String passWord){
        return passWord.matches(b);
    }
}
