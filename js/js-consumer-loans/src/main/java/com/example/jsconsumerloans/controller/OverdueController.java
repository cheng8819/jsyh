package com.example.jsconsumerloans.controller;

import com.example.jsconsumerloans.feign.Overdue;
import com.example.jsconsumerloans.service.RepaymentService;
import com.example.jsconsumerloans.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "还款controller", tags = {"还款操作接口"})
@RestController
@RequestMapping("/overduecontroller")
public class OverdueController {

    @Resource
    private Overdue overdue;
    @Autowired
    private RepaymentService repaymentService;

    @ApiOperation(value = "根据uid和loid查询逾期订单", httpMethod = "GET")
    @RequestMapping("/allloansoverduebyuidandloid/{uid}/{ltid}")
    public Result allLoansOverdueByuidAndloid(@ApiParam(name = "uid", value = "用户ID", required = true) @PathVariable("uid") Integer uid, @ApiParam(name = "ltid", value = "订单ID", required = true) @PathVariable("ltid") Integer ltid) {
        return overdue.allLoansOverdueByuidAndloid(uid, ltid);
    }

    @ApiOperation(value = "指定用户ID所有的住房贷款", httpMethod = "GET")
    @RequestMapping("/loandetailsbyuidcon/{uid}")
    public Result loanDetailsByuidCon(@ApiParam(name = "uid", value = "用户ID", required = true) @PathVariable("uid") Integer uid){
        return overdue.loanDetailsByuidCon(uid);
    }

    @ApiOperation(value = "指定订单的还款", httpMethod = "GET")
    @RequestMapping("/repaymenting/{liid}")
    public Result repaymenting(@ApiParam(name = "uid", value = "用户ID", required = true) @PathVariable("uid") Integer uid,
            @ApiParam(name = "liid", value = "订单ID", required = true) @PathVariable("liid") Integer liid){
        return repaymentService.repaymentById(uid,liid);
    }
}
