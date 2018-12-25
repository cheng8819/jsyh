package com.example.jsproducerfund.pojo;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 16:09
 *
 * 基金收藏信息类
 */
public class CollectInfo {

    private Integer collection_id;

    private String fund_name;

    private String username;

    private String fund_number;

    public CollectInfo(){}

    public Integer getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(Integer collection_id) {
        this.collection_id = collection_id;
    }

    public String getFund_name() {
        return fund_name;
    }

    public void setFund_name(String fund_name) {
        this.fund_name = fund_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFund_number() {
        return fund_number;
    }

    public void setFund_number(String fund_number) {
        this.fund_number = fund_number;
    }

    @Override
    public String toString() {
        return "CollectInfo{" +
                "collection_id=" + collection_id +
                ", fund_name='" + fund_name + '\'' +
                ", username='" + username + '\'' +
                ", fund_number='" + fund_number + '\'' +
                '}';
    }
}
