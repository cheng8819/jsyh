package com.example.jsproducercreditcard.controller;

import com.example.jsproducercreditcard.entity.Safety;
import com.example.jsproducercreditcard.service.SafetyService;
import com.example.jsproducercreditcard.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Safety)表控制层
 *
 * @author makejava
 * @since 2018-12-25 16:34:31
 */
@RestController
@RequestMapping("safety")
public class SafetyController {
    /**
     * 服务对象
     */
    @Resource
    private SafetyService safetyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Safety selectOne(Integer id) {
        return this.safetyService.queryById(id);
    }

    /**
     * 新增安全问题
     * @param safety
     * @return
     */
    @PostMapping("/addSafety")
    public Result addSafety(@RequestBody Safety safety){
        return safetyService.insert(safety);
    }
}