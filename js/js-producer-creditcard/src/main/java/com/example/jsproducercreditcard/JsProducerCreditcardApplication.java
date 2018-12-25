package com.example.jsproducercreditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JsProducerCreditcardApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsProducerCreditcardApplication.class, args);
    }
}
