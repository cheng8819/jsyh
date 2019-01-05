package com.example.jsconsumerregister.jsconsumerregister.feign;

import com.service.pojo.ClientRegisterUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户注册服务
 */
@FeignClient(name = "js-producer-register")
public interface ClientRegisterFeign {
    /**
     * 手机号是否注册
     * @param phone
     * @param idNumber
     * @return
     */
    @RequestMapping("/registerPhoneExists")
    String registerPhoneExists(@RequestParam("phone") String phone,@RequestParam("idNumber") String idNumber);
    /**
     * 添加网银用户
     */
    @RequestMapping("/addInternetUser")
    String addInternetUser(@RequestBody ClientRegisterUser clientRegisterUser);
}
