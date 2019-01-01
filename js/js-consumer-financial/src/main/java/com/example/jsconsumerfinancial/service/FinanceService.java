package com.example.jsconsumerfinancial.service;

import com.example.jsconsumerfinancial.pojo.BrowsingHistory;
import com.example.jsconsumerfinancial.pojo.Finance;
import com.example.jsconsumerfinancial.service.Impl.FinanceServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "js-producer-financial",fallback = FinanceServiceImpl.class)
public interface FinanceService {

    @ApiOperation(value = "查询理财产品信息",notes = "多字段查询，分页")
    @RequestMapping(value = "/showFinance",method = RequestMethod.GET)
    public String showFinance(@RequestParam("index") Integer index);

}
