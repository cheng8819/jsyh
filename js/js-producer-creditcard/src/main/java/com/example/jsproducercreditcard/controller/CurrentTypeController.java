package com.example.jsproducercreditcard.controller;

import com.example.jsproducercreditcard.service.CurrentTypeService;
import com.example.jsproducercreditcard.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CurrentType)表控制层
 *
 * @author makejava
 * @since 2018-12-25 16:34:31
 */
@RestController
@RequestMapping("currentType")
public class CurrentTypeController {
    /**
     * 服务对象
     */
    @Resource
    private CurrentTypeService currentTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/findCurrentTypeById/{id}")
    public Result findCurrentTypeById(@PathVariable("id") Integer id) {
        return currentTypeService.queryById(id);
    }

    /**
     * 全部卡类型
     * @return
     */
    @GetMapping("/allCardType")
    public Result allCardType(){
        return currentTypeService.allCardTypes();
    }
}