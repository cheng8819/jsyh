package com.example.jsproducerfinancial.service;

public interface FinancialService {

    /**
     * 购买理财产品
     * @return
     */
    String buyFinancial();

    /**
     * 赎回理财产品
     * @return
     */
    String sellFinancial();

    /**
     * 查看购买的理财产品
     * @return
     */
    String showBuyFinancial();

    /**
     * 分类、分页展示理财产品
     * @return
     */
    String showFinancial();

    /**
     * 计算理财产品收益
     * @return
     */
    String calculateEarnings();

    /**
     * 添加浏览记录
     * @return
     */
    String addBrowsingHistory();

    /**
     * 展示浏览记录
     * @return
     */
    String showBrowsingHistory();

}
