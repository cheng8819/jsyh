package com.example.jsproducerfund.service.Impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.*;
import com.example.jsproducerfund.service.FundService;
import com.example.jsproducerfund.util.RiskRatingAlgorithm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 15:06
 */
@Service
public class FundServiceImpl implements FundService {

    @Autowired
    private FundDao fundDao;

    private Integer pageNum = 1;

    @Override
    public List<FundInfo> showNewFunds(FundInfo fundInfo, Integer pageCount) {
        if(pageCount == -1){
            pageNum --;
        }
        if(pageCount == 1){
            pageNum ++;
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageNum > 4){
            pageCount = 4;
        }
        //分页查询 每页显示10行数据
        PageHelper.startPage(pageNum, 10);
        PageInfo<FundInfo> fundPageInfo
                = new PageInfo<>(fundDao.findNewFunds());
        return fundPageInfo.getList();
    }

    @Override
    public List<Performance> showFunds(Performance fundInfo,Integer pageCount) {
        if(pageCount == -1){
            pageNum --;
        }
        if(pageCount == 1){
            pageNum ++;
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageNum > 4){
            pageCount = 4;
        }
        //分页查询 每页显示10行数据
        PageHelper.startPage(pageNum,10);
        PageInfo<Performance> fundPageInfo
                = new PageInfo<>(fundDao.findAll(fundInfo));
        //使用freemarker模板引擎直接返回list集合
        return fundPageInfo.getList();
    }

    @Override
    public List<Performance> selFunds(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return fundDao.findAll(null);
    }

    @Override
    public String collectFund(FundInfo fundInfo, String username) {
        String fund_name = fundInfo.getFund_name();
        String fund_number = fundInfo.getFund_number();
        CollectInfo collectInfo = new CollectInfo();
        collectInfo.setFund_name(fund_name);
        collectInfo.setFund_number(fund_number);
        collectInfo.setUsername(username);
        //先查询该基金是否已经收藏过
        List<CollectInfo> collections = selCollection(collectInfo);
        if(collections.size() > 0){
            /*for (CollectInfo coll: collections) {
                if(fund_number.equals(coll.getFund_number()) && username.equals(coll.getUsername())){
                    return "已收藏";
                }
            }*/
            return "已收藏";
        }
        //没收藏过就添加收藏信息
        CollectInfo collection = new CollectInfo();
        collection.setFund_name(fund_name);
        collection.setFund_number(fund_number);
        collection.setUsername(username);
        Integer result = fundDao.addCollection(collection);
        if(result <= 0){
            return "收藏失败";
        }
        return "收藏成功";
    }

    @Override
    public List<CollectInfo> selCollection(CollectInfo collection) {
        String username = collection.getUsername();
        if(username == null){
            System.out.println("用户名为空，默认查全部");
        }
        return fundDao.selCollection(collection);
    }

    @Override
    public String buyFund(FundInfo fundInfo, String username) {
        //0.查看银行卡每日消费金额上限，基金每日申购上限

        //1.调银行卡余额接口查看用户余额是否充足

        //2.余额充足在基金购买表添加一条购买记录

        //3.如果基金以前购买过，现在要追加，修改其购买份额,花费金额
        String fund = fundInfo.getFund_name();
        Buy buy = new Buy();
        buy.setFunds(fund);
        //接口参数类型需要改
        buy.setFund_unit(1000);
        buy.setFund_money(new BigDecimal("1000"));
        buy.setUsername(username);
        Integer result = fundDao.addBuyFund(buy);
        if(result <= 0){
            return "购买基金失败";
        }
        return "购买基金成功";
    }

    @Override
    public String selBuyFund(String username) {
        if(username == null || "".equals(username)){
            return "用户名不为空!";
        }
        Buy buy = new Buy();
        buy.setUsername(username);
        return JSON.toJSONString(fundDao.selBuyFound(buy));
    }

    @Override
    public String riskToleranceTest(RiskAppetite riskAppetite) {
        //根据调查问卷算出承受风险等级
        String result = RiskRatingAlgorithm.Algorithm(riskAppetite);
        //将风险等级写入对应用户风险等级栏
        fundDao.updRiskGrade(result);
        return result;
    }

    @Override
    public String addFundAccount(FundUser fundUser) {
        if(fundUser.getName() == null || fundUser.getPhone() == null ||
                fundUser.getCard_number() == null || fundUser.getCard_type() == null ||
                fundUser.getBeneficial_owner() == null || fundUser.getSex() == null ||
                fundUser.getCapital_source() == null)
        {
            return "开户信息不与允许为空";
        }
        Integer result = fundDao.addFundAccount(fundUser);
        if(result <= 0){
            return "开户失败";
        }
        return "开户成功";
    }
}
