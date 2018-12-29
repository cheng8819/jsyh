package com.example.jsconsumercreditcard.feign.impl;

import com.example.jsconsumercreditcard.entity.CreditUserinfo;
import com.example.jsconsumercreditcard.entity.LeaveInfo;
import com.example.jsconsumercreditcard.feign.ApplyCreditCardFeign;
import com.example.jsconsumercreditcard.util.Result;
import com.example.jsconsumercreditcard.util.ResultUtil;
import org.springframework.stereotype.Component;

@Component
public class ApplyCreditCardFeignImpl implements ApplyCreditCardFeign {
    /**
     * 新增申请记录
     *
     * @param creditUserinfo
     * @return
     */
    @Override
    public Result addCreditUserinfo(CreditUserinfo creditUserinfo) {
        return ResultUtil.success("超时重试");
    }

    /**
     * 新增任务
     *
     * @param leaveInfo
     * @return
     */
    @Override
    public Result addLeaveInfo(LeaveInfo leaveInfo) {
        return ResultUtil.success("超时重试");
    }

    /**
     * 获取全部审核人记录
     *
     * @return
     */
    @Override
    public Result getAuditorAll() {
        return ResultUtil.success("超时重试");
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public Result selectOneLeaveInfo(String id) {
        return ResultUtil.success("超时重试");
    }

    /**
     * 修改LeaveInfo的state
     *
     * @param id    LeaveInfo的ID
     * @param state LeaveInfo的state
     * @return
     */
    @Override
    public Result updateLeaveInfoStateByid(String id, String state) {
        return ResultUtil.success("超时重试");
    }

    /**
     * 根据UID查询申请单记录
     *
     * @param uid
     * @return
     */
    @Override
    public Result creditUserinfoByUid(Integer uid) {
        return ResultUtil.success("超时重试");
    }

    /**
     * 根据CUID查询任务
     *
     * @param cuid
     * @return
     */
    @Override
    public Result findLeaveInfoByCuid(String cuid) {
        return ResultUtil.success("超时重试");
    }

    /**
     * 通过主键查询信用卡类型
     *
     * @param id 主键
     * @return
     */
    @Override
    public Result findCurrentTypeById(Integer id) {
        return ResultUtil.success("超时重试");
    }
}
