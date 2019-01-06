package com.example.jsproducerfund.dao;

import com.example.jsproducerfund.pojo.*;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 基金信息操作
 */
@Mapper
@Repository
public interface FundDao {

    /**
     * 查询全部基金信息
     * @param fundInfo
     * @return
     */
    List<Performance> findAll(FundInfo fundInfo);

    /**
     * 查询新发布的基金信息
     * @return
     */
    List<FundInfo> findNewFunds();

    /**
     * 查询新发布的基金信息
     * @return
     */
    List<FundInfo> findOldFunds(@Param("fund_type") String fund_type);

    /**
     * 查询基金走势信息
     * @return
     */
    List<Performance> selPerformance(@Param("fundNumber") String fundNumber);

    /**
     * 添加基金走势信息
     * @param performance
     * @return
     */
    Integer addPerformance(Performance performance);

    /**
     * 根据基金名称查看基金详情
     * @param fundNumber
     * @return
     */
    FundInfo showFundDetails(@Param("fundNumber") String fundNumber);

    /**
     * 查询基金经理信息
     * @return
     */
    FundManager selFundManager(String ManagerName);

    /**
     *修改基金信息
     * @param fundInfo
     * @return
     */
    Integer updFundInfo(FundInfo fundInfo);

    /**
     * 初始化：从基金信息表查询要变化的走势数据
     * @return
     */
    List<Performance> findPerformanceByFundInfo();

}
