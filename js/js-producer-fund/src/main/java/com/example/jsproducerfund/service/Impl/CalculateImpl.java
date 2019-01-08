package com.example.jsproducerfund.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.jsproducerfund.config.Sender;
import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.Performance;
import com.example.jsproducerfund.service.Calculate;
import com.example.jsproducerfund.util.RandomNumber;
import com.example.jsproducerfund.util.RedisUtil.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/23 18:19
 */
@Service
public class CalculateImpl implements Calculate {

    private List<Object> funds = new ArrayList<Object>();

    private Integer dayNum = 0; //基金上市天数

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private Sender sender;

    @Autowired
    private FundDao fundDao;

    /**
     * 加载基金走势数据
     */
    private void onLoad(){
        //懒加载该数据
        if(funds == null || funds.size() == 0){
            //1.先去FundInfo表查数据
            List<Performance> performances = fundDao.findPerformanceByFundInfo();
            funds.addAll(performances);
            //2.放入Redis 以后操作redis中的基金走势数据
            redisUtil.lSetList("funds",funds);
            funds.clear(); //清空数据库数据 装载redis数据
            funds.addAll(redisUtil.lGet("funds", 0, -1));
        }
    }


    @Override
    //@Scheduled(cron="0 0 11 * * ?")
    public void FundPerformance() {
        /*onLoad();
        dayNum++;
        System.out.println("基金上市第 " + dayNum + "天数据");
        //更改或添加基金数据
        if(funds != null || funds.size() != 0){
            for (Object obj : funds) {
                //模拟每日单位净值变化数据
                Performance performance = (Performance) obj;
                Double newValue = RandomNumber.getRandomNum();
                performance.setIopvs(performance.getIopv()+newValue); //更改累计净值
                performance.setIopv(newValue); //更改单位净值
                performance.setDailyIncreases(newValue-0.5); //每日涨幅
                performance.setWrite_time(String.valueOf(new Date()));
                //打印基金每天变化数据
                //System.out.println("每只基金变化: " + performance.toString());
            }
        }
        redisUtil.expire("funds",0);
        redisUtil.lSetList("funds",funds);
        //rabbitMQ
        sender.send(JSON.toJSONString(funds));*/
    }

    //@Scheduled(cron="0 0 11 * * ?")
    @Override
    public void FundPersistence() {
        /*List<Performance> data = new ArrayList<Performance>();
        List<Object> list = redisUtil.lGet("funds", 0, -1);
        Performance p = null;
        for (Object object : list){
            p = (Performance) object;
            System.out.println(p.toString());
        }*/
    }

}