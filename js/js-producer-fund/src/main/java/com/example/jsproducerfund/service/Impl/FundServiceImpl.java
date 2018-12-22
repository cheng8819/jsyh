package com.example.jsproducerfund.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.*;
import com.example.jsproducerfund.service.FundService;
import com.example.jsproducerfund.util.RiskRatingAlgorithm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
        List<FundInfo> list = fundDao.findNewFunds();
        Integer pageTotal = list.size()/10;  //总页数
        if(pageCount == -1){
            pageNum --;
        }
        if(pageCount == 1){
            pageNum ++;
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageNum > pageTotal){
            pageCount = pageTotal;
        }
        //分页查询 每页显示10行数据
        PageHelper.startPage(pageNum, 10);
        PageInfo<FundInfo> fundPageInfo
                = new PageInfo<>(list);
        return fundPageInfo.getList();
    }

    @Override
    public List<Performance> showFunds(Performance fundInfo,Integer pageCount) {
        List<Performance> list = fundDao.findAll(fundInfo);
        Integer pageTotal = list.size()/10;  //总页数
        if(pageCount == -1){
            pageNum --;
        }
        if(pageCount == 1){
            pageNum ++;
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageNum > pageTotal){
            pageCount = pageTotal;
        }
        //分页查询 每页显示10行数据
        PageHelper.startPage(pageNum,10);
        PageInfo<Performance> fundPageInfo
                = new PageInfo<>(list);
        //使用freemarker模板引擎直接返回list集合
        return fundPageInfo.getList();
    }

    @Override
    public List<Performance> selFunds(HttpServletRequest request, HttpServletResponse response) {
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        /*String fund_number = request.getParameter("fund_number");
        String fund_name = request.getParameter("fund_name");
        String fund_type = request.getParameter("fund_type");
        String fund_rating = request.getParameter("fund_rating");
        Performance performance = new Performance(Integer.parseInt(fund_number),fund_name,fund_type,fund_rating);*/
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
        /*CollectInfo collection = new CollectInfo();
        collection.setFund_name(fund_name);
        collection.setFund_number(fund_number);
        collection.setUsername(username);*/
        Integer result = fundDao.addCollection(collectInfo);
        if(result <= 0){
            return "收藏失败";
        }
        return "收藏成功";
    }

    @Override
    public List<CollectInfo> selCollection(CollectInfo collection) {
        String username = collection.getUsername();
        if(username == null){
            System.out.println("用户名为空,返回null");
            return null;
        }
        return fundDao.selCollection(collection);
    }

    @Override
    public String buyFund(FundInfo fundInfo, String username,Double fund_money) {
        //0.查看银行卡每日消费金额上限，基金每日申购上限

        //1.调银行卡余额接口查看用户余额是否充足

        //2.余额充足在基金购买表添加一条购买记录

        //3.如果基金以前购买过，现在要追加，修改其购买份额,花费金额
        String fund_name = fundInfo.getFund_name();
        String fund_number = fundInfo.getFund_number();
        Double fund_price = fundInfo.getUnit_value();
        if(fund_money == null){
            fund_money = 1000.00; //基金对象里没有花费,默认1000
        }
        Double fund_unit = fund_money / fund_price; //基金对象里没有购买份额
        Date buyDate = new Date(); //购买时间

        //查询记录是否曾经购买过
        List<Buy> buyInfo = selBuyFund(username, fund_number);
        for (Buy info: buyInfo) {
            if (fund_number.equals(info.getProduct_number())){
                fund_money = fund_money + info.getProduct_money(); //原来花费的金额与新增的相加
                fund_unit = fund_unit + info.getProduct_unit(); //原来购买的份额与新购买的相加
            }
        }
        Buy buy = new Buy(username,fund_name,fund_number,fund_unit,fund_money,String.valueOf(buyDate));
        Integer result = fundDao.addBuyFund(buy);
        if(result <= 0){
            return "购买基金失败";
        }
        return "购买基金成功";
    }

    @Override
    public List<Buy> selBuyFund(String username, String fund_number) {
        Buy buy = new Buy();
        if(username == null || "".equals(username)){
            System.out.println("用户名不为空!");
        }
        if(fund_number == null){
            //查询该用户全部购买信息
            return fundDao.selBuyFound(buy);
        }
        //根据用户名和基金代码查一条
        buy.setProduct_number(fund_number);
        buy.setUsername(username);
        return fundDao.selBuyFound(buy);
    }

    @Override
    public String sellFund(String fundName, String username) {
        //1.判断基金期限是否到了

        //2.修改购买基金信息表里的数据
        Double earnings = 1000.00; //收益
        Buy sellInfo = new Buy(username,fundName,earnings,String.valueOf(new Date()));
        fundDao.addBuyFund(sellInfo);
        return null;
    }

    @Override
    public String riskToleranceTest(RiskAppetite riskAppetite) {
        //根据调查问卷算出承受风险等级
        String result = RiskRatingAlgorithm.Algorithm(riskAppetite);
        //将风险等级写入对应用户风险等级栏
        String name = riskAppetite.getName();
        fundDao.updRiskGrade(result,name);
        return result;
    }

    @Override
    public String addFundAccount(FundUser fundUser) {
        //调用短信验证码接口进行身份验证
        if(fundUser.getUsername() == null || fundUser.getPhone() == null ||
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

    @Override
    public String fundEarnings(String fundName) {
        //计算基金收益
        return null;
    }
}
