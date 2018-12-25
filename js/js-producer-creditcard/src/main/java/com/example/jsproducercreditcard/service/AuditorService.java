package com.example.jsproducercreditcard.service;

import com.example.jsproducercreditcard.entity.Auditor;
import java.util.List;

/**
 * (Auditor)表服务接口
 *
 * @author makejava
 * @since 2018-12-25 17:44:17
 */
public interface AuditorService {

    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    Auditor queryById(Integer aid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Auditor> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param auditor 实例对象
     * @return 实例对象
     */
    Auditor insert(Auditor auditor);

    /**
     * 修改数据
     *
     * @param auditor 实例对象
     * @return 实例对象
     */
    Auditor update(Auditor auditor);

    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer aid);

    /**
     * 查询全部记录
     * @return
     */
    List<Auditor> getAll();
}