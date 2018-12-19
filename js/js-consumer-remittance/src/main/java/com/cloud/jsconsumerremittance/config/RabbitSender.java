package com.cloud.jsconsumerremittance.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendSeckillOrderQueue(String message) {
        this.amqpTemplate.convertAndSend(RabbitConfig.QUEUE_SECKILL_ORDER, message);
    }
}
