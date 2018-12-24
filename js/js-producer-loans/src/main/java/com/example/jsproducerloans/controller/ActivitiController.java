package com.example.jsproducerloans.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerloans.pojo.LeaveInfo;
import com.example.jsproducerloans.service.ActivitiService;
import com.example.jsproducerloans.util.Result;
import com.example.jsproducerloans.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activiticontroller")
public class ActivitiController {

    @Autowired
    private ActivitiService activitiService;

    //获取全部审核人
    @RequestMapping("/getauditorsall")
    public Result getAuditorsAll(){
        return ResultUtil.success(JSON.toJSONString(activitiService.getAuditorsAll()));
    }

    //根据申请单id查询申请单
    @RequestMapping("/findleaveinfobyid/{id}")
    Result findLeaveInfoById(@PathVariable("id") String id){
        return ResultUtil.success(JSON.toJSONString(activitiService.findLeaveInfoById(id)));
    }

    //修改申请单状态
    @PostMapping("/updateleaveinfostate")
    Result updateLeaveInfoState(@RequestBody LeaveInfo leaveInfo){
        return ResultUtil.success(activitiService.updateLeaveInfoState(leaveInfo));
    }
}
