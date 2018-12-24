package com.example.jsproducerfund.util;

import java.text.DecimalFormat;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/23 18:50
 */
public class RandomNumber {

    private static DecimalFormat dcmFmt = new DecimalFormat("#.00");

    /**
     * 获得随机正负小数
     * @return
     */
    public static Double getRandomNum(){
        Double randomNum = Math.random()*10-5;
        //格式化数字
        String num = dcmFmt.format(randomNum);
        return Double.valueOf(num);
    }

}
