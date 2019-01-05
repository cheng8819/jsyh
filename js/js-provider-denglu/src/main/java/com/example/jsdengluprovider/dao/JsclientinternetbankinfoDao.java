package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Jsclientbank;
import com.example.jsdengluprovider.pojo.Jsclientinfo;
import com.example.jsdengluprovider.pojo.Jsclientinternetbankinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * (Jsclientinternetbankinfo)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 23:36:47
 */
public interface JsclientinternetbankinfoDao {

    /**
     * 通过ID查询单条数据
     *
     *
     * @return 实例对象
     */
    Jsclientinternetbankinfo queryById(String jsIdnumber);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Jsclientinternetbankinfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param jsclientinternetbankinfo 实例对象
     * @return 对象列表
     */
    List<Jsclientinternetbankinfo> queryAll(Jsclientinternetbankinfo jsclientinternetbankinfo);

    /**
     * 新增数据
     *
     * @param jsclientinternetbankinfo 实例对象
     * @return 影响行数
     */
    int insert(Jsclientinternetbankinfo jsclientinternetbankinfo);

    /**
     * 修改数据
     *
     * @param jsclientinternetbankinfo 实例对象
     * @return 影响行数
     */
    int update(Jsclientinternetbankinfo jsclientinternetbankinfo);

    /**
     * 通过主键删除数据
     *
     *
     * @return 影响行数
     */
    int deleteById( );

    //通过手机号进行登录
    Jsclientinternetbankinfo phonelogin(@Param("name") String name ,@Param("password") String password);

    //通过银行卡登录
    Jsclientinternetbankinfo bankNumberLogin(@Param("name") String name,@Param("password") String password);

    //通过用户名登录
    Jsclientinternetbankinfo userNameLogin(@Param("name") String name ,@Param("password") String password);
    //搜索手机号
    String getPhone(@RequestParam("name") String name);

    int UpdatePassWord(@Param("jsClientid") Integer jsClientid,@Param("jsInternetbankpassword") String jsInternetbankpassword);

    //查询密码
    String selectPassword(@Param("jsClientID") Integer jsClientID);

    //通过手机号码查询cookie获取设备登录记录密文
    String loginRecordCookie(@Param("jsInternetBankPhone") String jsInternetBankPhone);

    //更新cookie信息
    Integer updateCookieRecord(@Param("jsInternetBankPhone") String jsInternetBankPhone,@Param("jsCookieRecord") String jsCookieRecord);

    //通过手机号查询身份证
    String selectIdCard(String jsInternetbankphone);
}