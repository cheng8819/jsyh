package com.example.jsdengluprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.example.jsdengluprovider.*")
public class JsDengluProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(JsDengluProviderApplication.class, args);
    }
}
