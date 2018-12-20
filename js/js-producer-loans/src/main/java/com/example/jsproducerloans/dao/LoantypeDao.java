package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.Loantype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoantypeDao extends JpaRepository<Loantype, Integer> {
}
