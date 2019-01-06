package com.example.jsproducerfund.config;

import java.util.UUID;
import javax.annotation.PostConstruct;
import com.example.jsproducerfund.pojo.Buy;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender implements RabbitTemplate.ConfirmCallback, ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消息发送成功:" + correlationData);
        } else {
            System.out.println("消息发送失败:" + cause);
        }

    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println(message.getMessageProperties().getCorrelationId() + " 发送失败");
    }

    //发送消息，不需要实现任何接口，供外部调用。
    public void send(String msg){
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("开始发送消息 : " + msg.toLowerCase() + "\n");
        String response = rabbitTemplate.convertSendAndReceive("topicExchange", "key.1", msg, correlationId).toString();
        System.out.println("结束发送消息 : " + msg.toLowerCase() + "\n");
        System.out.println("消费者响应 : " + response + " 消息处理完成\n");
    }

    //消费明细传输
    public void send1(Buy buy){
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("开始发送消息 : " + buy.toString()  + "\n");
        String response = rabbitTemplate.convertSendAndReceive("topicExchange", "key.2", buy, correlationId).toString();
        System.out.println("结束发送消息 : " + buy.toString() + "\n");
        System.out.println("消费者响应 : " + response + " 消息处理完成\n");
    }

}