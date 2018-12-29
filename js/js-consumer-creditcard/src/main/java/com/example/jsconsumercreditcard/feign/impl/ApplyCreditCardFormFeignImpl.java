package com.example.jsconsumercreditcard.feign.impl;

import com.example.jsconsumercreditcard.entity.CurrentAddress;
import com.example.jsconsumercreditcard.entity.Safety;
import com.example.jsconsumercreditcard.feign.ApplyCreditCardFormFeign;
import com.example.jsconsumercreditcard.util.Result;
import com.example.jsconsumercreditcard.util.ResultUtil;
import org.springframework.stereotype.Component;

@Component
public class ApplyCreditCardFormFeignImpl implements ApplyCreditCardFormFeign {
    /**
     * 全部卡类型
     *
     * @return
     */
    @Override
    public Result allCardType() {
        return ResultUtil.success("超时重试");
    }

    /**
     * 新增地址
     *
     * @param currentAddress 地址对象
     * @return
     */
    @Override
    public Result addCurrentAddress(CurrentAddress currentAddress) {
        return ResultUtil.success("超时重试");
    }

    /**
     * 新增安全问题
     *
     * @param safety
     * @return
     */
    @Override
    public Result addSafety(Safety safety) {
        return ResultUtil.success("超时重试");
    }

    /**
     * 获取全部安全问题
     *
     * @return
     */
    @Override
    public Result allSafetyProblemCon() {
        return ResultUtil.success("超时重试");
    }

    /**
     * 通过主键查询信用类型
     *
     * @param id 主键
     * @return 信用卡类型
     */
    @Override
    public Result findCurrentTypeById(Integer id) {
        return ResultUtil.success("超时重试");
    }
}
