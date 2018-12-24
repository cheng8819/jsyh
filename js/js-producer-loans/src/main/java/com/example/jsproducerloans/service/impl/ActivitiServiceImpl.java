package com.example.jsproducerloans.service.impl;

import com.example.jsproducerloans.dao.AuditorDao;
import com.example.jsproducerloans.dao.LeaveInfoDao;
import com.example.jsproducerloans.pojo.Auditor;
import com.example.jsproducerloans.pojo.LeaveInfo;
import com.example.jsproducerloans.service.ActivitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitiServiceImpl implements ActivitiService {

    @Autowired
    private AuditorDao auditorDao;
    @Autowired
    private LeaveInfoDao leaveInfoDao;
    /**
     * 获取全部审核人
     *
     * @return
     */
    @Override
    public List<Auditor> getAuditorsAll() {
        return auditorDao.findAll();
    }

    /**
     * 根据申请单id查询申请单
     *
     * @param id
     * @return
     */
    @Override
    public LeaveInfo findLeaveInfoById(String id) {
        return leaveInfoDao.findLeaveInfoById(id);
    }

    /**
     * 修改申请单状态
     *
     * @param leaveInfo
     */
    @Override
    public String updateLeaveInfoState(LeaveInfo leaveInfo) {
        LeaveInfo leaveInfo1 = leaveInfoDao.save(leaveInfo);
        return leaveInfo1 == null ? "修改失败" : "修改成功";
    }
}
