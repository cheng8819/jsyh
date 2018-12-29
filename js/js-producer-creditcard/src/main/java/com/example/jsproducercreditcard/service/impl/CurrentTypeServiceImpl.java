package com.example.jsproducercreditcard.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducercreditcard.dao.CurrentTypeDao;
import com.example.jsproducercreditcard.entity.CurrentType;
import com.example.jsproducercreditcard.service.CurrentTypeService;
import com.example.jsproducercreditcard.util.Result;
import com.example.jsproducercreditcard.util.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CurrentType)表服务实现类
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
@Service("currentTypeService")
public class CurrentTypeServiceImpl implements CurrentTypeService {
    @Resource
    private CurrentTypeDao currentTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ctid 主键
     * @return 实例对象
     */
    @Override
    public Result queryById(Integer ctid) {
        return ResultUtil.success(JSON.toJSONString(currentTypeDao.queryById(ctid)));
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CurrentType> queryAllByLimit(int offset, int limit) {
        return this.currentTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param currentType 实例对象
     * @return 实例对象
     */
    @Override
    public CurrentType insert(CurrentType currentType) {
        this.currentTypeDao.insert(currentType);
        return currentType;
    }

    /**
     * 修改数据
     *
     * @param currentType 实例对象
     * @return 实例对象
     */
    @Override
    public Result update(CurrentType currentType) {
        this.currentTypeDao.update(currentType);
        return this.queryById(currentType.getCtid());
    }

    /**
     * 通过主键删除数据
     *
     * @param ctid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer ctid) {
        return this.currentTypeDao.deleteById(ctid) > 0;
    }

    /**
     * 获取全部卡类型
     *
     * @return
     */
    @Override
    public Result allCardTypes() {
        return ResultUtil.success(JSON.toJSONString(currentTypeDao.queryAll(new CurrentType())));
    }
}