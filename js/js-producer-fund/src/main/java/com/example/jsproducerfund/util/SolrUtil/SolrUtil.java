package com.example.jsproducerfund.util.SolrUtil;

import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.FundInfo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class SolrUtil {

    @Autowired
    private SolrClient solrClient;

    @Autowired
    private FundDao fundDao;

    /**
     * Solr 定时全量导入
     * @return
     */
    public String fullAmountOfImport(){
        ArrayList<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        List<FundInfo> allFunds = fundDao.findAll(null);
        for (FundInfo fund: allFunds) {
            SolrInputDocument doc = new SolrInputDocument();
            doc.setField("fund_number",fund.getFund_number());
            doc.setField("fund_name",fund.getFund_name());
            doc.setField("fund_shortname",fund.getFund_shortname());
            doc.setField("fund_rating",fund.getFund_rating());
            doc.setField("fund_type",fund.getFund_type());
            doc.setField("fund_kind",fund.getFund_kind());
            doc.setField("issuing_date",fund.getIssuing_date());
            doc.setField("currency",fund.getCurrency());
            doc.setField("fundStatus",fund.getFundStatus());
            doc.setField("raise_way",fund.getRaise_way());
            doc.setField("fund_scale",fund.getFund_scale());
            doc.setField("fund_newscale",fund.getFund_newscale());

            doc.setField("unit_value",fund.getUnit_value());
            doc.setField("maximum_rengou_rate",fund.getMaximum_rengou_rate());
            doc.setField("maximum_shengou_rate",fund.getMaximum_shengou_rate());
            doc.setField("maximum_redemption_rate",fund.getMaximum_redemption_rate());
            doc.setField("minimum_initial_subscription_amount",fund.getMinimum_initial_subscription_amount());
            doc.setField("minimum_purchase_amount",fund.getMinimum_purchase_amount());
            doc.setField("minimum_additional_subscription_amount",fund.getMinimum_additional_subscription_amount());

            doc.setField("performance_benchmark",fund.getPerformance_benchmark());
            doc.setField("risk_grade",fund.getRisk_grade());
            doc.setField("start_date",fund.getStart_date());
            doc.setField("portfolio_manager",fund.getPortfolio_manager());
            doc.setField("fund_manager",fund.getFund_manager());
            doc.setField("fund_trustee",fund.getFund_trustee());

            doc.setField("investment_scope",fund.getInvestment_scope());
            doc.setField("investment_objective",fund.getInvestment_objective());
            doc.setField("create_time",fund.getCreate_time());
            doc.setField("fund_trustee",fund.getFund_trustee());
            doc.setField("iopv",fund.getIopv());
            doc.setField("iopvs",fund.getIopvs());
            doc.setField("dailyIncreases",fund.getDailyIncreases());

            doc.setField("weekly_rate_of_return",fund.getWeekly_rate_of_return());
            doc.setField("monthly_rate_of_return",fund.getMonthly_rate_of_return());
            doc.setField("threeMonthRise",fund.getThreeMonthRise());
            doc.setField("fund_company",fund.getFund_company());

            docs.add(doc);
        }
        try {
            solrClient.add(docs);
        } catch (Exception e) {
            return "数据导入失败";
        }
        return "数据导入成功";
    }

    /**
     * 删除所有的索引
     * @return
     */
    public String deleteAll(){
        try {
            solrClient.deleteByQuery("*:*");
            solrClient.commit(false,false);
        } catch (Exception e) {
            return "删除所有索引失败";
        }
        return "删除所有索引成功";
    }

    /**
     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
     * @return
     */
    public String search(String keywords){
        SolrQuery solrQuery = new SolrQuery();
        //搜索条件
        solrQuery.set("q","keywords:" + keywords);
        try {
            QueryResponse response = solrClient.query(solrQuery);
            SolrDocumentList results = response.getResults();
            for (SolrDocument doc : results) {
                Object fund_number = doc.get("fund_number");
                Object fund_name = doc.get("fund_name");
                Object fund_shortname = doc.get("fund_shortname");
                Object fund_rating = doc.get("fund_rating");
                Object fund_type = doc.get("fund_type");
                Object fund_kind = doc.get("fund_kind");
                Object issuing_date = doc.get("issuing_date");
                System.out.println(fund_number + "=" + fund_name + "=" + fund_shortname + "=" +
                        fund_rating + "=" + fund_type + "=" +fund_kind + "=" + issuing_date);
            }
        } catch (Exception e) {
            return "未查询到相关信息";
        }
        return "true";
    }

}

