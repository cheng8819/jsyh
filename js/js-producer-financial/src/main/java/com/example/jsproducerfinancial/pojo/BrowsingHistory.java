package com.example.jsproducerfinancial.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/24 17:29
 */
@Data
public class BrowsingHistory {

    private Integer browsing_history_id;
    private String username;
    private String product_name;
    private String product_number;
    private String browsing_history_time;

    public BrowsingHistory(){}

    public BrowsingHistory(String username, String product_name, String product_number) {
        this.username = username;
        this.product_name = product_name;
        this.product_number = product_number;
        //时间戳
        this.browsing_history_time = String.valueOf(new Date());
    }

}
