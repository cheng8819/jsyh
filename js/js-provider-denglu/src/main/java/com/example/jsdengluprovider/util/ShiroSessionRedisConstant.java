package com.example.jsdengluprovider.util;

public class ShiroSessionRedisConstant {

    /**
     * shirosession存储到redis中key的前缀
     */
    public static final String SHIROSESSION_REDIS_PREFIX = "SHIROSESSION_";
    /**
     * shirosession存储到redis哪个库中
     */
    public static final int SHIROSESSION_REDIS_DB = 0;
    /**
     * shirosession存储到redis中的过期时间
     */
    public static final int SHIROSESSION_REDIS_EXTIRETIME = 1000;

    /**
     * token存到cookie中的key
     */
    public static final String SSOTOKEN_COOKIE_KEY = "SESSIONID";
    /**
     * token存到redis中的key前缀
     */
    public static final String SSOTOKEN_REDIS_PREFIX = "REDIS_TOKEN";

}