package com.example.jsconsumerloans.feign.impl;

import com.example.jsconsumerloans.feign.ActivitiFeign;
import com.example.jsconsumerloans.pojo.LeaveInfo;
import com.example.jsconsumerloans.util.Result;
import com.example.jsconsumerloans.util.ResultUtil;
import org.springframework.stereotype.Component;

@Component
public class ActivitiFeignImpl implements ActivitiFeign {
    @Override
    public Result getAuditorsAll() {
        return ResultUtil.success("超时重试");
    }

    @Override
    public Result findLeaveInfoById(String id) {
        return ResultUtil.success("超时重试");
    }

    @Override
    public Result updateLeaveInfoState(LeaveInfo leaveInfo) {
        return ResultUtil.success("超时重试");
    }
}
