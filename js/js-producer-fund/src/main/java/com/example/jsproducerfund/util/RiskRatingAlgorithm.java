package com.example.jsproducerfund.util;

import com.example.jsproducerfund.pojo.RiskAppetite;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 20:14
 */
public class RiskRatingAlgorithm {

    /*
    * A : 1   0-12
    * B : 2   13-24
    * C : 3   25-36
    * D : 4   37-48
    * E : 5   49-60
    *
    * 风险评分算法
    * 这块代码比较笨，可以用反射获取对象属性值
    * */
    public static String Algorithm(RiskAppetite risk){
        Integer total = 0;
        String[] chooses = {risk.getHousehold_income(),
                            risk.getAge_grades(),
                            risk.getInvestment_attitude(),
                            risk.getInvestment_experience(),
                            risk.getInvestment_purposes(),
                            risk.getInvestment_horizon(),
                            risk.getInvestment_proportion(),
                            risk.getIssue1(),risk.getIssue2(),risk.getIssue3(),risk.getIssue4(),risk.getIssue5()};
        for (String choose: chooses) {
            if("A".equals(choose)){
                total+=1;
            }
            if("B".equals(choose)){
                total+=2;
            }
            if("C".equals(choose)){
                total+=3;
            }
            if("D".equals(choose)){
                total+=4;
            }
            if("E".equals(choose)){
                total+=5;
            }
        }
        if(total > 0 && total <= 12){
            return RiskScore.Risk_Grade1;
        }else if(total <= 24){
            return RiskScore.Risk_Grade2;
        }else if(total <= 36){
            return RiskScore.Risk_Grade3;
        }else if(total <= 48){
            return RiskScore.Risk_Grade4;
        }else if(total <= 60){
            return RiskScore.Risk_Grade5;
        }
        return "风险评分错误";
    }

}
