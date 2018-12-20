package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.RepaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepaymentTypeDao extends JpaRepository<RepaymentType, Integer> {
    RepaymentType findRepaymentTypeByRtid(Integer rtid);
}
