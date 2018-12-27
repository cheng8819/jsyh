package com.example.jsproducercreditcard.service;

import com.example.jsproducercreditcard.entity.CreditUserinfo;
import com.example.jsproducercreditcard.util.Result;

import java.util.List;

/**
 * (CreditUserinfo)表服务接口
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
public interface CreditUserinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param cuid 主键
     * @return 实例对象
     */
    CreditUserinfo queryById(String cuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CreditUserinfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param creditUserinfo 实例对象
     * @return 实例对象
     */
    CreditUserinfo insert(CreditUserinfo creditUserinfo);

    /**
     * 修改数据
     *
     * @param creditUserinfo 实例对象
     * @return 实例对象
     */
    CreditUserinfo update(CreditUserinfo creditUserinfo);

    /**
     * 通过主键删除数据
     *
     * @param cuid 主键
     * @return 是否成功
     */
    boolean deleteById(String cuid);

    /**
     * 根据用户ID查询用户申请单的记录
     * @param uid
     * @return
     */
    Result findCreditUserinfoByUid(Integer uid);
}