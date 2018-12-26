package com.example.jscosumerfund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/26 16:23
 */
@RestController
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    @RequestMapping("test1")
    public String test(){
        return testService.test();
    }

}
