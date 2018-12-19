package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.LoansType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoansTypeDao extends MyMapper<LoansType> {
}
