package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.LoansOverdue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansOverdueDao extends JpaRepository<LoansOverdue, Integer> {
    List<LoansOverdue> findLoansOverduesByLoidAndUid(Integer loid,Integer uid);
}
