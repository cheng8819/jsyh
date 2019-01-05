package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Jsclientinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Jsclientinfo)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 23:36:46
 */
public interface JsclientinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param jsClientid 主键
     * @return 实例对象
     */
    Jsclientinfo queryById(Integer jsClientid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Jsclientinfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param jsclientinfo 实例对象
     * @return 对象列表
     */
    List<Jsclientinfo> queryAll(Jsclientinfo jsclientinfo);

    /**
     * 新增数据
     *
     * @param jsclientinfo 实例对象
     * @return 影响行数
     */
    int insert(Jsclientinfo jsclientinfo);

    /**
     * 修改数据
     *
     * @param jsclientinfo 实例对象
     * @return 影响行数
     */
    int update(Jsclientinfo jsclientinfo);

    /**
     * 通过主键删除数据
     *
     * @param jsClientid 主键
     * @return 影响行数
     */
    Integer deleteById(Integer jsClientid);

    /**
     * 通过姓名和身份证号码查询手机号码
     */
    String throughNameIDNumberGetPhoneNumber(@Param("jsClientname") String jsClientname,@Param("jsidnumber") String jsidnumber);

    /**
     * 通过手机号码查询用户后台的id
     */
    Integer throughPhoneNumberClientID(@Param("jsPhoneNumber") String jsPhoneNumber);

    /**
     * 查询手机号是否存在
     */
    Integer selectPhoneExist(@Param("jsInternetOpenType") Integer jsInternetOpenType,@Param("jsPhonenumber") String jsPhonenumber);
}