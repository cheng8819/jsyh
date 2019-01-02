package com.example.demo2.dao;


import com.example.demo2.pojo.CardNumber;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface depositDao extends JpaRepository<CardNumber, Long> {
    public CardNumber findByCarenumbernameAndCarenumbermark(String carenumbername,String carenumbermark);
    @Modifying
    @Query(value = "update cardnumber set money =money+ ?  where cardnumberid=?",nativeQuery = true)
    public void update(Integer id, Double money);

}
