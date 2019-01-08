package com.example.jsdengluprovider.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: cookie 工具类
 */
public class CookieUtils {
    /**
     * 功能描述: 获取cookie
     */
    public static String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 功能描述:  写入cookie
     */
    public static void writeCookie(HttpServletResponse response, String cookieName, String value) {
        System.out.println("8888");
        response.addHeader("P3P", "CP=CAO PSA OUR");
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setHttpOnly(false);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
