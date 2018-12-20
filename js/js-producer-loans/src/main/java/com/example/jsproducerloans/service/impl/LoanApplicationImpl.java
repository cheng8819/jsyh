package com.example.jsproducerloans.service.impl;

import com.example.jsproducerloans.dao.*;
import com.example.jsproducerloans.pojo.*;
import com.example.jsproducerloans.service.LoanApplication;
import com.example.jsproducerloans.util.Result;
import com.example.jsproducerloans.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import tk.mybatis.mapper.entity.Example;

@Service
public class LoanApplicationImpl implements LoanApplication {

    @Autowired
    private LoansUserinfoDao loansUserinfoDao;
    @Autowired
    private LoansPeoplesDao loansPeoplesDao;
    @Autowired
    private JobDao jobDao;
    @Autowired
    private EducationsDao educationDao;
//    @Autowired
//    private TestLeaveService testLeaveService;
    @Autowired
    private LeaveInfoDao leaveInfoDao;

    /**
     * 录入登记信息
     *
     * @param loansUserinfo
     * @return
     */
    @Override
    public Result registerInfo(LoansUserinfo loansUserinfo) {
        loansUserinfo.setLuid(0);
        String str = "";
//        Example example = new Example(LoansPeoples.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("lpid",loansUserinfo.getLumarriage());
        if(loansUserinfo.getLumarriage() == null){
            return ResultUtil.success("婚姻不可为空");
        }
        LoansPeoples loansPeoples = loansPeoples = loansPeoplesDao.findLoansPeoplesByLpid(loansUserinfo.getLumarriage());
        if(loansPeoples == null){
            return ResultUtil.success("家庭人数录入有误，只能为单人和夫妻");
        }
//        Example example1 = new Example(Job.class);
//        Example.Criteria criteria1 = example1.createCriteria();
//        criteria1.andEqualTo("jid",loansUserinfo.getLujob());
        if(loansUserinfo.getLujob() == null){
            return ResultUtil.success("职业不可为空");
        }
        Job job = jobDao.findJobByJid(loansUserinfo.getLujob());
        if(job == null){
            return ResultUtil.success("职业输入不符");
        }
//        Example example2 = new Example(Education.class);
//        Example.Criteria criteria2 = example2.createCriteria();
//        criteria2.andEqualTo("eid",loansUserinfo.getLueducation());
        if(loansUserinfo.getLueducation() == null){
            return ResultUtil.success("学历不可为空");
        }
        Education education =  educationDao.findEducationByEid(loansUserinfo.getLueducation());
        if(education == null){
            return ResultUtil.success("学历输入错误");
        }
//        int count = loansUserinfoDao.insert(loansUserinfo);
//        if(count > 1){
//            str = "提交成功";
//            System.out.println(count);
////            addLeaveAInfo(count);
//        }else{
//            str = "提交失败";
//        }
        LoansUserinfo loansUserinfo1 = loansUserinfoDao.save(loansUserinfo);
        if(loansUserinfo1 != null){
            str = "提交成功";
//            addLeaveAInfo(count);
        }else{
            str = "提交失败";
        }
        return ResultUtil.success(str);
    }

    /**
     * 以申请表单记录id添加一条流程
     * @param leid 表单记录id
     */
//    @Override
//    public void addLeaveAInfo(Integer leid) {
//        LeaveInfo leaveInfo = new LeaveInfo();
//        leaveInfo.setLoansid(leid);
//        String id = UUID.randomUUID().toString();
//        leaveInfo.setId(id);
//        //新增一条记录至数据库中
//        leaveInfoDao.insert(leaveInfo);
//        //启动流程引擎
//        testLeaveService.startProcess(id);
//    }

}
