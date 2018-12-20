package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.LoansPeoples;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoansPeoplesDao extends JpaRepository<LoansPeoples, Integer> {
    LoansPeoples findLoansPeoplesByLpid(Integer lpid);
}
