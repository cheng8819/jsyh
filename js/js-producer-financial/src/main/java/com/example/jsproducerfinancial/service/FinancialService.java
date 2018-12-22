package com.example.jsproducerfinancial.service;

public interface FinancialService {

    /**
     * 购买理财产品
     * 1.判断用户余额是否充足，不充足提示充值后再来购买
     * 2.余额充足，减去用户余额
     * 3.添加一条购买记录
     * @return
     */
    String buyFinancial();

    /**
     * 赎回理财产品
     * 1.判断产品期限是否到期
     * 2.改变购买记录里的产品状态
     * 3.向银行账户打钱--收益
     * @return
     */
    String sellFinancial();

    /**
     * 查看购买的理财产品
     * 1.展示几个字段，用户点击产品名称时查看详情
     * @return
     */
    String showBuyFinancial();

    /**
     * 根据产品名称查看详细信息
     * @param financialName
     * @return
     */
    String showFinancialDetails(String financialName);

    /**
     * 分类、分页展示理财产品
     * @return
     */
    String showFinancial();

    /**
     * 计算理财产品收益
     * 1.根据理财产品的收益率计算计算收益
     * @return
     */
    String calculateEarnings();

    /**
     * 添加浏览记录
     * 1.用户查看理财产品详情时添加浏览记录
     * @return
     */
    String addBrowsingHistory();

    /**
     * 展示浏览记录
     * @return
     */
    String showBrowsingHistory();

}
