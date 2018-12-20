package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationsDao extends JpaRepository<Education, Integer> {
    Education findEducationByEid(Integer eid);
}
