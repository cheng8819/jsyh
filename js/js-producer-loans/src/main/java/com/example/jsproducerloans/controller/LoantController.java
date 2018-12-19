package com.example.jsproducerloans.controller;

import com.example.jsproducerloans.pojo.LoansTransaction;
import com.example.jsproducerloans.service.Pledge;
import com.example.jsproducerloans.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value="贷款controller",tags={"贷款操作接口"})
@RestController
@RequestMapping("loantypes")
public class LoantController {

    @Autowired
    private Pledge pledge;

    @ApiOperation(value="获取全部贷款类型",httpMethod = "GET")
    @RequestMapping("allloantype")
    public Result allLoantype(){
        return pledge.allLoantype();
    }

    @ApiOperation(value="获取指定用户的所有贷款",httpMethod = "GET")
    @RequestMapping("/allloanstransactionbyuid/{uid}")
    public Result allLoansTransactionByUid(@PathVariable(name = "uid") @ApiParam(name="uid",value="用户ID",required=true)  Integer uid){
        return pledge.allLoansTransactionByUid(uid);
    }

    @ApiOperation(value="生成订单",httpMethod = "POST")
    @RequestMapping("/addloanstransaction")
    public Result addLoanstransaction(@RequestBody @ApiParam(name="LoansTransaction",value="订单对象json格式",required=true)LoansTransaction loansTransaction){
        return pledge.addLoansTransaction(loansTransaction);
    }

    @ApiOperation(value="修改订单状态",httpMethod = "GET")
    @RequestMapping("/updateloanstransactiontostate/{liid}/{state}")
    public Result updateLoanstransactionTostate(@ApiParam(name="liid",value="订单ID",required=true) @PathVariable("liid") Integer liid, @ApiParam(name="state",value="订单状态（成功1失败0）",required=true) @PathVariable("state") Integer state){
        return pledge.updateLoansTransactionToState(liid,state);
    }
}
