package com.cloud.jsproducerremittance.dao;

import com.cloud.jsproducerremittance.entity.RemittanceTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemittancetransactionDao extends JpaRepository<RemittanceTransaction, Long> {
}
