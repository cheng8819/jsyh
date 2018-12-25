package com.example.jsproducercreditcard.service;

import com.example.jsproducercreditcard.entity.Safety;

import java.util.List;

/**
 * (Safety)表服务接口
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
public interface SafetyService {

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    Safety queryById(Integer sid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Safety> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param safety 实例对象
     * @return 实例对象
     */
    Safety insert(Safety safety);

    /**
     * 修改数据
     *
     * @param safety 实例对象
     * @return 实例对象
     */
    Safety update(Safety safety);

    /**
     * 通过主键删除数据
     *
     * @param sid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sid);

}