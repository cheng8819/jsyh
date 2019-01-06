package com.example.jsconsumerfinancial.service.Impl;

import com.example.jsconsumerfinancial.pojo.Finance;
import com.example.jsconsumerfinancial.service.FinanceService;
import com.example.jsconsumerfinancial.service.FinancialService;
import com.example.jsconsumerfinancial.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/26 22:18
 *
 * 理财消费者 业务类
 */
@Service
public class FinancialServiceImpl implements FinancialService {

    /**
     * 消费者服务
     */
    @Autowired
    private FinanceService financeService;

    /**
     * 账户管理服务
     */
    @Autowired
    private ManagementService managementService;

    /**
     *
     * @param financeName
     * @param username
     * @param money
     * @return
     * @desc:
     *      //1. 根据理财产品名称获取理财产品信息
     *      //2.判断用户余额是否充足
     *      //3.计算相关费用(注：说明书中的销售费、托管费和管理费会在产品运作中扣除，
     *      不会通过个人账户中扣取，公布的产品收益率或净值都是已经扣除了上述费用的)
     *      //4.添加购买信息
     *      //5.修改理财产品份额信息、资金规模
     */
    @Override
    public String buyFinancial(String financeName, String username, Double money) {
        if(financeName == null){
            return "产品名称不为空";
        }
        Finance finance = new Finance();
        finance.setProduct_name(financeName);
        Finance financeInfo =  null;//financeService.findAll(finance).get(0);
        if(financeInfo == null){
            return "未查询到相关信息";
        }
        Double balance = managementService.selectBalance(username);
        if(balance < financeInfo.getSingle_subscription_limit()){
            return "余额不足，充值之后再来购买";
        }
        return null;
    }
}
