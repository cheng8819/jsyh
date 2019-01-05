package com.example.jsregisterprovider.jsproviderregister.service.impl;

import com.example.jsregisterprovider.jsproviderregister.dao.JsclientinfoDao;
import com.example.jsregisterprovider.jsproviderregister.dao.JsclientinternetbankinfoDao;
import com.example.jsregisterprovider.jsproviderregister.pojo.Jsclientinfo;
import com.example.jsregisterprovider.jsproviderregister.pojo.Jsclientinternetbankinfo;
import com.example.jsregisterprovider.jsproviderregister.service.ClientRegisterService;
import com.example.jsregisterprovider.jsproviderregister.util.IdentityCardUtil;
import com.service.pojo.ClientRegister;
import com.service.pojo.ClientRegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@SuppressWarnings("ALL")
@Service("clientRegisterServiceImpl")
public class ClientRegisterServiceImpl implements ClientRegisterService {

    @Autowired
    private JsclientinternetbankinfoDao jsclientinternetbankinfoDao;

    @Autowired
    private JsclientinfoDao jsclientinfoDao;

    /**
     * 用户注册
     *
     * @param clientRegister
     * @return
     */
    @Override
    public String clientRegister(ClientRegister clientRegister) {
        //先判断该手机号是否已经注册
        //查询是否已经办理了我行银行卡
        return null;
    }

    /**
     * 查询手机号码是否注册
     *
     * @param phone
     * @return
     */
    @Override
    public String registerPhoneExists(String phone, String idNumber) {
        System.out.println(phone);
        Integer integer = jsclientinternetbankinfoDao.registerPhoneExists(phone);
        if (jsclientinternetbankinfoDao.selectBankCardExists(idNumber) != 0) {
            return "403";
        }
        return integer == 0 ? "200" : "已注册请直接登录";
    }

    /**
     * 添加网银用户
     *
     * @param clientRegisterUser
     * @return
     */
    @Transactional
    @Override
    public String addInternetUser(ClientRegisterUser clientRegisterUser) {
        int code = (int) (Math.random() * (400000000 - 100000000)) + 100000000; // 产生1000-9999之间的一个随机数
        Map<String, String> birAgeSex = IdentityCardUtil.getBirAgeSex(clientRegisterUser.getJsIdnumber());
        String sexCode = birAgeSex.get("sexCode");
        //性别是M是男 sex=1
        int sex = sexCode.equals("M") ? 1 : 0;
        Jsclientinfo jsclientinfo = new Jsclientinfo();
        Jsclientinternetbankinfo jsclientinternetbankinfo = new Jsclientinternetbankinfo();
        jsclientinfo.setJsClientid(code);//用户后台id
        jsclientinfo.setJsClientname(clientRegisterUser.getJsClientname());//用户姓名
        jsclientinfo.setJsSex(String.valueOf(sex));//性别
        jsclientinfo.setJsCretificatetype("身份证");
        jsclientinfo.setJsIdnumber(clientRegisterUser.getJsIdnumber());//身份证号
        jsclientinfo.setJsPhonenumber(clientRegisterUser.getJsPhonenumber());//手机号
        jsclientinfo.setJsClientrank("基准客户");//客户级别
        jsclientinfo.setJsRegisterway("柜面注册");//注册方式
        jsclientinfo.setJsInternetopentype(1);

        jsclientinternetbankinfo.setJsClientid(code);
        jsclientinternetbankinfo.setJsIdnumber(clientRegisterUser.getJsIdnumber());
        jsclientinternetbankinfo.setJsInternetbankpassword(clientRegisterUser.getJsInternetbankpassword());
        jsclientinternetbankinfo.setJsInternetbankphone(clientRegisterUser.getJsInternetBankPhone());
        jsclientinternetbankinfo.setJsInternetbankusername(clientRegisterUser.getJsInternetbankusername());
        int insert1 = jsclientinfoDao.insert(jsclientinfo);
        int insert = jsclientinternetbankinfoDao.insert(jsclientinternetbankinfo);

        int a = 0;
        a = insert == 1 & insert1 == 1 ? 1 : 0;
        return a == 0 ? "注册失败" : "注册成功";
    }


    @Override
    public String selectClientRegister(String name, String idCard, String phone) {
        //查询身份证号
        String s = jsclientinternetbankinfoDao.selectIdCard(idCard);
        if (s == null) {
            Integer integer = jsclientinternetbankinfoDao.registerPhoneExists(phone);
            if (integer==0) {
                return "200";
            }else {
                return "手机号已注册";
            }
        } else {
            return "您以注册工商银行";
        }
        //查询手机号
    }
}
