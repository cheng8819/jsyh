package com.example.jsproducercreditcard.service;

import com.example.jsproducercreditcard.entity.LeaveInfo;
import java.util.List;

/**
 * (LeaveInfo)表服务接口
 *
 * @author makejava
 * @since 2018-12-25 16:36:53
 */
public interface LeaveInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LeaveInfo queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LeaveInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param leaveInfo 实例对象
     * @return 实例对象
     */
    LeaveInfo insert(LeaveInfo leaveInfo);

    /**
     * 修改数据
     *
     * @param leaveInfo 实例对象
     * @return 实例对象
     */
    LeaveInfo update(LeaveInfo leaveInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}