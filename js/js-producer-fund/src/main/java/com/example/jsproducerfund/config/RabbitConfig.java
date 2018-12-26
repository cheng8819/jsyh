package com.example.jsproducerfund.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author  666先生的救赎
 * @date 2018年12月23日 21:05
 */
@Configuration
public class RabbitConfig {

    //声明队列
    @Bean
    public Queue queue1() {
        return new Queue("hello.queue1", true);
        // true表示持久化该队列
    }

    @Bean
    public Queue queue2() {
        return new Queue("hello.queue2", true);
    }

    //声明交互器
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    //绑定
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("key.1");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.2");
    }

}