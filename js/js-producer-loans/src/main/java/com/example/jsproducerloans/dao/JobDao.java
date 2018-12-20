package com.example.jsproducerloans.dao;

import com.example.jsproducerloans.pojo.Job;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface JobDao extends MyMapper<Job> {
}
