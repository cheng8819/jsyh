package com.example.jsconsumerloans.feign.impl;

import com.example.jsconsumerloans.feign.Overdue;
import com.example.jsconsumerloans.util.Result;
import com.example.jsconsumerloans.util.ResultUtil;
import org.springframework.stereotype.Component;

@Component
public class OverdueImpl implements Overdue {
    @Override
    public Result allLoansOverdueByuidAndloid(Integer uid, Integer ltid) {
        return ResultUtil.success("超时重试");
    }
}
