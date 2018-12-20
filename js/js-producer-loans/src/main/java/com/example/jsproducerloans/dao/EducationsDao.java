package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.Education;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EducationsDao extends MyMapper<Education> {
}
