package com.example.jsconsumerregister.jsconsumerregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableSwagger2
public class JsConsumerRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsConsumerRegisterApplication.class, args);
    }

}

