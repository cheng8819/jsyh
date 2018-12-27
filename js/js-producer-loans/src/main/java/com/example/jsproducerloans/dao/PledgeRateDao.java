package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.PledgeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PledgeRateDao extends JpaRepository<PledgeRate,Integer> {
    PledgeRate findPledgeRateeByLpid(Integer lpid);
}
