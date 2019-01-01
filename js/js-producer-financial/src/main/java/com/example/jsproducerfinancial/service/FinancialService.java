package com.example.jsproducerfinancial.service;

import com.example.jsproducerfinancial.pojo.BrowsingHistory;
import com.example.jsproducerfinancial.pojo.Finance;

public interface FinancialService {

    /**
     * 购买理财产品
     * 1.判断用户余额是否充足，不充足提示充值后再来购买
     * 2.余额充足，减去用户余额
     * 3.添加一条购买记录
     * @param finance 理财产品
     * @param username 用户标识
     * @param money 购买金额
     * @return
     */
    String buyFinancial(Finance finance,String username,Double money);

    /**
     * 赎回理财产品
     * 1.判断产品期限是否到期
     * 2.改变购买记录里的产品状态
     * 3.向银行账户打钱--收益
     * @param finance 理财产品
     * @param username 用户标识
     * @return
     */
    String sellFinancial(Finance finance,String username);

    /**
     * 查看购买的理财产品
     * 1.展示几个字段，用户点击产品名称时查看详情
     * @param username
     * @return
     */
    String showBuyFinancial(String username);

    /**
     * 根据产品名称查看详细信息
     * @param financialName 产品名称
     * @return
     */
    String showFinancialDetails(String financialName);

    /**
     * 分类、分页展示理财产品
     * @param finance 产品字段
     * @return
     */
    String showFinancial(Integer pageCount);

    /**
     * 计算理财产品收益
     * 1.根据理财产品的收益率计算计算收益
     * @return
     */
    String calculateEarnings(Finance finance,String username);

    /**
     * 添加浏览记录
     * 1.用户查看理财产品详情时添加浏览记录
     * @param finance 产品信息
     * @param username 用户标识
     * @return
     */
    String addBrowsingHistory(Finance finance,String username);

    /**
     * 展示浏览记录
     * @param browsingHistory
     * @return
     */
    String showBrowsingHistory(BrowsingHistory browsingHistory);

}
