package com.example.jsproducercreditcard.service.impl;

import com.example.jsproducercreditcard.dao.SafetyProblemDao;
import com.example.jsproducercreditcard.entity.SafetyProblem;
import com.example.jsproducercreditcard.service.SafetyProblemService;
import com.example.jsproducercreditcard.util.Result;
import com.example.jsproducercreditcard.util.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SafetyProblem)表服务实现类
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
@Service("safetyProblemService")
public class SafetyProblemServiceImpl implements SafetyProblemService {
    @Resource
    private SafetyProblemDao safetyProblemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param spid 主键
     * @return 实例对象
     */
    @Override
    public SafetyProblem queryById(Integer spid) {
        return this.safetyProblemDao.queryById(spid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SafetyProblem> queryAllByLimit(int offset, int limit) {
        return this.safetyProblemDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param safetyProblem 实例对象
     * @return 实例对象
     */
    @Override
    public SafetyProblem insert(SafetyProblem safetyProblem) {
        this.safetyProblemDao.insert(safetyProblem);
        return safetyProblem;
    }

    /**
     * 修改数据
     *
     * @param safetyProblem 实例对象
     * @return 实例对象
     */
    @Override
    public SafetyProblem update(SafetyProblem safetyProblem) {
        this.safetyProblemDao.update(safetyProblem);
        return this.queryById(safetyProblem.getSpid());
    }

    /**
     * 通过主键删除数据
     *
     * @param spid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer spid) {
        return this.safetyProblemDao.deleteById(spid) > 0;
    }

    /**
     * 获取全部的安全问题
     *
     * @return
     */
    @Override
    public Result allSafetyProblem() {
        return ResultUtil.success(safetyProblemDao.queryAll(new SafetyProblem()));
    }
}