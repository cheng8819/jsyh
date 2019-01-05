package com.example.jsregisterprovider.jsproviderregister.dao;


import com.example.jsregisterprovider.jsproviderregister.pojo.Jsclientinfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Jsclientinfo)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-26 10:05:46
 */
public interface JsclientinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param jsClientid 主键
     * @return 实例对象
     */
    Jsclientinfo queryById(Integer jsClientid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Jsclientinfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param jsclientinfo 实例对象
     * @return 对象列表
     */
    List<Jsclientinfo> queryAll(Jsclientinfo jsclientinfo);

    /**
     * 新增数据
     *
     * @param jsclientinfo 实例对象
     * @return 影响行数
     */
    int insert(Jsclientinfo jsclientinfo);

    /**
     * 修改数据
     *
     * @param jsclientinfo 实例对象
     * @return 影响行数
     */
    int update(Jsclientinfo jsclientinfo);

    /**
     * 通过主键删除数据
     *
     * @param jsClientid 主键
     * @return 影响行数
     */
    int deleteById(Integer jsClientid);

}