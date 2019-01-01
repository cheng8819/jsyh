package com.example.jsproducerfund.service;

public interface CollectService {

    /**
     * 基金收藏功能
     * @param fund_name 基金名称
     * @param fund_number 基金代码
     * @param username 用户名/真实姓名
     * @return
     */
    String collectFund(String fund_name,String fund_number,String username);

    /**
     * 查询收藏信息接口
     * @param username 可按用户名&基金代码准确定位收藏的基金
     * @return
     */
    String selCollection(String username);

}
