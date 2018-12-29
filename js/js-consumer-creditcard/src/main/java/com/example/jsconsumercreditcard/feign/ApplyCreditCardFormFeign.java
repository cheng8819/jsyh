package com.example.jsconsumercreditcard.feign;

import com.example.jsconsumercreditcard.entity.CurrentAddress;
import com.example.jsconsumercreditcard.entity.Safety;
import com.example.jsconsumercreditcard.feign.impl.ApplyCreditCardFormFeignImpl;
import com.example.jsconsumercreditcard.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "JS-PRODUCER-CREDITCARD",fallback = ApplyCreditCardFormFeignImpl.class)
public interface ApplyCreditCardFormFeign {

    /**
     * 全部卡类型
     * @return
     */
    @GetMapping("/currentType/allCardType")
    Result allCardType();

    /**
     * 新增地址
     * @param currentAddress 地址对象
     * @return
     */
    @PostMapping("/currentAddress/addCurrentAddress")
    Result addCurrentAddress(@RequestBody CurrentAddress currentAddress);

    /**
     * 新增安全问题
     * @param safety
     * @return
     */
    @PostMapping("/safety/addSafety")
    Result addSafety(@RequestBody Safety safety);

    /**
     * 获取全部安全问题
     * @return
     */
    @GetMapping("/safetyProblem/allSafetyProblemCon")
    Result allSafetyProblemCon();

    /**
     * 通过主键查询信用类型
     *
     * @param id 主键
     * @return 信用卡类型
     */
    @GetMapping("/currentType/findCurrentTypeById/{id}")
    Result findCurrentTypeById(@PathVariable("id") Integer id);

}
