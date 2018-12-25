package com.example.jsproducercreditcard.controller;

import com.example.jsproducercreditcard.entity.HousingSituation;
import com.example.jsproducercreditcard.service.HousingSituationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (HousingSituation)表控制层
 *
 * @author makejava
 * @since 2018-12-25 16:34:31
 */
@RestController
@RequestMapping("housingSituation")
public class HousingSituationController {
    /**
     * 服务对象
     */
    @Resource
    private HousingSituationService housingSituationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HousingSituation selectOne(Integer id) {
        return this.housingSituationService.queryById(id);
    }

}