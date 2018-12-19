package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.RepaymentType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RepaymentTypeDao extends MyMapper<RepaymentType> {
}
