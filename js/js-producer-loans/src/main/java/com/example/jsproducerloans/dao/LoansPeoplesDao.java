package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.LoansPeoples;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoansPeoplesDao extends MyMapper<LoansPeoples> {
}
