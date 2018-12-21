package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.Auditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditorDao extends JpaRepository<Auditor,Integer> {
}
