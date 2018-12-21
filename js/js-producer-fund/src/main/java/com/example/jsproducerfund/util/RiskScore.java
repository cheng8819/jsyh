package com.example.jsproducerfund.util;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 20:08
 *
 * 风险等级枚举类
 */
public class RiskScore {

    /*
    *
    * 风险等级
　　* 风险得分>5 高风险 股票型基金
　　* 风险得分≥4.5 较高风险 股票型基金、混合型基金
　　* 风险得分3.5--4.4 中风险 混合型基金、债券型基金
　　* 风险得分2.5--3.4 较低风险 混合型基金、债券型基金
　　* 风险得分＜2.5 低风险 中短债基金或货币市场型基金。
    *
    * */

    public static final String Risk_Grade1 = "谨慎型产品(R1)";
    public static final String Risk_Grade2 = "稳健型产品(R2)";
    public static final String Risk_Grade3 = "平衡型产品(R3)";
    public static final String Risk_Grade4 = "进取型产品(R4)";
    public static final String Risk_Grade5 = "激进型产品(R5)";

}
