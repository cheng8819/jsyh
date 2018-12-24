package com.mxh.test.service.Impl;

import com.mxh.test.config.Sender;
import com.mxh.test.pojo.Fund;
import com.mxh.test.service.Calculate;
import com.mxh.test.util.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/23 18:19
 */
@Service
public class CalculateImpl implements Calculate {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Integer num = 0;

    private static List<Fund> list; //基金数据集合

    private static Integer dayNum = 0; //基金上市天数

    @Autowired
    private Sender sender;

    {
        Fund DaTong = new Fund("大同煤业","0001",0.00,0.00);
        Fund JinMei = new Fund("晋煤集团","0002",0.00,0.00);
        Fund ShiShan = new Fund("史山煤业","0003",0.00,0.00);
        Fund ChangZhi = new Fund("长治煤业","0004",0.00,0.00);
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
        //模拟每日单位净值变化数据
        Double DaTong = RandomNumber.getRandomNum();
        Double JinMei = RandomNumber.getRandomNum();
        Double ShiShan = RandomNumber.getRandomNum();
        Double ChangZhi = RandomNumber.getRandomNum();

        //更改或添加基金数据
        for (Fund fund: list) {
            if("大同煤业".equals(fund.getFund_name())){
                fund.setIopys(fund.getIopy()+DaTong); //更改累计净值
                fund.setIopy(DaTong); //更改单位净值
            }
            if("晋煤集团".equals(fund.getFund_name())){
                fund.setIopys(fund.getIopy()+JinMei);
                fund.setIopy(JinMei);
            }
            if("史山煤业".equals(fund.getFund_name())){
                fund.setIopys(fund.getIopy()+ShiShan);
                fund.setIopy(ShiShan);
            }
            if("长治煤业".equals(fund.getFund_name())){
                fund.setIopys(fund.getIopy()+ChangZhi);
                fund.setIopy(ChangZhi);
            }
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
