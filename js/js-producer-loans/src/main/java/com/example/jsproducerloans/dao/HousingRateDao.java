package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.HousingRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingRateDao extends JpaRepository<HousingRate,Integer> {
    HousingRate findHousingRateByLrid(Integer lird);
}
