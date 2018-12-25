package com.example.jsproducercreditcard.service.impl;

import com.example.jsproducercreditcard.dao.SafetyDao;
import com.example.jsproducercreditcard.entity.Safety;
import com.example.jsproducercreditcard.service.SafetyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Safety)表服务实现类
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
@Service("safetyService")
public class SafetyServiceImpl implements SafetyService {
    @Resource
    private SafetyDao safetyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    @Override
    public Safety queryById(Integer sid) {
        return this.safetyDao.queryById(sid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Safety> queryAllByLimit(int offset, int limit) {
        return this.safetyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param safety 实例对象
     * @return 实例对象
     */
    @Override
    public Safety insert(Safety safety) {
        this.safetyDao.insert(safety);
        return safety;
    }

    /**
     * 修改数据
     *
     * @param safety 实例对象
     * @return 实例对象
     */
    @Override
    public Safety update(Safety safety) {
        this.safetyDao.update(safety);
        return this.queryById(safety.getSid());
    }

    /**
     * 通过主键删除数据
     *
     * @param sid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sid) {
        return this.safetyDao.deleteById(sid) > 0;
    }
}