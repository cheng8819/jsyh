package com.example.jsproducercreditcard.controller;

import com.example.jsproducercreditcard.entity.CurrentAddress;
import com.example.jsproducercreditcard.service.CurrentAddressService;
import com.example.jsproducercreditcard.util.Result;
import com.example.jsproducercreditcard.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CurrentAddress)表控制层
 *
 * @author makejava
 * @since 2018-12-25 16:34:31
 */
@RestController
@RequestMapping("currentAddress")
public class CurrentAddressController {
    /**
     * 服务对象
     */
    @Resource
    private CurrentAddressService currentAddressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CurrentAddress selectOne(Integer id) {
        return this.currentAddressService.queryById(id);
    }

    /**
     * 新增地址
     * @param currentAddress 地址对象
     * @return
     */
    @PostMapping("/addCurrentAddress")
    public Result addCurrentAddress(@RequestBody CurrentAddress currentAddress){
        return ResultUtil.success(currentAddressService.insert(currentAddress));
    }
}