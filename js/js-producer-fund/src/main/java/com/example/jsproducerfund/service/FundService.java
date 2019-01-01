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
     * 查询已上市基金信息，多字段查询，分页显示基金信息
     *
     * @return
     */
    String showFunds(String fundType);

    /**
     * 根据基金名称查看基金详情
     * @return
     */
    String showFundDetails(@Param("fundName")String fundName);

    /**
     * 查询已上市基金产品
     *
     * @return
     */
    String selFunds();

    /**
     * 查询新发布基金信息，多字段查询，分页显示基金信息
     *
     * @return
     */
    String showNewFunds();

    /**
     * 基金收藏功能
     * @param fund_name 基金名称
     * @param fund_number 基金代码
     * @param username 用户名/真实姓名
     * @return
     */
    String collectFund(String fund_name,String fund_number,String username);

    /**
     * 查询收藏信息接口
     * @param username 可按用户名&基金代码准确定位收藏的基金
     * @return
     */
    String selCollection(String username);

    /**
     * 购买基金接口
     * @param fundInfo
     * @param username
     * @return
     *
     * 购买基金做两件事：1.在购买表添加一条购买基金的记录
     *                   2.根据查询余额接口判断余额是否充足，充足购买，不充足反馈用户余额不足
     */
    String buyFund(FundInfo fundInfo,@Param("username") String username,@Param("fund_money") Double fund_money);

    /**
     * 查询基金购买记录
     * @param username
     * @param fund_number
     * @return
     */
    String selBuyFund(@Param("username") String username,@Param("fund_number") String fund_number);

    /**
     * 赎回基金
     * 1.判断基金期限是否到期
     * 2.根据收益情况给客户打钱
     * @param fundName
     * @param username
     * @return
     */
    String sellFund(String fundName,String username);

    /**
     * 计算基金收益
     * @param fundName 基金名称
     * @param num 赎回份额
     * @param time 购买天数
     * @return
     */
    String fundEarnings(String fundName,Integer num,Integer time);

    /**
     * 计算申购费用
     * @param fundName
     * @param money
     * @return
     */
    String fundSubscriptionFee(String fundName,Double money);

    /**
     * 风险承受能力测试接口
     * @param riskAppetite 风险承受能力调查问卷对象
     * @return
     */
    String riskToleranceTest(RiskAppetite riskAppetite);

    /**
     * 基金开户接口
     * 1.填写必要资料，进行判断
     * 2.发送验证码
     * 3.添加客户开户信息
     * @param fundUser 基金开户对象
     * @return
     */
    String addFundAccount(FundUser fundUser);

    /**
     * 基金定投
     * @param jobName 定时任务名称
     * @param time 任务执行时间
     * @return
     */
    String automaticInvestmentPlan(String jobName,String time);

}
