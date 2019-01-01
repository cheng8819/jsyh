package com.example.jsproducerfund.controller;

import com.example.jsproducerfund.util.SMS.IndustrySMS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 23:35
 */

@Api("短信操作api")
@Controller
public class SMSController {

    @ApiOperation(value = "发送验证码，返回随机验证码",notes = "发送验证码")
    @ResponseBody
    @RequestMapping(value = "/sendSMS",method = RequestMethod.GET)
    public String sendSMS(String phone){
        int code = IndustrySMS.execute(phone);
        //返回随机生成的验证码与用户输入的数据进行比对
        return String.valueOf(code);
    }

}
