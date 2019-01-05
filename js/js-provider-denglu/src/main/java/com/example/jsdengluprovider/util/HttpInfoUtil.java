package com.example.jsdengluprovider.util;

import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取浏览器信息
 */
public class HttpInfoUtil {

    public static String a(HttpServletRequest request){
        String agent=request.getHeader("User-Agent").toLowerCase(); //
        UserAgent userAgent = UserAgent.parseUserAgentString(agent);
        Browser browser = userAgent.getBrowser(); // 浏览器信息
        OperatingSystem os = userAgent.getOperatingSystem(); // 系统信息
        browser.getBrowserType(); //return WEB_BROWSER
        String name = browser.getName();
        System.out.println(agent);
        return "";
    }
}
