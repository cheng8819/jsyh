package com.example.jsdengluprovider.util;

public class Const {

    public static final String SESSION_SECURITY_CODE = "sessionSecCode";
    public static final String SESSION_USER = "sessionUser";
    public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)).*";    //不对匹配该值的访问路径拦截（正则）
    public static final String SESSION_SECURITY_IP = "127.0.0.1";


}
