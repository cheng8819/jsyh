package com.example.jsproducerfund.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.*;
import com.example.jsproducerfund.service.FundService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 15:06
 */
@Service
public class FundServiceImpl implements FundService {

    @Autowired
    private FundDao fundDao;

    private Integer pageNum = 1;

    @Override
    public String showNewFunds() {
        List<FundInfo> list = fundDao.findNewFunds();
        //分页查询 每页显示10行数据
        PageHelper.startPage(pageNum, 10);
        PageInfo<FundInfo> fundPageInfo = new PageInfo<>(list);
        return JSON.toJSONString(fundPageInfo.getList());
    }

    @Override
    public String showOldFunds(String fundType) {
        Performance performance = new Performance();
        performance.setFund_type(fundType);
        List<FundInfo> list = fundDao.findOldFunds(fundType);
        //分页查询 每页显示10行数据
        PageHelper.startPage(pageNum,5);
        PageInfo<FundInfo> fundPageInfo = new PageInfo<FundInfo>(list);
        return JSON.toJSONString(fundPageInfo.getList());
    }

    @Override
    public String showAllFunds(FundInfo fundInfo) {
        List<FundInfo> fundInfos = fundDao.findAll(fundInfo);
        if(fundInfos.size() <= 0){
            return "未查询到任何信息";
        }
        return JSON.toJSONString(fundInfos);
    }

    @Override
    public String showFundDetails(String fundNumber) {
        if(fundNumber == null || "".equals(fundNumber)){
            return "基金代码不允许为空";
        }
        FundInfo fundInfo = fundDao.showFundDetails(fundNumber);
        if(fundInfo == null || fundInfo.getFund_manager() == null){
            return "未查找到任何信息";
        }
        fundInfo.setFundManager(fundDao.selFundManager(fundInfo.getFund_manager()));
        return JSON.toJSONString(fundInfo);
    }

    @Override
    public String showFundPerformance(String fundNumber) {
        List<Performance> performances = fundDao.selPerformance(fundNumber);
        if(performances.size() <= 0){
            return "未查找到任何信息";
        }
        return JSON.toJSONString(performances);
    }

    @Override
    public String addFundPerformance(Performance performance) {
        Integer result = fundDao.addPerformance(performance);
        if (result <= 0){
            return "添加失败";
        }
        return "添加成功";
    }
}
