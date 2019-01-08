//package com.example.jsdengluprovider.service;
//
//import com.example.jsdengluprovider.dao.JsclientinfoDao;
//import com.example.jsdengluprovider.dao.JsclientinternetbankinfoDao;
//import com.example.jsdengluprovider.pojo.Jsclientinternetbankinfo;
//import com.example.jsdengluprovider.service.impl.UserInfoServiceImpl;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@SuppressWarnings("ALL")
//public class UserRealm extends AuthorizingRealm {
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("执行授权逻辑");
//        return null;
//    }
//
//    @Autowired
//    @Qualifier("userInfoServiceImpl")
//    private UserInfoService userInfoService;
//
//    @Autowired
//    private JsclientinternetbankinfoDao jsclientinternetbankinfoDao;
//
//    @Autowired
//    private JsclientinfoDao jsclientinfoDao;
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("执行认证逻辑");
//        HttpServletResponse response = null;
//        HttpServletRequest request = null;
//
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//
//        //String login = userInfoService.login(token.getUsername(), password, request, response);
//        Jsclientinternetbankinfo jsclientinternetbankinfo = null;
//        String password = null;
//        if (token.getUsername().matches(UserInfoServiceImpl.PHONE_NUMBER_REG)) {
//            //手机号登录
//            Integer i = jsclientinfoDao.selectPhoneExist(1, token.getUsername());
//            //if (!token.getUsername().equals("数据库手机号"))
//            if (i == null||i==0) {
//                return null;
//            }else {
//                password = jsclientinternetbankinfoDao.selectPassword(i);
//            }
//        } else if (token.getUsername().matches(UserInfoServiceImpl.BANK_NUMBER_REG)) {
//            //银行卡登录
//
//            return null;
//        } else {
//            //用户名登录
//
//            return null;
//        }
//        return  new SimpleAuthenticationInfo(",",password,"");
//    }
//}
