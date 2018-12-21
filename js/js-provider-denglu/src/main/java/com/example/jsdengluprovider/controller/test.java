package com.example.jsdengluprovider.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsdengluprovider.dao.JsclientinternetbankinfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("ALL")
@RestController
public class test {
    @Autowired
    private JsclientinternetbankinfoDao jsclientinternetbankinfoDao;
    @RequestMapping("/test")
    public String a(){
        return JSON.toJSONString(jsclientinternetbankinfoDao.queryById("140423199611160010"));
    }
}
