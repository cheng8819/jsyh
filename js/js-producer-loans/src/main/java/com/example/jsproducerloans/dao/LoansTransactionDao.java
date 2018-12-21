package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.LoansTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansTransactionDao extends JpaRepository<LoansTransaction, Integer> {
    List<LoansTransaction> findLoansTransactionsByLiuidAndListate(Integer liuid,Integer state);
    LoansTransaction findLoansTransactionsByLiid(Integer liid);
    List<LoansTransaction> findLoansTransactionsByLiuidAndLitypeAndListate(Integer uid,Integer type,Integer state);
    LoansTransaction findLoansTransactionsByLiapplicationdata(Integer liid);
}
