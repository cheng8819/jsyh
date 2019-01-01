package com.example.jscosumerfund.service;

import com.example.jscosumerfund.pojo.FundInfo;
import com.example.jscosumerfund.service.Impl.FundServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "js-producer-fund",fallback = FundServiceImpl.class)
public interface FundService {

    @ApiOperation(value = "查询新发布基金产品信息",notes = "支持分页查询、多字段查询")
    @ResponseBody
    @RequestMapping(value = "/showNewFunds",method = RequestMethod.GET)
    public String showNewFunds();

    /**
     * @return
     */
    @ApiOperation(value = "查询已上市基金产品信息",notes = "按类型字段查询，支持分页查询,index参数 1:上一页  -1:下一页")
    @ResponseBody
    @RequestMapping(value = "/showOldFunds",method = RequestMethod.GET)
    public String showOldFunds(@RequestParam("fundType") String fundType);

    /**
     * @return
     */
    @ApiOperation(value = "查询全部基金产品信息",notes = "支持多字段查询，支持分页查询,index参数 1:上一页  -1:下一页")
    @ResponseBody
    @RequestMapping(value = "/showAllFunds",method = RequestMethod.GET)
    public String showAllFunds(@RequestBody(required = false) FundInfo fundInfo);

    @ApiOperation(value = "查询基金产品详情",notes = "根据基金名称查找")
    @ResponseBody
    @RequestMapping(value = "/showFundDetails",method = RequestMethod.GET)
    public String showFundDetails(@RequestParam("fundNumber") String fundNumber);

    @ApiOperation(value = "查询基金走势信息",notes = "根据基金名称查找")
    @ResponseBody
    @RequestMapping(value = "/showFundPerformance",method = RequestMethod.GET)
    public String showFundPerformance(@RequestParam("fundNumber")String fundNumber);

}
