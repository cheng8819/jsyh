package com.example.jsconsumerfinancial.service;

import com.example.jsconsumerfinancial.service.Impl.ManagementServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 银行账户管理服务
 */
@FeignClient(value = "js-producer-fund",fallback = ManagementServiceImpl.class)
public interface ManagementService {

    /**
     * 查银行卡号：
     * 参数依次填入（idnumber身份证号）。
     * 去孙科凡那里拿身份证号
     * 结果直接返回的是（银行卡号）字符串，查不到银行卡会返回字符串“查不到”。
     * @param idnumber
     * @return
     */
    @RequestMapping(value ="/idnumberSelectCardnumber" )
    public String idnumberSelectCardnumber(String idnumber);

    /**
     * 查余额：
     *      参数依次填入（cardnumber银行卡号）
     *      结果直接返回的是（余额）金额。
     * @param cardnumber
     * @return
     */
    @RequestMapping(value ="/selectBalance" )
    public Double selectBalance(String cardnumber);

    /**
     * 加余额：
     *      参数依次填入（cardnumber银行卡号、core交易金额、type交易类型）。
     *      注：交易类型type填写的是自定义字符串
     *      （如：购买基金、购买保险、存款、汇款......等）
     *      结果直接返回的是 （true）或者（false）。
     * @param cardnumber
     * @param core
     * @param type
     * @return
     */
    @RequestMapping(value ="/deposit" )
    public boolean deposit(String cardnumber, Double core, String type);

    /**
     * 减余额：
     *      参数依次填入（cardnumber银行卡号、core交易金额、type交易类型）。
     *      注：交易类型type填写的是自定义字符串
     *      （如：购买基金、购买保险、存款、汇款......等）
     *      结果直接返回的是 （true）或者（false）。
     * @param cardnumber
     * @param core
     * @param type
     * @return
     */
    @RequestMapping(value ="/remittance" )
    public boolean remittance(String cardnumber, Double core, String type);

    /**
     * 查银行卡状态：
     *      参数依次填入（（cardnumber银行卡号）
     *      结果直接返回的是 “正常”、“挂失”、“冻结”三种状态字符串。
     * @param cardnumber
     * @return
     */
    @RequestMapping(value ="/cardnumberSelectState" )
    public String cardnumberSelectState(String cardnumber);

}
