package com.example.jsproducerfund.dao;

import com.example.jsproducerfund.pojo.FundInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FundDao {

    List<FundInfo> findAll();

}
