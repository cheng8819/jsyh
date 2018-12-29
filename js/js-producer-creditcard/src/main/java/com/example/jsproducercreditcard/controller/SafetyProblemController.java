package com.example.jsproducercreditcard.controller;

import com.example.jsproducercreditcard.entity.SafetyProblem;
import com.example.jsproducercreditcard.service.SafetyProblemService;
import com.example.jsproducercreditcard.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SafetyProblem)表控制层
 *
 * @author makejava
 * @since 2018-12-25 16:34:31
 */
@RestController
@RequestMapping("safetyProblem")
public class SafetyProblemController {
    /**
     * 服务对象
     */
    @Resource
    private SafetyProblemService safetyProblemService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SafetyProblem selectOne(Integer id) {
        return this.safetyProblemService.queryById(id);
    }

    /**
     * 获取全部安全问题
     * @return
     */
    @GetMapping("/allSafetyProblemCon")
    public Result allSafetyProblemCon(){
        return safetyProblemService.allSafetyProblem();
    }
}