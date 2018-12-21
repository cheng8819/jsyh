package com.example.jsproducerloans;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class JsProducerLoansApplication {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ProcessEngine processEngine;

    public static void main(String[] args) {
        SpringApplication.run(JsProducerLoansApplication.class, args);
    }
}
