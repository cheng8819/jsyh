package com.example.jsproducercreditcard.controller;

import com.example.jsproducercreditcard.entity.CreditCard;
import com.example.jsproducercreditcard.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CreditCard)表控制层
 *
 * @author makejava
 * @since 2018-12-25 16:34:29
 */
@RestController
@RequestMapping("creditCard")
public class CreditCardController {
    /**
     * 服务对象
     */
    @Resource
    private CreditCardService creditCardService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CreditCard selectOne(Integer id) {
        return this.creditCardService.queryById(id);
    }

}