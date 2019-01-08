package com.example.jsproducerfund.controller;

import com.example.jsproducerfund.util.SolrUtil.SolrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/6 22:47
 */
@Api("Solr搜索服务器api")
@Controller
@CrossOrigin(origins="*")
public class SolrController {

    @Autowired
    private SolrUtil solrUtil;

    @ApiOperation(value = "定时全量导入数据",notes = "solr服务器")
    @ResponseBody
    @RequestMapping(value = "/fullAmountOfImport",method = RequestMethod.GET)
    public String fullAmountOfImport(){
        return solrUtil.fullAmountOfImport();
    }

    @ApiOperation(value = "solr搜索数据",notes = "solr服务器")
    @ResponseBody
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String search(@RequestParam("keywords") String keywords){
        return solrUtil.search(keywords);
    }

}
