package com.example.jscosumerfund.service;

import com.example.jscosumerfund.service.Impl.ManagementServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 银行账户管理服务
 */
@FeignClient(value = "js-producer-management",fallback = ManagementServiceImpl.class)
public interface ManagementService {

    /**
     * 查银行卡号：
     *
     * @param idnumber 身份证号
     * @return 银行卡号/查不到
     */
    @RequestMapping(value ="/card/idnumberSelectCardnumber")
    String idnumberSelectCardnumber(@RequestParam("idnumber") String idnumber);

    /**
     * 查余额：
     *
     * @param cardnumber 银行卡号
     * @return 余额
     */
    @RequestMapping(value ="/card/selectBalance")
    Double selectBalance(@RequestParam("cardnumber") String cardnumber);

    /**
     * 加余额：
     *
     * @param cardnumber 银行卡号
     * @param core        交易金额
     * @param type        交易类型
     * @return
     */
    @RequestMapping(value ="/card/deposit" )
    boolean deposit(@RequestParam("cardnumber") String cardnumber,
                    @RequestParam("core") Double core,
                    @RequestParam("type") String type);

    /**
     * 减余额：
     *
     * @param cardnumber 银行卡号
     * @param core        交易金额
     * @param type        交易类型
     * @return
     */
    @RequestMapping(value ="/card/remittance")
    boolean remittance(@RequestParam("cardnumber") String cardnumber,
                       @RequestParam("core") Double core,
                       @RequestParam("type") String type);

    /**
     * 查银行卡状态：
     *
     * @param cardnumber 银行卡号
     * @return “正常”、“挂失”、“冻结”
     */
    @RequestMapping(value ="/card/cardnumberSelectState")
    public String cardnumberSelectState(@RequestParam("cardnumber") String cardnumber);

}
