package com.cloud.jsproducerremittance.dao;

import com.cloud.jsproducerremittance.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchDao extends JpaRepository<Batch, Long> {
}
