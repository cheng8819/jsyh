package com.example.jsproducerfund.util.SolrUtil;

import com.example.jsproducerfund.dao.FundDao;
import com.example.jsproducerfund.pojo.FundInfo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("solr")
public class SolrUtil {

    @Autowired
    private SolrClient client;

    @Autowired
    private FundDao fundDao;

    /**
     * Solr 定时全量导入
     *
     * 每天中午12和23点定时更新数据
     * @return
     */
    @Scheduled(cron="0 0 15 * * ?")
    public String fullAmountOfImport(){
       List<SolrInputDocument> documents = new ArrayList<SolrInputDocument>();
       //数据库查询全部数据
       List<FundInfo> funds = fundDao.findNewFunds();
        for (FundInfo fund : funds) {
            SolrInputDocument doc = new SolrInputDocument();
            doc.setField("fund_name",fund.getFund_name());
            doc.setField("fund_number",fund.getFund_number());
            documents.add(doc);
        }
        try {
            client.add("fundInfo",documents);
            client.commit("fundInfo");
        } catch (Exception e) {
            e.printStackTrace();
            return "数据导入失败";
        }
        return "数据导入成功";
    }

    /**
     * 新增/修改 索引
     * 当 id 存在的时候, 此方法是修改(当然, 我这里用的 uuid, 不会存在的), 如果 id 不存在, 则是新增
     * @return
     */
    @RequestMapping("add")
    public String add() {
        try {
            SolrInputDocument doc = new SolrInputDocument();
            doc.setField("id", 970529);
            doc.setField("fund_name", "我是中国人, 我爱中国");
            doc.setField("fund_number","19970529");

            /* 如果spring.data.solr.host 里面配置到 core了, 那么这里就不需要传 collection1 这个参数
             * 下面都是一样的
             */
            client.add(doc);
            //client.commit();
            client.commit();
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 根据id删除索引
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String delete(String id)  {
        try {
            client.deleteById("collection1",id);
            client.commit("collection1");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 删除所有的索引
     * @return
     */
    @RequestMapping("deleteAll")
    public String deleteAll(){
        try {

            client.deleteByQuery("collection1","*:*");
            client.commit("collection1");

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 根据id查询索引
     * @return
     * @throws Exception
     */
    @RequestMapping("getById")
    public String getById() throws Exception {
        SolrDocument document = client.getById("collection1", "536563");
        System.out.println(document);
        return document.toString();
    }

    /**
     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
     * @return
     */
    @RequestMapping("search")
    public String search(){

        //初始化SolrQuery
        SolrQuery query = new SolrQuery("*:*");
        query.setSort("fund_number", SolrQuery.ORDER.desc);
        query.setStart(0);
        //一页显示多少条
        query.setRows(10);
        QueryResponse queryResponse = null;
        try {
            queryResponse = client.query(query);
            List<FundInfo> list = queryResponse.getBeans(FundInfo.class);
            for (FundInfo fund:list){
                System.out.println(fund.getFund_kind() + "==" + fund.getFund_number() );
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

