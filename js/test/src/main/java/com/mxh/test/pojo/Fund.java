package com.mxh.test.pojo;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/23 18:36
 */
public class Fund {

    private String fund_name;
    private String fund_number;
    private Double iopy;
    private Double iopys;

    public Fund(){};

    public Fund(String fund_name, String fund_number, Double iopy, Double iopys) {
        this.fund_name = fund_name;
        this.fund_number = fund_number;
        this.iopy = iopy;
        this.iopys = iopys;
    }

    public String getFund_name() {
        return fund_name;
    }

    public void setFund_name(String fund_name) {
        this.fund_name = fund_name;
    }

    public String getFund_number() {
        return fund_number;
    }

    public void setFund_number(String fund_number) {
        this.fund_number = fund_number;
    }

    public Double getIopy() {
        return iopy;
    }

    public void setIopy(Double iopy) {
        this.iopy = iopy;
    }

    public Double getIopys() {
        return iopys;
    }

    public void setIopys(Double iopys) {
        this.iopys = iopys;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "fund_name='" + fund_name + '\'' +
                ", fund_number='" + fund_number + '\'' +
                ", iopy=" + iopy +
                ", iopys=" + iopys +
                '}';
    }
}
