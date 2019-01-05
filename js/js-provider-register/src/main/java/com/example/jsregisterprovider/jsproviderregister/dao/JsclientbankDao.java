package com.example.jsregisterprovider.jsproviderregister.dao;

import com.example.jsregisterprovider.jsproviderregister.pojo.Jsclientbank;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Jsclientbank)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-26 10:05:45
 */
public interface JsclientbankDao {

    /**
     * 通过ID查询单条数据
     *
     * @param jsBanknumber 主键
     * @return 实例对象
     */
    Jsclientbank queryById(String jsBanknumber);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Jsclientbank> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param jsclientbank 实例对象
     * @return 对象列表
     */
    List<Jsclientbank> queryAll(Jsclientbank jsclientbank);

    /**
     * 新增数据
     *
     * @param jsclientbank 实例对象
     * @return 影响行数
     */
    int insert(Jsclientbank jsclientbank);

    /**
     * 修改数据
     *
     * @param jsclientbank 实例对象
     * @return 影响行数
     */
    int update(Jsclientbank jsclientbank);

    /**
     * 通过主键删除数据
     *
     * @param jsBanknumber 主键
     * @return 影响行数
     */
    int deleteById(String jsBanknumber);

}