package com.cloud.jsconsumerremittance.service;

import com.cloud.jsconsumerremittance.config.DalyConfig;
import com.cloud.jsconsumerremittance.pojo.RemittanceTransaction;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;
import sun.rmi.transport.Channel;
@Service
public class SaveMoneyService {
    @RabbitListener(queues = {DalyConfig.TICKETINFO_USER_QUERY})
    public void ChooseABank(RemittanceTransaction remittanceTransaction, Message message, Channel channel){
        switch (remittanceTransaction.getRemittancetransactionBlank() + ""){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                break;
            case "9":
                break;
            case "10":
                break;
        }


    }
}
