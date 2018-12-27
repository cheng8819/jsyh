package com.example.jsconsumercreditcard.feign;

import com.example.jsconsumercreditcard.entity.CreditUserinfo;
import com.example.jsconsumercreditcard.entity.LeaveInfo;
import com.example.jsconsumercreditcard.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


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
    @RequestMapping("/auditor/getAuditorAll")
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
    @RequestMapping("/leaveInfo/updateLeaveInfoStateByid/{id}/{state}")
    Result updateLeaveInfoStateByid(@PathVariable("id") String id,@PathVariable("state") String state);

    /**
     * 根据UID查询申请单记录
     * @param uid
     * @return
     */
    @GetMapping("/creditUserinfo/creditUserinfoByUid/{uid}")
    Result creditUserinfoByUid(@PathVariable("uid") Integer uid);


    /**
     * 根据CUID查询任务
     * @param cuid
     * @return
     */
    @GetMapping("leaveInfo/findLeaveInfoByCuid/{cuid}")
    Result findLeaveInfoByCuid(@PathVariable("cuid") String cuid);

    /**
     * 通过主键查询信用卡类型
     *
     * @param id 主键
     * @return
     */
    @GetMapping("currentType/findCurrentTypeById/{id}")
    Result findCurrentTypeById(@PathVariable("id") Integer id);
}
