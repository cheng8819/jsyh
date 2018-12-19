package com.cloud.jsconsumerremittance.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DalyConfig {

    //死信队列
    public final static String TI_DEAD_QUERY="ti-dead-query";
    public final static String BA_DEAD_QUERY="ba-dead-query";

    //死信交换机
    public final static String DEAD_EXCHANGE="dead-exchange";

    //死信队列路由键 将删除的消息推送到指定交换机的指定路由键指定的队列中
    public final static String BANNERINFO_DEAD_KEY="bannerinfo-dead-key";
    //死信队列路由键 将删除的消息推送到指定交换机的指定路由键指定的队列中
    public final static String TICKETINFO_DEAD_KEY="ticketinfo-dead-key";

    //用户交换机
    public final static String BA_USER_EXCHANGE="ba-user-exchange";
    //用户交换机
    public final static String TI_USER_EXCHANGE="ti-user-exchange";

    //用户队列
    public final static String BANNERINFO_USER_QUERY="bannerinfo-user-query";

    //用户队列
    public final static String TICKETINFO_USER_QUERY="ticketinfo-user-query";


    //配置延时队列
    @Bean
    public Queue bidalyQuery(){

        Map<String,Object> map= new HashMap<>();
        map.put("x-dead-letter-exchange",BA_USER_EXCHANGE);
        map.put("x-dead-letter-routing-key",BANNERINFO_DEAD_KEY);
        /**
         * name:队列名字
         * durable：是否持久化
         * exclusive:该消息队列是否只在当前connnection生效 默认是false 在哪里都生效
         * autoDelete:消息消费完了 是否 删除该队列 默认不删
         */
        return new Queue(BA_DEAD_QUERY,true,false,false,map);
    }
    @Bean
    public Queue tidalyQuery(){

        Map<String,Object> map= new HashMap<>();
        map.put("x-dead-letter-exchange",TI_USER_EXCHANGE);
        map.put("x-dead-letter-routing-key",TICKETINFO_DEAD_KEY);
        /**
         * name:队列名字
         * durable：是否持久化
         * exclusive:该消息队列是否只在当前connnection生效 默认是false 在哪里都生效
         * autoDelete:消息消费完了 是否 删除该队列 默认不删
         */
        return new Queue(TI_DEAD_QUERY,true,false,false,map);
    }


    //配置延时交换机
    @Bean
    public DirectExchange dalyExchange(){
        return new DirectExchange(DEAD_EXCHANGE,true,false);
    }

    //延时交换机和延时队列绑定
    @Bean
    public Binding BIdalyQueryAndExchange(){
        //延时绑定
        return BindingBuilder.bind(bidalyQuery()).to(dalyExchange()).with(BANNERINFO_DEAD_KEY);
    }
    @Bean
    public Binding TIdalyQueryAndExchange(){
        //延时绑定
        return BindingBuilder.bind(tidalyQuery()).to(dalyExchange()).with(TICKETINFO_DEAD_KEY);
    }
    //定义用户队列
    @Bean
    public Queue ticketinfouserQueue(){
        return  new Queue(TICKETINFO_USER_QUERY,true,false,false);
    }
    @Bean
    public Queue bannerinfouserQueue(){
        return  new Queue(BANNERINFO_USER_QUERY,true,false,false);
    }

    //创建用户交换机
    @Bean
    public TopicExchange tiUserExchange(){
        return new TopicExchange(TI_USER_EXCHANGE,true,false);
    }
    //创建用户交换机
    @Bean
    public TopicExchange baUserExchange(){
        return new TopicExchange(BA_USER_EXCHANGE,true,false);
    }

    //用户队列和用户交换机绑定
    @Bean
    public Binding ticketinfouserBinding(){
        return BindingBuilder.bind(ticketinfouserQueue()).to(baUserExchange()).with(BANNERINFO_DEAD_KEY);
    }
    @Bean
    public Binding bannerinfouserBinding(){
        return BindingBuilder.bind(bannerinfouserQueue()).to(tiUserExchange()).with(TICKETINFO_DEAD_KEY);
    }



}
