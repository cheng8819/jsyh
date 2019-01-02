package com.example.jsproducerfinancial.dao;

import com.example.jsproducerfinancial.pojo.BrowsingHistory;
import com.example.jsproducerfinancial.pojo.Buy;
import com.example.jsproducerfinancial.pojo.Finance;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FinancialDao {

    /**
     * 查询全部理财产品信息
     * @param finance
     * @return
     */
    List<Finance> findAll(Finance finance);

    /**
     * 增加理财产品信息
     * @param finance
     * @return
     */
    Integer addFinance(Finance finance);

    /**
     * 根据ID删除理财产品信息
     * @param product_id
     * @return
     */
    Integer delFinance(Integer product_id);

    /**
     * 修改理财产品信息
     * @param finance
     * @return
     */
    Integer updFinance(Finance finance);

    /**
     * 添加历史浏览记录
     * @return
     */
    Integer addHistory(BrowsingHistory browsingHistory);

    /**
     * 查询用户浏览记录
     * @return
     */
    List<BrowsingHistory> findAllBH(BrowsingHistory browsingHistory);

    /**
     * 添加购买理财产品信息
     * @param buy 购买理财产品信息
     * @return
     */
    Integer addBuyFinance(Buy buy);

    /**
     * 修改购买信息
     * @param buy
     * @return
     */
    Integer updBuyFinance(Buy buy);

    /**
     * 按条件查询理财产品购买信息
     * @param buy
     * @return
     */
    List<Buy> selBuyFinance(Buy buy);

}
