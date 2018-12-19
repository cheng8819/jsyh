package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.LoansTransaction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoansTransactionDao extends MyMapper<LoansTransaction> {
}
