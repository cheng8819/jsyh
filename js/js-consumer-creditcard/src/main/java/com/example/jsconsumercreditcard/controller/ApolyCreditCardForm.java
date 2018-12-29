package com.example.jsconsumercreditcard.controller;

import com.alibaba.fastjson.JSON;
import com.example.jsconsumercreditcard.entity.CurrentAddress;
import com.example.jsconsumercreditcard.entity.CurrentType;
import com.example.jsconsumercreditcard.entity.Safety;
import com.example.jsconsumercreditcard.feign.ApplyCreditCardFormFeign;
import com.example.jsconsumercreditcard.util.Result;
import com.example.jsconsumercreditcard.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "信用卡申请表单controller", tags = {"信用卡申请表单操作接口"})
@RequestMapping("/ApolyCreditCardForm")
public class ApolyCreditCardForm {

    @Autowired
    private ApplyCreditCardFormFeign applyCreditCardFormFeign;

    /**
     * 全部卡类型
     * @return
     */
    @GetMapping("/allCardType")
    @ApiOperation(value = "获取全部信用卡类型", httpMethod = "GET")
    public Result allCardType(){
        Result result = applyCreditCardFormFeign.allCardType();
        List<CurrentType> currentTypes = JSON.parseArray((String)result.getData(),CurrentType.class);
        return ResultUtil.success(currentTypes);
    }

    /**
     * 新增地址
     * @param currentAddress 地址对象
     * @return
     */
    @PostMapping("/addCurrentAddress")
    @ApiOperation(value = "新增地址", httpMethod = "POST")
    public Result addCurrentAddress(@ApiParam(name = "currentAddress", value = "新增地址对象json格式", required = true) @RequestBody CurrentAddress currentAddress){
        return ResultUtil.success(applyCreditCardFormFeign.addCurrentAddress(currentAddress));
    }

    /**
     * 新增安全问题
     * @param safety
     * @return
     */
    @PostMapping("/addSafety")
    @ApiOperation(value = "新增安全问题", httpMethod = "POST")
    public Result addSafety(@ApiParam(name = "safety", value = "新增安全问题对象json格式", required = true) @RequestBody Safety safety){
        return applyCreditCardFormFeign.addSafety(safety);
    }

    /**
     * 获取全部安全问题
     * @return
     */
    @GetMapping("/allSafetyProblemCon")
    @ApiOperation(value = "全部安全问题", httpMethod = "GET")
    public Result allSafetyProblemCon(){
        return applyCreditCardFormFeign.allSafetyProblemCon();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/findCurrentTypeById/{id}")
    @ApiOperation(value = "根据卡类型ID查询", httpMethod = "GET")
    public Result findCurrentTypeById(@ApiParam(name = "id", value = "卡类型ID", required = true) @PathVariable("id") Integer id) {
        Result result = applyCreditCardFormFeign.findCurrentTypeById(id);
        return ResultUtil.success(JSON.parseObject((String)result.getData(),CurrentType.class));
    }
}
