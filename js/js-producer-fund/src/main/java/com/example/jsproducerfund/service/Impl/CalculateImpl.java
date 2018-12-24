package com.example.jsproducerfund.service.Impl;

import com.example.jsproducerfund.config.Sender;
import com.example.jsproducerfund.pojo.Performance;
import com.example.jsproducerfund.service.Calculate;
import com.example.jsproducerfund.util.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/23 18:19
 */
@Service
public class CalculateImpl implements Calculate {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Integer num = 0;

    private static List<Performance> list; //基金数据集合

    private static Integer dayNum = 0; //基金上市天数

    @Autowired
    private Sender sender;

    {
        Performance DaTong = new Performance(0001,"大同煤业",0.00,0.00);
        Performance JinMei = new Performance(0002,"晋煤集团",0.00,0.00);
        Performance ShiShan = new Performance(0003,"史山煤业",0.00,0.00);
        Performance ChangZhi = new Performance(0004,"长治煤业",0.00,0.00);
        list = new ArrayList<>();
        list.add(DaTong);
        list.add(JinMei);
        list.add(ShiShan);
        list.add(ChangZhi);
    }

    @Override
    @Scheduled(cron="0/4 * * * * ?")
    public void CalculateCount() {
        /*Integer num1 = (int)(1+Math.random()*(10-1+1));
        System.out.println("原来的数：" + num);
        num = num + num1;
        System.out.println("随机数：" + num1 + " 计算后的数：" + num);*/
    }

    @Override
    @Scheduled(cron="0/10 * * * * ?")
    public void FundPerformance() {
        System.out.println("\n\n");
        dayNum++;
        System.out.println("基金上市第 " + dayNum + "天数据");

        //更改或添加基金数据
        for (Performance performance: list) {
            //模拟每日单位净值变化数据
            Double newValue = RandomNumber.getRandomNum();
            performance.setIopys(performance.getIopy()+newValue); //更改累计净值
            performance.setIopy(newValue); //更改单位净值

            //打印基金每天变化数据
            //System.out.println(fund.toString());
        }
        sender.send(list.toString());
        System.out.println("\n\n");
    }

    @Override
    public void automaticInvestmentPlan() {
        //购买日期 购买期限 购买品种 分红方式

    }
}
