package com.example.jsproducercreditcard.dao;

import com.example.jsproducercreditcard.entity.LeaveInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (LeaveInfo)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-25 16:36:53
 */
@Mapper
@Repository
public interface LeaveInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LeaveInfo queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LeaveInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param leaveInfo 实例对象
     * @return 对象列表
     */
    List<LeaveInfo> queryAll(LeaveInfo leaveInfo);

    /**
     * 新增数据
     *
     * @param leaveInfo 实例对象
     * @return 影响行数
     */
    int insert(LeaveInfo leaveInfo);

    /**
     * 修改数据
     *
     * @param leaveInfo 实例对象
     * @return 影响行数
     */
    int update(LeaveInfo leaveInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}