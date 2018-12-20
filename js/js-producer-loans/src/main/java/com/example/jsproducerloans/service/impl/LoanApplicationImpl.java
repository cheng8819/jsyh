package com.example.jsproducerloans.service.impl;

import com.example.jsproducerloans.dao.EducationsDao;
import com.example.jsproducerloans.dao.JobDao;
import com.example.jsproducerloans.dao.LoansPeoplesDao;
import com.example.jsproducerloans.dao.LoansUserinfoDao;
import com.example.jsproducerloans.pojo.Education;
import com.example.jsproducerloans.pojo.Job;
import com.example.jsproducerloans.pojo.LoansPeoples;
import com.example.jsproducerloans.pojo.LoansUserinfo;
import com.example.jsproducerloans.service.LoanApplication;
import com.example.jsproducerloans.util.Result;
import com.example.jsproducerloans.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
        Example example = new Example(LoansPeoples.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("lpid",loansUserinfo.getLumarriage());
        if(loansUserinfo.getLumarriage() == null){
            return ResultUtil.success("婚姻不可为空");
        }
        LoansPeoples loansPeoples = loansPeoples = loansPeoplesDao.selectOneByExample(example);
        if(loansPeoples == null){
            return ResultUtil.success("家庭人数录入有误，只能为单人和夫妻");
        }
        Example example1 = new Example(Job.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("jid",loansUserinfo.getLujob());
        if(loansUserinfo.getLujob() == null){
            return ResultUtil.success("职业不可为空");
        }
        Job job = jobDao.selectOneByExample(example1);
        if(job == null){
            return ResultUtil.success("职业输入不符");
        }
        Example example2 = new Example(Education.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("eid",loansUserinfo.getLueducation());
        if(loansUserinfo.getLueducation() == null){
            return ResultUtil.success("学历不可为空");
        }
        Education education =  educationDao.selectOneByExample(example2);
        if(education == null){
            return ResultUtil.success("学历输入错误");
        }
        int count = loansUserinfoDao.insert(loansUserinfo);
        if(count == 1){
            str = "提交成功";
        }else{
            str = "提交失败";
        }
        return ResultUtil.success(str);
    }
}
