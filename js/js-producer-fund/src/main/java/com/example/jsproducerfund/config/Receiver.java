package com.example.jsproducerfund.config;

import com.alibaba.fastjson.JSONArray;
import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.Performance;
import java.util.List;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/23 21:13
 */

@Component
public class Receiver {

    @Autowired
    private FundDao fundDao;

    @RabbitListener(queues = "hello.queue1")
    public String processMessage1(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue1队列的消息：" + msg);
        List<Performance> list = (List<Performance>) JSONArray.parseArray(msg, Performance.class);
        if(list != null || list.size() > 0){
            for (Performance p : list){
                fundDao.addPerformance(p);
            }
        }
        return msg.toUpperCase();
    }

    @RabbitListener(queues = "hello.queue2")
    public void processMessage2(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue2队列的消息：" + msg);
    }
}