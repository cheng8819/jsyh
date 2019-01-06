package com.example.jsconsumerfinancial.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * 理财产品服务消费者
 */
public interface FinancialService {

    String buyFinancial(@RequestParam("financeName") String financeName,
                        @RequestParam("username") String username,
                        @RequestParam("money") Double money);

}
