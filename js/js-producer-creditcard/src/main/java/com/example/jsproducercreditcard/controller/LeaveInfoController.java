package com.example.jsproducercreditcard.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsproducercreditcard.entity.LeaveInfo;
import com.example.jsproducercreditcard.service.LeaveInfoService;
import com.example.jsproducercreditcard.util.Result;
import com.example.jsproducercreditcard.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (LeaveInfo)表控制层
 *
 * @author makejava
 * @since 2018-12-25 16:36:53
 */
@RestController
@RequestMapping("leaveInfo")
public class LeaveInfoController {
    /**
     * 服务对象
     */
    @Resource
    private LeaveInfoService leaveInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneLeaveInfo/{id}")
    public Result selectOneLeaveInfo(@PathVariable("id") String id){
        return ResultUtil.success(JSON.toJSONString(leaveInfoService.queryById(id)));
    }

    /**
     * 新增
     * @param leaveInfo
     * @return
     */
    @PostMapping("/addLeaveInfo")
    public Result addLeaveInfo(@RequestBody LeaveInfo leaveInfo){
        return ResultUtil.success(leaveInfoService.insert(leaveInfo));
    }

    /**
     * 修改LeaveInfo的state
     * @return
     * @param id LeaveInfo的ID
     * @param state LeaveInfo的state
     */
    @RequestMapping("/updateLeaveInfoStateByid/{id}/{state}")
    public Result updateLeaveInfoStateByid(@PathVariable("id") String id,@PathVariable("state") String state){
        LeaveInfo leaveInfo = leaveInfoService.queryById(id);
        if(leaveInfo != null){
            leaveInfo.setStatus(state);
            if(leaveInfoService.update(leaveInfo) != null){
                return ResultUtil.success("修改成功");
            }else{
                return ResultUtil.success("修改失败");
            }
        }else{
            return ResultUtil.success("id有误");
        }
    }
}