package com.example.jsproducercreditcard.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsproducercreditcard.entity.CreditUserinfo;
import com.example.jsproducercreditcard.service.CreditUserinfoService;
import com.example.jsproducercreditcard.util.Result;
import com.example.jsproducercreditcard.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CreditUserinfo)表控制层
 *
 * @author makejava
 * @since 2018-12-25 16:34:31
 */
@RestController
@RequestMapping("creditUserinfo")
public class CreditUserinfoController {
    /**
     * 服务对象
     */
    @Resource
    private CreditUserinfoService creditUserinfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CreditUserinfo selectOne(String id) {
        return this.creditUserinfoService.queryById(id);
    }

    /**
     * 新增申请
     *
     * @param  creditUserinfo
     * @return 单条数据
     */
    @PostMapping("/addCreditUserinfo")
    public Result addCreditUserinfo(@RequestBody CreditUserinfo creditUserinfo){
        return ResultUtil.success(JSON.toJSON(creditUserinfoService.insert(creditUserinfo)));
    }

}