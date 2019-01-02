package com.cloud.jsconsumerremittance.service;

import com.cloud.jsconsumerremittance.config.DalyConfig;
import com.cloud.jsconsumerremittance.feign.Banking;
import com.cloud.jsconsumerremittance.feign.ToApplyDorRheRemittance;
import com.cloud.jsconsumerremittance.pojo.CardNumber;
import com.cloud.jsconsumerremittance.pojo.RemittanceTransaction;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;
import sun.rmi.transport.Channel;
@Service
public class SaveMoneyService {
    @Autowired
    private Banking banking;
    @Autowired
    private ToApplyDorRheRemittance toApplyDorRheRemittance;

    @RabbitListener(queues = {DalyConfig.TICKETINFO_USER_QUERY})
    public void ChooseABank(RemittanceTransaction remittanceTransaction, Message message, Channel channel){
        try {
            switch (remittanceTransaction.getRemittancetransactionBlank() + ""){
                case "1":
                    CardNumber show = banking.show(remittanceTransaction.getRemittancetransactionName(), remittanceTransaction.getRemittancetransactionCardnumber());
                    banking.update(show);
                    toApplyDorRheRemittance.updateState(remittanceTransaction);
                    break;
            }
        }catch (Exception e){

        }
    }
}
