package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.LoansUserinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoansUserinfoDao extends JpaRepository<LoansUserinfo, String> {
    LoansUserinfo findLoansUserinfoByLuid(String luid);
}
