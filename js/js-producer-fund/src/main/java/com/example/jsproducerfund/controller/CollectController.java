package com.example.jsproducerfund.controller;

import com.example.jsproducerfund.service.Impl.CollectServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 18:25
 */

@Api("用户收藏基金记录api")
@Controller
public class CollectController {

    @Autowired
    private CollectServiceImpl collectService;

    /**
     * 收藏基金
     * @param fund_name 基金名称
     * @param fund_number 基金代码
     * @param username 用户名/真实姓名
     * @return result
     *
     * @desc:谁点的收藏？收藏哪个基金？
     */
    @ApiOperation(value = "收藏基金产品",notes = "收藏")
    @ResponseBody
    @RequestMapping(value = "/collectFund",method = RequestMethod.GET)
    public String collectFund(String fund_name,String fund_number,String username){
        return collectService.collectFund(fund_name,fund_number,username);
    }

    @ApiOperation(value = "收藏基金产品展示",notes = "收藏基金展示")
    @ResponseBody
    @RequestMapping(value = "/showCollection",method = RequestMethod.GET)
    public String showCollection(String username){
        return collectService.selCollection(username);
    }

}
