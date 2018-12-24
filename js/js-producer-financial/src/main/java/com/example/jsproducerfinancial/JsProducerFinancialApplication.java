package com.example.jsproducerfinancial;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.example.jsproducerfinancial")
@SpringBootApplication
@EnableDiscoveryClient
public class JsProducerFinancialApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsProducerFinancialApplication.class, args);
    }
}
