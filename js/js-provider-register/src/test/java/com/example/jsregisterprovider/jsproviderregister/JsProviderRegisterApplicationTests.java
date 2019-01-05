package com.example.jsregisterprovider.jsproviderregister;

import com.alibaba.fastjson.JSON;
import com.example.jsregisterprovider.jsproviderregister.util.IdentityCardUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsProviderRegisterApplicationTests {

    @Test
    public void contextLoads() {
        int code = (int)(Math.random() * (400000000 -100000000)) + 100000000; // 产生1000-9999之间的一个随机数
        String codestr = String.valueOf(code);
        System.out.println(code);
        Map<String, String> birAgeSex = IdentityCardUtil.getBirAgeSex("140423199611160010");
        String sexCode = birAgeSex.get("sexCode");
        System.out.println(sexCode);
    }

}

