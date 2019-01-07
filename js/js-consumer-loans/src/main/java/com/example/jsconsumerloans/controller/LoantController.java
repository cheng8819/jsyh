package com.example.jsconsumerloans.controller;

import com.example.jsconsumerloans.feign.Loans;
import com.example.jsconsumerloans.pojo.LoansTransaction;
import com.example.jsconsumerloans.service.LoanApplicationService;
import com.example.jsconsumerloans.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Api(value = "贷款controller", tags = {"贷款操作接口"})
@RestController
@RequestMapping("loantypes")
public class LoantController {

    @Resource
    private Loans loans;
    @Autowired
    private LoanApplicationService loanApplicationService;

    @ApiOperation(value = "获取全部贷款类型", httpMethod = "GET")
    @RequestMapping("allloantype")
    public Result allLoantype(HttpServletRequest httpServletRequest) {
        System.out.println("----------------------------------");
        for (int i = 0; i < httpServletRequest.getCookies().length; i++) {
            System.out.println(httpServletRequest.getCookies()[i].getName());
        }
        System.out.println("----------------------------------");
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
    @RequestMapping("/updateloanstransactiontostate/{liid}/{state}")
    public Result updateLoanstransactionTostate(@ApiParam(name = "liid", value = "订单ID", required = true) @PathVariable("liid") Integer liid, @ApiParam(name = "state", value = "订单状态（成功1失败0）", required = true) @PathVariable("state") Integer state) {
        return loans.updateLoanstransactionTostate(liid, state);
    }

    @ApiOperation(value = "全部住房贷款种类", httpMethod = "GET")
    @GetMapping("/slectAllLoansType")
    public Result slectAllLoansType(){
        return loans.slectAllLoansType();
    }

    @ApiOperation(value = "全部学历", httpMethod = "GET")
    @GetMapping("/selectAllEducation")
    public Result selectAllEducation(){
        return loans.selectAllEducation();
    }

    @ApiOperation(value = "全部职业", httpMethod = "GET")
    @GetMapping("/selectAllJobs")
    public Result selectAllJobs(){
        return loans.selectAllJobs();
    }
}
