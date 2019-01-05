package com.example.jsregisterprovider.jsproviderregister.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class test {

    @RequestMapping("/ab")
    public String ab(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("a","789789");
        System.out.println(session.getId());
        return session.getId();
    }
}
