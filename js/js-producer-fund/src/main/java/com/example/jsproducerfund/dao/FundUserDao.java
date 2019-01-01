package com.example.jsproducerfund.dao;

import com.example.jsproducerfund.pojo.FundUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 基金用户操作
 */
@Mapper
@Repository
public interface FundUserDao {

    /**
     * 修改用户风险等级
     * @param risk_grade
     * @return
     */
    Integer updRiskGrade(@Param("risk_grade") String risk_grade, @Param("username") String name);

    /**
     * 添加基金账户
     * @param fundUser
     * @return
     */
    Integer addFundAccount(FundUser fundUser);

    /**
     * 删除基金账户
     * @param user_id
     * @return
     */
    Integer delFundAccount(Integer user_id);

}
