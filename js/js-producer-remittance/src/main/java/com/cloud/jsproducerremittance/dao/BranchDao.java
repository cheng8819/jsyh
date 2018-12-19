package com.cloud.jsproducerremittance.dao;

import com.cloud.jsproducerremittance.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchDao extends JpaRepository<Branch,Long> {
}
