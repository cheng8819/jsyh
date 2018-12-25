package com.example.jsproducercreditcard.dao;

import com.example.jsproducercreditcard.entity.CreditUserinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (CreditUserinfo)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
@Mapper
@Repository
public interface CreditUserinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cuid 主键
     * @return 实例对象
     */
    CreditUserinfo queryById(Integer cuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CreditUserinfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param creditUserinfo 实例对象
     * @return 对象列表
     */
    List<CreditUserinfo> queryAll(CreditUserinfo creditUserinfo);

    /**
     * 新增数据
     *
     * @param creditUserinfo 实例对象
     * @return 影响行数
     */
    int insert(CreditUserinfo creditUserinfo);

    /**
     * 修改数据
     *
     * @param creditUserinfo 实例对象
     * @return 影响行数
     */
    int update(CreditUserinfo creditUserinfo);

    /**
     * 通过主键删除数据
     *
     * @param cuid 主键
     * @return 影响行数
     */
    int deleteById(Integer cuid);

}