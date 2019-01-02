package com.cloud.jsconsumerremittance.service;

import com.cloud.jsconsumerremittance.config.DalyConfig;
import com.cloud.jsconsumerremittance.feign.ToApplyDorRheRemittance;
import com.cloud.jsconsumerremittance.feign.AccountInformation;
import com.cloud.jsconsumerremittance.feign.Banking;
import com.cloud.jsconsumerremittance.pojo.CardNumber;
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
    @Autowired
    private AccountInformation accountInformation;
    @Autowired
    private Banking banking;
    boolean remittance;
    public String ChooseTheRemittance(RemittanceTransaction remittanceTransaction){
        Double  balance = accountInformation.selectBalance(remittanceTransaction.getRemittancetransactionCurrent());
        if (balance >= remittanceTransaction.getRemittancetransactionPrice() + remittanceTransaction.getRemittancetransactionPrice() * 0.001 ){
            try {
                toApplyDorRheRemittance.addGeneralRemittance(remittanceTransaction);
                boolean remittance = accountInformation.remittance(remittanceTransaction.getRemittancetransactionCurrent(), remittanceTransaction.getRemittancetransactionPrice(), "汇款");

            }catch (Exception e){
                System.err.println(e);

                return "提交失败";
            }
            if (remittance){
                CardNumber show = banking.show(remittanceTransaction.getRemittancetransactionName(), remittanceTransaction.getRemittancetransactionCardnumber());
                if (show != null){
                    switch (remittanceTransaction.getRemittancetransactionCurrent()){
                        case "实时汇款":
                            this.amqpTemplate.convertAndSend(DalyConfig.DEAD_EXCHANGE, DalyConfig.TICKETINFO_DEAD_KEY, show, message -> {
                                message.getMessageProperties().setExpiration(0 + "");
                                return message;
                            });
                            break;
                        case "普通汇款":
                            this.amqpTemplate.convertAndSend(DalyConfig.DEAD_EXCHANGE, DalyConfig.TICKETINFO_DEAD_KEY, show, message -> {
                                message.getMessageProperties().setExpiration(1000 * 60 * 60 * 2 + "");
                                return message;
                            });
                            break;
                        case "次日汇款":
                            this.amqpTemplate.convertAndSend(DalyConfig.DEAD_EXCHANGE, DalyConfig.TICKETINFO_DEAD_KEY, show, message -> {
                                message.getMessageProperties().setExpiration(1000 * 60 * 60 * 24 + "");
                                return message;
                            });
                            break;
                    }
                }else {
                    return "用户不存在";
                }

            }else {
                return "余额不足";
            }
        }


        return "提交成功";
    }
}
