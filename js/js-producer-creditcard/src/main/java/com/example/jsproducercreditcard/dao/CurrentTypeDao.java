package com.example.jsproducercreditcard.dao;

import com.example.jsproducercreditcard.entity.CurrentType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (CurrentType)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
@Mapper
@Repository
public interface CurrentTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param ctid 主键
     * @return 实例对象
     */
    CurrentType queryById(Integer ctid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CurrentType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param currentType 实例对象
     * @return 对象列表
     */
    List<CurrentType> queryAll(CurrentType currentType);

    /**
     * 新增数据
     *
     * @param currentType 实例对象
     * @return 影响行数
     */
    int insert(CurrentType currentType);

    /**
     * 修改数据
     *
     * @param currentType 实例对象
     * @return 影响行数
     */
    int update(CurrentType currentType);

    /**
     * 通过主键删除数据
     *
     * @param ctid 主键
     * @return 影响行数
     */
    int deleteById(Integer ctid);

}