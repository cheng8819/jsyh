package com.example.jsproducercreditcard.service;

import com.example.jsproducercreditcard.entity.CreditCard;

import java.util.List;

/**
 * (CreditCard)表服务接口
 *
 * @author makejava
 * @since 2018-12-25 12:36:01
 */
public interface CreditCardService {

    /**
     * 通过ID查询单条数据
     *
     * @param ccid 主键
     * @return 实例对象
     */
    CreditCard queryById(Integer ccid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CreditCard> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param creditCard 实例对象
     * @return 实例对象
     */
    CreditCard insert(CreditCard creditCard);

    /**
     * 修改数据
     *
     * @param creditCard 实例对象
     * @return 实例对象
     */
    CreditCard update(CreditCard creditCard);

    /**
     * 通过主键删除数据
     *
     * @param ccid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer ccid);

}