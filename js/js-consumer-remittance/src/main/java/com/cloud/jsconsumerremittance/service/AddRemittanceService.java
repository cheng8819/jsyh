package com.cloud.jsconsumerremittance.service;

import com.cloud.jsconsumerremittance.config.DalyConfig;
import com.cloud.jsconsumerremittance.feign.ToApplyDorRheRemittance;
import com.cloud.jsconsumerremittance.pojo.RemittanceTransaction;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddRemittanceService {
    @Autowired
    private RabbitTemplate amqpTemplate;
    @Autowired
    private ToApplyDorRheRemittance toApplyDorRheRemittance;
    public String ChooseTheRemittance(RemittanceTransaction remittanceTransaction){
        try {
            RemittanceTransaction remittanceTransaction1 = toApplyDorRheRemittance.addGeneralRemittance(remittanceTransaction);

        }catch (Exception e){
            System.err.println(e);

            return "提交失败";

        }
        switch (remittanceTransaction.getRemittancetransactionCurrent()){
            case "实时汇款":
                this.amqpTemplate.convertAndSend(DalyConfig.DEAD_EXCHANGE, DalyConfig.TICKETINFO_DEAD_KEY, remittanceTransaction, message -> {
                    message.getMessageProperties().setExpiration(0 + "");
                    return message;
                });
                break;
            case "普通汇款":
                this.amqpTemplate.convertAndSend(DalyConfig.DEAD_EXCHANGE, DalyConfig.TICKETINFO_DEAD_KEY, remittanceTransaction, message -> {
                    message.getMessageProperties().setExpiration(1000 * 60 * 60 * 2 + "");
                    return message;
                });
                break;
            case "次日汇款":
                this.amqpTemplate.convertAndSend(DalyConfig.DEAD_EXCHANGE, DalyConfig.TICKETINFO_DEAD_KEY, remittanceTransaction, message -> {
                    message.getMessageProperties().setExpiration(1000 * 60 * 60 * 24 + "");
                    return message;
                });
                break;
        }
        return "提交成功";
    }
}
