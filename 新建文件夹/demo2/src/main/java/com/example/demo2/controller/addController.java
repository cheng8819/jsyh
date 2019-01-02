package com.example.demo2.controller;


import com.example.demo2.pojo.CardNumber;
import com.example.demo2.service.addq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "单笔汇款")
@RestController
public class addController {
    @Autowired
    private addq add;
    @RequestMapping("/add")
    public String add(@ApiParam(required = true, name = "remittanceTransaction", value = "添加收款人信息") @RequestBody CardNumber cardNumber){
        add.addch(cardNumber);
        return "成功";
    }
    @RequestMapping("/update")
    public String update(@ApiParam(required = true, name = "remittanceTransaction", value = "添加收款人信息") @RequestBody CardNumber cardNumber){
        add.update(cardNumber);
        return "成功";
    }

}
