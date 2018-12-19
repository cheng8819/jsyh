package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.LoansUserinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoansUserinfoDao extends MyMapper<LoansUserinfo> {
}
