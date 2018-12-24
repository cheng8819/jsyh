package com.example.jsproducerloans.service.impl;

import com.example.jsproducerloans.dao.*;
import com.example.jsproducerloans.pojo.*;
import com.example.jsproducerloans.service.LoanApplication;
import com.example.jsproducerloans.util.Result;
import com.example.jsproducerloans.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 录入登记信息
     *
     * @param loansUserinfo
     * @return
     */
    @Override
    public Result registerInfo(LoansUserinfo loansUserinfo) {
        String str = "";
        if(loansUserinfo.getLumarriage() == null){
            return ResultUtil.success("婚姻不可为空");
        }
        LoansPeoples loansPeoples = loansPeoples = loansPeoplesDao.findLoansPeoplesByLpid(loansUserinfo.getLumarriage());
        if(loansPeoples == null){
            return ResultUtil.success("家庭人数录入有误，只能为单人和夫妻");
        }
        if(loansUserinfo.getLujob() == null){
            return ResultUtil.success("职业不可为空");
        }
        Job job = jobDao.findJobByJid(loansUserinfo.getLujob());
        if(job == null){
            return ResultUtil.success("职业输入不符");
        }
        if(loansUserinfo.getLueducation() == null){
            return ResultUtil.success("学历不可为空");
        }
        Education education =  educationDao.findEducationByEid(loansUserinfo.getLueducation());
        if(education == null){
            return ResultUtil.success("学历输入错误");
        }
        LoansUserinfo loansUserinfo1 = loansUserinfoDao.save(loansUserinfo);
        if(loansUserinfo1 != null){
            str = "提交成功";
        }else{
            str = "提交失败";
        }
        return ResultUtil.success(str);
    }
}
