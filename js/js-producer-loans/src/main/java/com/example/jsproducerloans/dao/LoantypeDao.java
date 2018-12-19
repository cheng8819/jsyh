package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.Loantype;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoantypeDao extends MyMapper<Loantype> {
}
