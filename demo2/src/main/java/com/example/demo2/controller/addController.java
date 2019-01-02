package com.example.demo2.controller;


import com.example.demo2.pojo.CardNumber;
import com.example.demo2.service.bankingInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "单笔汇款")
@RestController
public class addController {
    @Autowired
    private bankingInterface add;
    @PutMapping("/add")
    public String add(@ApiParam(required = true, name = "cardNumber", value = "添加收款人信息") @RequestBody CardNumber cardNumber){
        add.addch(cardNumber);
        return "成功";
    }
    @PutMapping("/update")
    public String update(@ApiParam(required = true, name = "cardNumber", value = "添加收款人信息") @RequestBody CardNumber cardNumber){
        add.update(cardNumber);
        return "成功";
    }
    @GetMapping("/show")
    public CardNumber show(@ApiParam(required = true, name = "carenumbername", value = "添加收款人信息") @RequestParam String carenumbername, @ApiParam(required = true, name = "carenumbermark", value = "添加收款人信息") @RequestParam String carenumbermark){
        return add.show(carenumbername, carenumbermark);
    }

}
