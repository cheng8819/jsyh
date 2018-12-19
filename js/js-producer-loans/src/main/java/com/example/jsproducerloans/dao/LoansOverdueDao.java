package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.LoansOverdue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoansOverdueDao extends MyMapper<LoansOverdue> {
}
