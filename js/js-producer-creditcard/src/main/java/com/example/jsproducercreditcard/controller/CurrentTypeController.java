package com.example.jsproducercreditcard.controller;

import com.example.jsproducercreditcard.entity.CurrentType;
import com.example.jsproducercreditcard.service.CurrentTypeService;
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
    @GetMapping("selectOne")
    public CurrentType selectOne(Integer id) {
        return this.currentTypeService.queryById(id);
    }

}