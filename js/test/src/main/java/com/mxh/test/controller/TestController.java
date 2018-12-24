package com.mxh.test.controller;

import com.mxh.test.util.RedisUtil.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/23 23:42
 */
@RestController
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/test")
    public void test(){
        boolean flag = redisUtil.set("mxh","123456");
        System.out.println(redisUtil.get("mxh"));

        List<Object> list = new ArrayList<Object>();
        list.add("马鑫海");
        list.add(22);
        list.add("男");
        list.add("北留中学");
        list.add(165.6);
        redisUtil.lSetList("list",list);

        List<Object> list1 = redisUtil.lGet("list",0,-1);
        for (Object obj : list1) {
            System.out.println(obj);
        }

        Map<String,Object> map = new HashMap<>();
        map.put("001","0001");
        map.put("002",0001);
        map.put("003",123.4);
        map.put("004","123456");
        redisUtil.hmset("info",map);
        Map<Object,Object> maps = redisUtil.hmget("info");
        Set<Map.Entry<Object, Object>> entries = maps.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getKey() + "==" + iterator.next().getValue());
        }
    }

    @RequestMapping("/test1")
    public void test1(HttpServletRequest request){
        //申购
        /**
         * 净申购金额＝申购金额÷（1＋申购费率）＝10000.00÷（1＋1.5％）≈9852.22(元)
         * 申购费用＝申购金额－净申购金额＝10000.00－9852.22＝147.78(元)
         * 申购份额＝净申购金额÷T日基金份额净值＝9852.22÷1.2000≈8210.18(份)
         */
        Double money = Double.valueOf(request.getParameter("money"));
        Double iopy = 1.2; //当日净值
        Double explainRate = 0.015; //申购费率
        Double netSubscriptionAmount = money / (1.00+explainRate); //净申购金额
        Double subscriptionFees = money - netSubscriptionAmount; //申购费用
        Double shareSubscription = netSubscriptionAmount / iopy; //申购份额

        System.out.println("申购金额:"+money +"元"
                          +" 当日净值:"+iopy
                          +" 申购费率:"+explainRate
                          +" 申购费用:"+subscriptionFees +"元"
                          +" 净申购金额"+netSubscriptionAmount +"元"
                          +" 申购份额"+shareSubscription + "份");
    }

    @RequestMapping("/test2")
    public void test2(Integer num){
        //赎回
        /**
         * 赎回总额＝赎回份额×T日基金份额净值＝8210.18×1.4000≈11494.25(元)
         * 赎回费用＝赎回总额×赎回费率＝11494.25×0.5％≈57.47(元)
         * 赎回净额＝赎回总额－赎回费用＝11494.25－57.47＝11436.78(元)
         */
        Double redemptionRate = 0.005; //赎回费率
        Double iopy = 1.4; //赎回当日基金净值
        Double totalAmountRedemption = num * iopy; //赎回总额
        Double redemptionFee = totalAmountRedemption * redemptionRate; //赎回费用
        Double netRedemption = totalAmountRedemption - redemptionFee; //赎回净额

        System.out.println("赎回份额" + num
                +" 赎回费率" + redemptionFee
                +" 基金净值"+ iopy
                +" 赎回总额 "+ totalAmountRedemption
                +" 赎回费用"+redemptionFee
                +" 赎回净额(收益)" + netRedemption);
    }

}
