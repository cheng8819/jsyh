package com.example.jsproducercreditcard.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducercreditcard.entity.LeaveInfo;
import com.example.jsproducercreditcard.dao.LeaveInfoDao;
import com.example.jsproducercreditcard.service.LeaveInfoService;
import com.example.jsproducercreditcard.util.Result;
import com.example.jsproducercreditcard.util.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LeaveInfo)表服务实现类
 *
 * @author makejava
 * @since 2018-12-25 16:36:53
 */
@Service("leaveInfoService")
public class LeaveInfoServiceImpl implements LeaveInfoService {
    @Resource
    private LeaveInfoDao leaveInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LeaveInfo queryById(String id) {
        return this.leaveInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<LeaveInfo> queryAllByLimit(int offset, int limit) {
        return this.leaveInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param leaveInfo 实例对象
     * @return 实例对象
     */
    @Override
    public LeaveInfo insert(LeaveInfo leaveInfo) {
        this.leaveInfoDao.insert(leaveInfo);
        return leaveInfo;
    }

    /**
     * 修改数据
     *
     * @param leaveInfo 实例对象
     * @return 实例对象
     */
    @Override
    public LeaveInfo update(LeaveInfo leaveInfo) {
        this.leaveInfoDao.update(leaveInfo);
        return this.queryById(leaveInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.leaveInfoDao.deleteById(id) > 0;
    }

    /**
     * 根据UID查询任务
     *
     * @param cuid
     * @return
     */
    @Override
    public Result findLeaveInfoByCuid(String cuid) {
        LeaveInfo leaveInfo = new LeaveInfo();
        leaveInfo.setLoansid(cuid);
        LeaveInfo leaveInfo1 = null;
        List<LeaveInfo> leaveInfos = leaveInfoDao.queryAll(leaveInfo);
        if(leaveInfos.size() == 1){
            leaveInfo1 = leaveInfos.get(0);
        }
        return ResultUtil.success(JSON.toJSONString(leaveInfo1));
    }
}