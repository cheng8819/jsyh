package com.example.jsproducerfund.dao;

import com.example.jsproducerfund.pojo.*;
import com.example.jsproducerfund.pojo.CollectInfo;

import java.util.List;

import com.example.jsproducerfund.util.RiskScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FundDao {

    /**
     * 查询基金信息
     * @param performance
     * @return
     */
    List<Performance> findAll(Performance performance);

    /**
     * 查询新发布的基金信息
     * @return
     */
    List<FundInfo> findNewFunds();

    /**
     * 添加收藏信息
     * @param collection 收藏信息
     * @return
     */
    Integer addCollection(CollectInfo collection);

    /**
     * 查询收藏信息
     * @param collection 查询条件
     * @return
     */
    List<CollectInfo> selCollection(CollectInfo collection);

    /**
     * 添加基金购买信息
     * @param buy 基金购买信息
     * @return
     */
    Integer addBuyFund(Buy buy);

    /**
     * 按条件查询基金购买信息
     * @param buy
     * @return
     */
    List<Buy> selBuyFound(Buy buy);

    /**
     * 修改用户风险等级
     * @param risk_grade
     * @return
     */
    Integer updRiskGrade(@Param("risk_grade") String risk_grade,@Param("name") String name);

    /**
     * 添加基金账户
     * @param fundUser
     * @return
     */
    Integer addFundAccount(FundUser fundUser);

}
