package com.example.jsproducerfund.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerfund.dao.CollectDao;
import com.example.jsproducerfund.pojo.CollectInfo;
import com.example.jsproducerfund.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 16:38
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao collectDao;

    public String collectFund(String fund_name,String fund_number, String username) {
        CollectInfo collectInfo = new CollectInfo();
        collectInfo.setFund_name(fund_name);
        collectInfo.setFund_number(fund_number);
        collectInfo.setUsername(username);
        //先查询该基金是否已经收藏过
        List<CollectInfo> collections = collectDao.selCollection(collectInfo);
        if(collections.size() > 0){
            return "已收藏";
        }
        //没收藏过就添加收藏信息
        Integer result = collectDao.addCollection(collectInfo);
        if(result <= 0){
            return "收藏失败";
        }
        return "收藏成功";
    }

    public String selCollection(String username) {
        System.out.println("mxh "+username);
        if(username == null){
            return "用户名不允许为空";
        }
        CollectInfo collectInfo = new CollectInfo();
        collectInfo.setUsername(username);
        List<CollectInfo> collectInfos = collectDao.selCollection(collectInfo);
        return JSON.toJSONString(collectInfos);
    }

}
