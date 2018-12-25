package com.example.jsproducercreditcard.dao;

import com.example.jsproducercreditcard.entity.Safety;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Safety)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
@Mapper
@Repository
public interface SafetyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    Safety queryById(Integer sid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Safety> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param safety 实例对象
     * @return 对象列表
     */
    List<Safety> queryAll(Safety safety);

    /**
     * 新增数据
     *
     * @param safety 实例对象
     * @return 影响行数
     */
    int insert(Safety safety);

    /**
     * 修改数据
     *
     * @param safety 实例对象
     * @return 影响行数
     */
    int update(Safety safety);

    /**
     * 通过主键删除数据
     *
     * @param sid 主键
     * @return 影响行数
     */
    int deleteById(Integer sid);

}