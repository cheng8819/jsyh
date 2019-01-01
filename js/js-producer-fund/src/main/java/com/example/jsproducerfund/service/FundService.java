package com.example.jsproducerfund.service;

import com.example.jsproducerfund.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 15:03
 */
public interface FundService {

    /**
     * 查询已上市基金信息
     * 按类型查询
     * @return
     */
    String showOldFunds(String fundType);

    /**
     * 查询新发布基金信息
     *
     * @return
     */
    String showNewFunds();

    /**
     * 多字段查询 分页
     * 查询全部基金信息
     * @param fundInfo
     * @return
     */
    String showAllFunds(FundInfo fundInfo);

    /**
     * 根据基金名称查看基金详情
     * @return
     */
    String showFundDetails(@Param("fundName")String fundName);

    /**
     * 查询基金走势信息
     * @return
     */
    String showFundPerformance(@Param("fundNumber") String fundNumber);

    /**
     * @param performance
     * @return
     */
    String addFundPerformance(Performance performance);
}
