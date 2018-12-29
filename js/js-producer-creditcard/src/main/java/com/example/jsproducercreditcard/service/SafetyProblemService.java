package com.example.jsproducercreditcard.service;

import com.example.jsproducercreditcard.entity.SafetyProblem;
import com.example.jsproducercreditcard.util.Result;

import java.util.List;

/**
 * (SafetyProblem)表服务接口
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
public interface SafetyProblemService {

    /**
     * 通过ID查询单条数据
     *
     * @param spid 主键
     * @return 实例对象
     */
    SafetyProblem queryById(Integer spid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SafetyProblem> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param safetyProblem 实例对象
     * @return 实例对象
     */
    SafetyProblem insert(SafetyProblem safetyProblem);

    /**
     * 修改数据
     *
     * @param safetyProblem 实例对象
     * @return 实例对象
     */
    SafetyProblem update(SafetyProblem safetyProblem);

    /**
     * 通过主键删除数据
     *
     * @param spid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer spid);

    /**
     * 获取全部的安全问题
     * @return
     */
    Result allSafetyProblem();
}