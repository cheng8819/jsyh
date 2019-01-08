package com.example.jsproducerfund.dao;

import com.example.jsproducerfund.pojo.Buy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * 基金 购买/赎回 数据操作
 */
@Mapper
@Repository
public interface BuyDao {

    /**
     * 添加基金购买信息
     * @param buy 基金购买信息
     * @return
     */
    Integer addBuyFund(Buy buy);

    /**
     * 修改基金购买信息 ：用于赎回基金
     * @param buy
     * @return
     */
    Integer updBuyFund(Buy buy);

    /**
     * 按条件查询基金购买信息
     * @param buy
     * @return
     */
    List<Buy> selBuyFound(Buy buy);

    /**
     * 按时间段查询购买记录
     * @param startTime
     * @param stopTime
     * @return
     */
    List<Buy> findBuyInfoByTime(@Param("username") String username,@Param("startTime") String startTime,@Param("stopTime") String stopTime);

    /**
     * 按时间段查询赎回记录
     * @param startTime
     * @param stopTime
     * @return
     */
    List<Buy> findSellInfoByTime(@Param("username") String username,@Param("startTime") String startTime,@Param("stopTime") String stopTime);
}
