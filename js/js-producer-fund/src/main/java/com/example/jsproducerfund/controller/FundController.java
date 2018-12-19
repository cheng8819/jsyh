package com.example.jsproducerfund.controller;

import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.FundInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 11:49
 */
@RestController
public class FundController {

    @Autowired
    private FundDao fundDao;

    @RequestMapping("show.html")
    public List<FundInfo> show(){
        return fundDao.findAll();
    }

}
