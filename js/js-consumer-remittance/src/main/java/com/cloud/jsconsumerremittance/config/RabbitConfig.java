package com.cloud.jsconsumerremittance.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    static final String QUEUE_SECKILL_ORDER = "Queue_Seckill_Order";//发送秒杀订单队列
    static final String QUEUE_SECKILL_LOSER = "Queue_Seckill_Loser";//接收秒杀订单失败队列
    static final String QUEUE_KILL_REDIS = "Queue_kill_redis";//接收发送redis减库存队列
    @Bean
    public Queue seckillOrderQueue(){
        return new Queue(QUEUE_SECKILL_ORDER);
    }

    @Bean
    public Queue seckillLoserQueue(){
        return new Queue(QUEUE_SECKILL_LOSER);
    }
}
