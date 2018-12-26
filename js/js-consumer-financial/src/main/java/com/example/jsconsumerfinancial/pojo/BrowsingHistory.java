package com.example.jsconsumerfinancial.pojo;

import java.util.Date;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/24 17:29
 */
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

    public Integer getBrowsing_history_id() {
        return browsing_history_id;
    }

    public void setBrowsing_history_id(Integer browsing_history_id) {
        this.browsing_history_id = browsing_history_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_number() {
        return product_number;
    }

    public void setProduct_number(String product_number) {
        this.product_number = product_number;
    }

    public String getBrowsing_history_time() {
        return browsing_history_time;
    }

    public void setBrowsing_history_time(String browsing_history_time) {
        this.browsing_history_time = browsing_history_time;
    }
}
