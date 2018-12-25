package com.example.jsproducercreditcard.service;

import com.example.jsproducercreditcard.entity.HousingSituation;

import java.util.List;

/**
 * (HousingSituation)表服务接口
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
public interface HousingSituationService {

    /**
     * 通过ID查询单条数据
     *
     * @param hsid 主键
     * @return 实例对象
     */
    HousingSituation queryById(Integer hsid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HousingSituation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param housingSituation 实例对象
     * @return 实例对象
     */
    HousingSituation insert(HousingSituation housingSituation);

    /**
     * 修改数据
     *
     * @param housingSituation 实例对象
     * @return 实例对象
     */
    HousingSituation update(HousingSituation housingSituation);

    /**
     * 通过主键删除数据
     *
     * @param hsid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer hsid);

}