package com.example.jsproducerloans.controller;

import com.example.jsproducerloans.pojo.LoansTransaction;
import com.example.jsproducerloans.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @Autowired
    private Test test;

    @RequestMapping
    public LoansTransaction hehe(){
        return test.hehe();
    }
}
