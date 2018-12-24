package com.example.jsproducerfinancial.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerfinancial.dao.FinancialDao;
import com.example.jsproducerfinancial.pojo.BrowsingHistory;
import com.example.jsproducerfinancial.pojo.Buy;
import com.example.jsproducerfinancial.pojo.Finance;
import com.example.jsproducerfinancial.service.FinancialService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/21 11:20
 */
@Service
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    private FinancialDao financialDao;

    @Override
    public String buyFinancial(Finance finance,String username,Double money) {
        Buy buy = new Buy();
        buy.setProduct_name(finance.getProduct_name());
        buy.setProduct_number(finance.getProduct_code());
        buy.setUsername(username);
        buy.setProduct_money(money);
        buy.setBuy_time(String.valueOf(new Date())); //放置时间戳

        Integer result = financialDao.addBuyFinance(buy);
        if(result <= 0){
            return "购买失败";
        }
        return "购买成功";
    }

    @Override
    public String sellFinancial(Finance finance,String username) {
        String financeName = finance.getProduct_name();
        //计算理财产品收益
        Double earings = Double.valueOf(calculateEarnings(finance,username));
        Buy newBuy = new Buy(username,financeName,earings,String.valueOf(new Date()));
        Integer result = financialDao.updBuyFinance(newBuy);
        if(result <= 0){
            return "赎回失败";
        }
        return "赎回成功";
    }

    @Override
    public String showBuyFinancial(String username) {
        if(username == null || "".equals(username)){
            return "用户名不为空";
        }
        Buy buy = new Buy();
        buy.setUsername(username);
        List<Buy> list = financialDao.selBuyFinance(buy);
        if(list.size() <= 0){
            return "未查询到购买信息";
        }
        return JSON.toJSONString(list);
    }

    private Integer pageNum = 0;
    @Override
    public String showFinancial(Finance finance,Integer pageCount) {
        List<Finance> list = financialDao.findAll(finance);
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
        PageInfo<Finance> fundPageInfo = new PageInfo<>(list);
        return JSON.toJSONString(fundPageInfo.getList());
    }

    @Override
    public String calculateEarnings(Finance finance,String username) {
        //计算理财财产品收益
        //投资人预期收益＝理财本金×预期收益率×理财期限/365。
        Integer time_limit = Integer.valueOf(finance.getTime_limit()); //理财期限
        Double annualizedReturns = Double.valueOf(finance.getExpected_annualized_rate()); //年化收益率
        Buy buy = new Buy();
        buy.setUsername(username);
        Buy buyFinance = financialDao.selBuyFinance(buy).get(0);
        Double productValue = buyFinance.getProduct_money(); //产品价值
        Double earings = productValue * annualizedReturns * time_limit / 365;
        return String.valueOf(earings);
    }

    @Override
    public String addBrowsingHistory(Finance finance,String username) {
        BrowsingHistory browsingHistory = new BrowsingHistory();
        browsingHistory.setUsername(username);
        browsingHistory.setProduct_name(finance.getProduct_name());
        browsingHistory.setProduct_number(finance.getProduct_code());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime =  sdf.format(new Date());
        browsingHistory.setBrowsing_history_time(datetime);

        Integer result = financialDao.addHistory(browsingHistory);
        if(result <= 0){
            return "添加浏览记录失败";
        }
        return "添加浏览记录成功";
    }

    @Override
    public String showBrowsingHistory(BrowsingHistory browsingHistory) {
        List<BrowsingHistory> list = financialDao.findAllBH(browsingHistory);
        if(list.size() <= 0){
            return "未查询到浏览记录";
        }
        return JSON.toJSONString(list);
    }

    @Override
    public String showFinancialDetails(String financialName) {
        Finance finance = new Finance();
        finance.setProduct_name(financialName);
        Finance finance1 = financialDao.findAll(finance).get(0);
        return JSON.toJSONString(finance);
    }
}
