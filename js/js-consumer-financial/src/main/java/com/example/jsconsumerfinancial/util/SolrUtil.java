package com.example.jsconsumerfinancial.util;


import java.util.UUID;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/7 16:31
 *
 * Solr工具类
 */
public class SolrUtil {

    /**
     * 添加文档
     */
    /*public static String addDocument(){
        //创建Solr的客户端链接对象
            *//*String urlString ="http://47.95.116.4:8983/solr/bank";
            SolrClient solrServer=new HttpSolrClient.Builder(urlString).build();
            for(int i=3;i<100;i++){
                //创建一个文档对象
                SolrInputDocument sd=new SolrInputDocument();
                //添加域
                sd.addField("product_code", UUID.randomUUID());
                sd.addField("product_name", "商品"+i);
                sd.addField("product_type", "精品主题");
                sd.addField("break_even", "保本浮动型");
                sd.addField("currency", "美元");
                sd.addField("customer_risk_level", "R1");
                try {
                    solrServer.add(sd);
                    solrServer.commit();
                } catch (Exception e) {
                    return "添加失败";
                }
            }*//*
        return "添加成功";
    }*/

}
