package com.example.jsproducerfund.dao;

import com.example.jsproducerfund.pojo.CollectInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/1 16:22
 *
 * 基金信息收藏
 */
@Mapper
@Repository
public interface CollectDao {

    /**
     * 添加收藏信息
     * @param collection 收藏信息
     * @return
     */
    Integer addCollection(CollectInfo collection);

    /**
     * 查询收藏信息
     * @param collection 查询条件
     * @return
     */
    List<CollectInfo> selCollection(CollectInfo collection);

    /**
     * 根据DI删除收藏信息
     * @param collection_id
     * @return
     */
    Integer delCollection(Integer collection_id);

}
