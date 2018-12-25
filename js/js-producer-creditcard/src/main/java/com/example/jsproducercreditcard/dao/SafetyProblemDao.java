package com.example.jsproducercreditcard.dao;

import com.example.jsproducercreditcard.entity.SafetyProblem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (SafetyProblem)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
@Mapper
@Repository
public interface SafetyProblemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param spid 主键
     * @return 实例对象
     */
    SafetyProblem queryById(Integer spid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SafetyProblem> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param safetyProblem 实例对象
     * @return 对象列表
     */
    List<SafetyProblem> queryAll(SafetyProblem safetyProblem);

    /**
     * 新增数据
     *
     * @param safetyProblem 实例对象
     * @return 影响行数
     */
    int insert(SafetyProblem safetyProblem);

    /**
     * 修改数据
     *
     * @param safetyProblem 实例对象
     * @return 影响行数
     */
    int update(SafetyProblem safetyProblem);

    /**
     * 通过主键删除数据
     *
     * @param spid 主键
     * @return 影响行数
     */
    int deleteById(Integer spid);

}