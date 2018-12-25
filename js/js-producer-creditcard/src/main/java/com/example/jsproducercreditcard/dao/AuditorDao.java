package com.example.jsproducercreditcard.dao;

import com.example.jsproducercreditcard.entity.Auditor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Auditor)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-25 17:44:17
 */
@Mapper
@Repository
public interface AuditorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    Auditor queryById(Integer aid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Auditor> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param auditor 实例对象
     * @return 对象列表
     */
    List<Auditor> queryAll(Auditor auditor);

    /**
     * 新增数据
     *
     * @param auditor 实例对象
     * @return 影响行数
     */
    int insert(Auditor auditor);

    /**
     * 修改数据
     *
     * @param auditor 实例对象
     * @return 影响行数
     */
    int update(Auditor auditor);

    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 影响行数
     */
    int deleteById(Integer aid);

}