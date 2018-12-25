package com.example.jsconsumercreditcard.feign;

import com.example.jsconsumercreditcard.entity.Auditor;
import com.example.jsconsumercreditcard.entity.CreditUserinfo;
import com.example.jsconsumercreditcard.entity.LeaveInfo;
import com.example.jsconsumercreditcard.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "JS-PRODUCER-CREDITCARD")
public interface ApplyCreditCardFeign {

    /**
     * 新增申请记录
     * @param creditUserinfo
     * @return
     */
    @PostMapping("/creditUserinfo/addCreditUserinfo")
    Result addCreditUserinfo(@RequestBody CreditUserinfo creditUserinfo);

    /**
     * 新增任务
     * @return
     */
    @PostMapping("/leaveInfo/addLeaveInfo")
    Result addLeaveInfo(@RequestBody LeaveInfo leaveInfo);

    /**
     * 获取全部审核人记录
     * @return
     */
    @RequestMapping("/getAuditorAll")
    Result getAuditorAll();


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/leaveInfo/selectOneLeaveInfo/{id}")
    Result selectOneLeaveInfo(@PathVariable("id") String id);

    /**
     * 修改LeaveInfo的state
     * @return
     * @param id LeaveInfo的ID
     * @param state LeaveInfo的state
     */
    @RequestMapping("/leaveInfo//updateLeaveInfoStateByid/{id}/{state}")
    Result updateLeaveInfoStateByid(@PathVariable("id") String id,@PathVariable("state") String state);
}
