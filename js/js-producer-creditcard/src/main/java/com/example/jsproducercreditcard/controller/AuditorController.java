package com.example.jsproducercreditcard.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsproducercreditcard.entity.Auditor;
import com.example.jsproducercreditcard.service.AuditorService;
import com.example.jsproducercreditcard.util.Result;
import com.example.jsproducercreditcard.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Auditor)表控制层
 *
 * @author makejava
 * @since 2018-12-25 17:44:17
 */
@RestController
@RequestMapping("auditor")
public class AuditorController {
    /**
     * 服务对象
     */
    @Resource
    private AuditorService auditorService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Auditor selectOne(Integer id) {
        return this.auditorService.queryById(id);
    }

    /**
     * 获取全部审核人记录
     * @return
     */
    @RequestMapping("/getAuditorAll")
    public Result getAuditorAll(){
        return ResultUtil.success(JSON.toJSON(auditorService.getAll()));
    }
}