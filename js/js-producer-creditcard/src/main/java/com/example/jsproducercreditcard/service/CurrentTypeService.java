package com.example.jsproducercreditcard.service;

import com.example.jsproducercreditcard.entity.CurrentType;

import java.util.List;

/**
 * (CurrentType)表服务接口
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
public interface CurrentTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param ctid 主键
     * @return 实例对象
     */
    CurrentType queryById(Integer ctid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CurrentType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param currentType 实例对象
     * @return 实例对象
     */
    CurrentType insert(CurrentType currentType);

    /**
     * 修改数据
     *
     * @param currentType 实例对象
     * @return 实例对象
     */
    CurrentType update(CurrentType currentType);

    /**
     * 通过主键删除数据
     *
     * @param ctid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer ctid);

}