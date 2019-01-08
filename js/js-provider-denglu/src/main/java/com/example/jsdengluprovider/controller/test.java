package com.example.jsdengluprovider.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.jsdengluprovider.dao.JsclientinternetbankinfoDao;
import com.example.jsdengluprovider.util.IndustrySMS;
import com.example.jsdengluprovider.util.smssss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

@SuppressWarnings("ALL")
@RestController
@CrossOrigin(origins = "*",allowCredentials="true")
public class test {
    @Autowired
    private JsclientinternetbankinfoDao jsclientinternetbankinfoDao;

    @RequestMapping("/test")
    public String a() {
        return JSON.toJSONString(jsclientinternetbankinfoDao.queryById("140423199611160010"));
    }

    @RequestMapping("/abcd")
    public String abcd(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("a", "abc123");
        String s = JSON.toJSONString(session);
        System.out.println(s);
        System.out.println(session.getId());
        Cookie[] cookies = request.getCookies();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        for (Cookie c : cookies) {
            if (c.getName().equals("1")) {
                return c.getValue();
            }
        }
        return "abcd";
    }

    @RequestMapping("/opop")
    public String opop() {
        return "asbcd";
    }


    @RequestMapping("/opops")
    public String opops(HttpServletResponse response,HttpServletRequest request) {
        Cookie cookie = new Cookie("TOKEN","a");
        response.addCookie(cookie);
        return "asbcd";
    }



    @RequestMapping("/abcde")
    public String abcde(HttpServletResponse response) {

        response.setHeader("token", "abclaskjuhijojkbhuihonbjhvyguihjbkh");
        return "abcd";
    }

    @RequestMapping("/testabc")
    public String testabc(HttpServletRequest request) {
        return request.getHeader("token");
    }

}
