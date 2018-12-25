package com.example.jsproducercreditcard.service;

import com.example.jsproducercreditcard.entity.CurrentAddress;

import java.util.List;

/**
 * (CurrentAddress)表服务接口
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
public interface CurrentAddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param caid 主键
     * @return 实例对象
     */
    CurrentAddress queryById(Integer caid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CurrentAddress> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param currentAddress 实例对象
     * @return 实例对象
     */
    CurrentAddress insert(CurrentAddress currentAddress);

    /**
     * 修改数据
     *
     * @param currentAddress 实例对象
     * @return 实例对象
     */
    CurrentAddress update(CurrentAddress currentAddress);

    /**
     * 通过主键删除数据
     *
     * @param caid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer caid);

}