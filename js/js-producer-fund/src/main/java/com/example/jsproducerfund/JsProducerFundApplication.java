package com.example.jsproducerfund;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


@RestController
@MapperScan("com.example.jsproducerfund.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class JsProducerFundApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsProducerFundApplication.class, args);
    }

}
