package com.example.jsproducerfund.service;

import com.example.jsproducerfund.pojo.*;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 15:03
 */
public interface FundService {

    /**
     * 查询已上市基金信息，多字段查询，分页显示基金信息
     * @param performance
     * @return
     */
    List<Performance> showFunds(Performance performance,Integer pageCount);

    List<Performance> selFunds(HttpServletRequest request, HttpServletResponse response);

    /**
     * 查询新发布基金信息，多字段查询，分页显示基金信息
     * @param fundInfo
     * @param pageCount
     * @return
     */
    List<FundInfo> showNewFunds(FundInfo fundInfo,Integer pageCount);

    /**
     * 基金收藏功能
     * @param fundInfo 基金信息
     * @param username 用户名/真实姓名
     * @return
     */
    String collectFund(FundInfo fundInfo,String username);

    /**
     * 查询收藏信息接口
     * @param collection 可按用户名&基金代码准确定位收藏的基金
     * @return
     */
    List<CollectInfo> selCollection(CollectInfo collection);

    /**
     * 购买基金接口
     * @param fundInfo
     * @param username
     * @return
     *
     * 购买基金做两件事：1.在购买表添加一条购买基金的记录
     *                   2.根据查询余额接口判断余额是否充足，充足购买，不充足反馈用户余额不足
     */
    String buyFund(FundInfo fundInfo,@Param("username") String username);

    /**
     * 查询基金购买记录
     * @param username
     * @return
     */
    String selBuyFund(String username);

    /**
     * 风险承受能力测试接口
     * @param riskAppetite 风险承受能力调查问卷对象
     * @return
     */
    String riskToleranceTest(RiskAppetite riskAppetite);

    /**
     * 基金开户接口
     * @param fundUser 基金开户对象
     * @return
     */
    String addFundAccount(FundUser fundUser);

}
