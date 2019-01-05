package com.example.jsregisterprovider.jsproviderregister.service;


import com.service.pojo.ClientRegister;
import com.service.pojo.ClientRegisterUser;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClientRegisterService {

    String clientRegister(ClientRegister clientRegister);


    /**
     * 用户手机号是否存在
     */
    String registerPhoneExists(String phone,String idNumber);

    /**
     * 添加网银用户
     */
    String addInternetUser(@RequestBody ClientRegisterUser clientRegisterUser);

    /**
     * 查询用户是否已注册
     */
    String selectClientRegister(String name,String idCard,String phone);
}
