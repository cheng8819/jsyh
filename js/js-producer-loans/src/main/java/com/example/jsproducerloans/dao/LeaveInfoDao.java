package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.LeaveInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveInfoDao extends JpaRepository<LeaveInfo, String> {
}
