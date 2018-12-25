package com.example.jsproducercreditcard.service.impl;

import com.example.jsproducercreditcard.dao.HousingSituationDao;
import com.example.jsproducercreditcard.entity.HousingSituation;
import com.example.jsproducercreditcard.service.HousingSituationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HousingSituation)表服务实现类
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
@Service("housingSituationService")
public class HousingSituationServiceImpl implements HousingSituationService {
    @Resource
    private HousingSituationDao housingSituationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param hsid 主键
     * @return 实例对象
     */
    @Override
    public HousingSituation queryById(Integer hsid) {
        return this.housingSituationDao.queryById(hsid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<HousingSituation> queryAllByLimit(int offset, int limit) {
        return this.housingSituationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param housingSituation 实例对象
     * @return 实例对象
     */
    @Override
    public HousingSituation insert(HousingSituation housingSituation) {
        this.housingSituationDao.insert(housingSituation);
        return housingSituation;
    }

    /**
     * 修改数据
     *
     * @param housingSituation 实例对象
     * @return 实例对象
     */
    @Override
    public HousingSituation update(HousingSituation housingSituation) {
        this.housingSituationDao.update(housingSituation);
        return this.queryById(housingSituation.getHsid());
    }

    /**
     * 通过主键删除数据
     *
     * @param hsid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer hsid) {
        return this.housingSituationDao.deleteById(hsid) > 0;
    }
}