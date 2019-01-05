package com.example.jsregisterprovider.jsproviderregister.dao;

import com.example.jsregisterprovider.jsproviderregister.pojo.Jsclientinternetbankinfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Jsclientinternetbankinfo)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-26 10:05:46
 */
public interface JsclientinternetbankinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param jsIdnumber 主键
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
     * @param jsIdnumber 主键
     * @return 影响行数
     */
    int deleteById(String jsIdnumber);

    /**
     * 查询要注册的手机号是否存在
     */
    Integer registerPhoneExists(String phone);

    /**
     * 查询注册的银行卡是否存在
     */
    Integer selectBankCardExists(String jsIdnumber);

    /**
     * 查询身份证号存在不
     * @param jsIDNumber
     * @return
     */
    String selectIdCard(String jsIDNumber);

}