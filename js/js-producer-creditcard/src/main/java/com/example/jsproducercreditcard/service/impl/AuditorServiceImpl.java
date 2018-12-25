package com.example.jsproducercreditcard.service.impl;

import com.example.jsproducercreditcard.entity.Auditor;
import com.example.jsproducercreditcard.dao.AuditorDao;
import com.example.jsproducercreditcard.service.AuditorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Auditor)表服务实现类
 *
 * @author makejava
 * @since 2018-12-25 17:44:17
 */
@Service("auditorService")
public class AuditorServiceImpl implements AuditorService {
    @Resource
    private AuditorDao auditorDao;

    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    @Override
    public Auditor queryById(Integer aid) {
        return this.auditorDao.queryById(aid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Auditor> queryAllByLimit(int offset, int limit) {
        return this.auditorDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param auditor 实例对象
     * @return 实例对象
     */
    @Override
    public Auditor insert(Auditor auditor) {
        this.auditorDao.insert(auditor);
        return auditor;
    }

    /**
     * 修改数据
     *
     * @param auditor 实例对象
     * @return 实例对象
     */
    @Override
    public Auditor update(Auditor auditor) {
        this.auditorDao.update(auditor);
        return this.queryById(auditor.getAid());
    }

    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer aid) {
        return this.auditorDao.deleteById(aid) > 0;
    }

    /**
     * 查询全部记录
     *
     * @return
     */
    @Override
    public List<Auditor> getAll() {
        return auditorDao.queryAll(new Auditor());
    }
}