package com.example.jsregisterprovider.jsproviderregister.controller;

import com.example.jsregisterprovider.jsproviderregister.service.ClientRegisterService;
import com.service.pojo.ClientRegister;
import com.service.pojo.ClientRegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户注册
 */
@SuppressWarnings("ALL")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
public class ClientRegisterController {
    @Autowired
    @Qualifier("clientRegisterServiceImpl")
    private ClientRegisterService clientRegisterService;
    /**
     * 用户注册接口
     */
    @RequestMapping
    public String clientRegister(@RequestBody ClientRegister clientRegister){
        return "";
    }

    /**
     * 添加网银用户
     */
    @RequestMapping("/addInternetUser")
    public String addInternetUser(@RequestBody ClientRegisterUser clientRegisterUser){
        return clientRegisterService.addInternetUser(clientRegisterUser);
    }



    /**
     * 查询用户身份证和姓名是否注册了网银，注册了返回手机号，未注册直接注册
     */

    /**
     * 用户手机号查询是否已注册
     */
    @RequestMapping("/registerPhoneExists")
    public String registerPhoneExists(@RequestParam("phone") String phone,@RequestParam("idNumber") String idNumber){
        return clientRegisterService.registerPhoneExists(phone,idNumber);
    }

    @RequestMapping("/abcd")
    public String abcd(HttpServletRequest request){
        System.out.println(request.getSession().getId());
        return "";
    }


    /**
     * 查询用户是否注册了工商银行
     * @param name
     * @param idCard
     * @param phone
     * @return
     */
    @RequestMapping("/selectClientRegister")
    public String selectClientRegister(@RequestParam("name") String name,@RequestParam("idCard") String idCard,@RequestParam("phone") String phone){
        return clientRegisterService.selectClientRegister(name,idCard,phone);
    }
}
