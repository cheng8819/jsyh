package com.example.jsproducercreditcard.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducercreditcard.dao.CreditUserinfoDao;
import com.example.jsproducercreditcard.entity.CreditUserinfo;
import com.example.jsproducercreditcard.service.CreditUserinfoService;
import com.example.jsproducercreditcard.util.Result;
import com.example.jsproducercreditcard.util.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CreditUserinfo)表服务实现类
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
@Service("creditUserinfoService")
public class CreditUserinfoServiceImpl implements CreditUserinfoService {
    @Resource
    private CreditUserinfoDao creditUserinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cuid 主键
     * @return 实例对象
     */
    @Override
    public CreditUserinfo queryById(String cuid) {
        return this.creditUserinfoDao.queryById(cuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CreditUserinfo> queryAllByLimit(int offset, int limit) {
        return this.creditUserinfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param creditUserinfo 实例对象
     * @return 实例对象
     */
    @Override
    public CreditUserinfo insert(CreditUserinfo creditUserinfo) {
        this.creditUserinfoDao.insert(creditUserinfo);
        return creditUserinfo;
    }

    /**
     * 修改数据
     *
     * @param creditUserinfo 实例对象
     * @return 实例对象
     */
    @Override
    public CreditUserinfo update(CreditUserinfo creditUserinfo) {
        this.creditUserinfoDao.update(creditUserinfo);
        return this.queryById(creditUserinfo.getCuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param cuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String cuid) {
        return this.creditUserinfoDao.deleteById(cuid) > 0;
    }

    /**
     * 根据用户ID查询用户申请单的记录
     *
     * @param uid
     * @return
     */
    @Override
    public Result findCreditUserinfoByUid(Integer uid) {
        CreditUserinfo creditUserinfo = new CreditUserinfo();
        creditUserinfo.setCuuid(uid);
        return ResultUtil.success(JSON.toJSONString(creditUserinfoDao.queryAll(creditUserinfo)));
    }
}