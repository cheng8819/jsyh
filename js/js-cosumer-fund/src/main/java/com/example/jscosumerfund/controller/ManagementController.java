package com.example.jscosumerfund.controller;

import com.example.jscosumerfund.service.ManagementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/7 21:53
 */
@RestController
public class ManagementController {

    @Autowired
    private ManagementService managementService;

    /**
     * 查银行卡号：
     *
     * @param idnumber 身份证号
     * @return 银行卡号/查不到
     */
    @ApiOperation(value = "查询银行卡号",notes = "身份证号")
    @RequestMapping(value ="/idnumberSelectCardnumber")
    public String idnumberSelectCardnumber(@RequestParam("idnumber") String idnumber){
        return managementService.idnumberSelectCardnumber(idnumber);
    }

    /**
     * 查余额：
     *
     * @param cardnumber 银行卡号
     * @return 余额
     */
    @ApiOperation(value = "查余额",notes = "银行卡号")
    @RequestMapping(value ="/selectBalance")
    public Double selectBalance(@RequestParam("cardnumber") String cardnumber){
        return managementService.selectBalance(cardnumber);
    }

    /**
     * 加余额：
     *
     * @param cardnumber 银行卡号
     * @param core        交易金额
     * @param type        交易类型
     * @return
     */
    @ApiOperation(value = "加余额",notes = "银行卡号")
    @RequestMapping(value ="/deposit" )
    boolean deposit(@RequestParam("cardnumber") String cardnumber,@RequestParam("core") Double core,@RequestParam("type") String type){
        return managementService.deposit(cardnumber,core,type);
    }

    /**
     * 减余额：
     *
     * @param cardnumber 银行卡号
     * @param core        交易金额
     * @param type        交易类型
     * @return
     */
    @ApiOperation(value = "减余额",notes = "银行卡号")
    @RequestMapping(value ="/remittance")
    public boolean remittance(@RequestParam("cardnumber") String cardnumber,@RequestParam("core") Double core,@RequestParam("type") String type){
        return managementService.remittance(cardnumber,core,type);
    }

    /**
     * 查银行卡状态：
     *
     * @param cardnumber 银行卡号
     * @return “正常”、“挂失”、“冻结”
     */
    @ApiOperation(value = "查银行卡状态",notes = "银行卡号")
    @RequestMapping(value ="/cardnumberSelectState")
    public String cardnumberSelectState(@RequestParam("cardnumber") String cardnumber){
        return managementService.cardnumberSelectState(cardnumber);
    }

}
