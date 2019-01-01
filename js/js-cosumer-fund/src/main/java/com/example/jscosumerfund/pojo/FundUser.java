package com.example.jscosumerfund.pojo;

import lombok.Data;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/19 19:31
 *
 * 基金开户申请表/基金用户开户信息
 */
@Data
public class FundUser {

    /**
     * 基金用户ID
     */
    private Integer user_id;

    /**
     * 基金用户姓名
     */
    private String username;

    /**
     * 基金用户性别
     */
    private String sex;

    /**
     * 基金用户出生日期
     */
    private String birthday;

    /**
     * 基金用户预留手机号
     */
    private String phone;

    /**
     *  职业
     */
    private String profession;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户证件类型
     */
    private String card_type;

    /**
     * 证件号码
     */
    private String card_number;

    /**
     * 用户承受风险等级
     */
    private String risk_grade;

    /**
     * 基金收益者
     */
    private String beneficial_owner;

    /**
     * 基金资金来源
     */
    private String capital_source;

    /**
     * 办理基金银行
     */
    private String bank_name;

    /**
     * 银行卡号
     */
    private String bankCardNumbers;

    /**
     * 发卡银行
     */
    private String bankNmae;

    /**
     * 基金账户
     */
    private String fundAccount;

    /**
     * 账户密码
     */
    private String password;

}
