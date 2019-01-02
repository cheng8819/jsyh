package com.cloud.jsproducerremittance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class DmSpringProducerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmSpringProducerServerApplication.class, args);
    }
}
