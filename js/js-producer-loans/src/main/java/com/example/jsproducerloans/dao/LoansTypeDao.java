package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.Loantype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoansTypeDao extends JpaRepository<Loantype, Integer> {
}
