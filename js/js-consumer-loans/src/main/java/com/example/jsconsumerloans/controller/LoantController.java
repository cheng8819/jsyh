package com.example.jsconsumerloans.controller;

import com.example.jsconsumerloans.feign.Loans;
import com.example.jsconsumerloans.pojo.LoansTransaction;
import com.example.jsconsumerloans.service.LoanApplicationService;
import com.example.jsconsumerloans.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "贷款controller", tags = {"贷款操作接口"})
@RestController
@RequestMapping("loantypes")
public class LoantController {

    @Autowired
    private Loans loans;
    @Autowired
    private LoanApplicationService loanApplicationService;

    @ApiOperation(value = "获取全部贷款类型", httpMethod = "GET")
    @RequestMapping("allloantype")
    public Result allLoantype() {
        return loans.allLoantype();
    }

    @ApiOperation(value = "获取指定用户的所有贷款", httpMethod = "GET")
    @RequestMapping("/allloanstransactionbyuid/{uid}")
    public Result allLoansTransactionByUid(@PathVariable(name = "uid") @ApiParam(name = "uid", value = "用户ID", required = true) Integer uid) {
        return loans.allLoansTransactionByUid(uid);
    }

    @ApiOperation(value = "生成订单", httpMethod = "POST")
    @RequestMapping("/addloanstransaction")
    public Result addLoanstransaction(@RequestBody @ApiParam(name = "LoansTransaction", value = "订单对象json格式", required = true) LoansTransaction loansTransaction) {
        return loanApplicationService.createOrder(loansTransaction);
    }

    @ApiOperation(value = "修改订单状态", httpMethod = "GET")
    @RequestMapping("/updateloanstransacti       ontostate/{liid}/{state}")
    public Result updateLoanstransactionTostate(@ApiParam(name = "liid", value = "订单ID", required = true) @PathVariable("liid") Integer liid, @ApiParam(name = "state", value = "订单状态（成功1失败0）", required = true) @PathVariable("state") Integer state) {
        return loans.updateLoanstransactionTostate(liid, state);
    }
}
