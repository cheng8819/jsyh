package com.example.demo2.dao;

import com.example.demo2.pojo.CardNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface deposit extends JpaRepository<CardNumber, Long> {
    public CardNumber findByCarenumbermarkAAndCarenumbername(String Carenumbermark, String Carenumbername);

}
