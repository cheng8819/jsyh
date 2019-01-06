package com.example.jsconsumerfinancial.service;

import com.example.jsconsumerfinancial.service.Impl.FinanceServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 理财产品服务生产者
 */
@FeignClient(value = "js-producer-financial",fallback = FinanceServiceImpl.class)
public interface FinanceService {

    @ApiOperation(value = "查询理财产品信息",notes = "多字段查询，分页")
    @RequestMapping(value = "/showFinance",method = RequestMethod.GET)
    public String showFinance(@RequestParam("index") Integer index);


    @ApiOperation(value = "购买理财产品",notes = "三个主要参数：产品信息、用户标识、金额")
    @ResponseBody
    @RequestMapping(value = "/buyFinance",method = RequestMethod.GET)
    public String buyFinance(@RequestParam("financeName") String financeName,
                             @RequestParam("username") String username,
                             @RequestParam("money") Double money);

}
