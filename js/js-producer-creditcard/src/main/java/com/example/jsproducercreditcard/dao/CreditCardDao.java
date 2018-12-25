package com.example.jsproducercreditcard.dao;

import com.example.jsproducercreditcard.entity.CreditCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (CreditCard)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-25 12:36:01
 */
@Mapper
@Repository
public interface CreditCardDao {

    /**
     * 通过ID查询单条数据
     *
     * @param ccid 主键
     * @return 实例对象
     */
    CreditCard queryById(Integer ccid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CreditCard> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param creditCard 实例对象
     * @return 对象列表
     */
    List<CreditCard> queryAll(CreditCard creditCard);

    /**
     * 新增数据
     *
     * @param creditCard 实例对象
     * @return 影响行数
     */
    int insert(CreditCard creditCard);

    /**
     * 修改数据
     *
     * @param creditCard 实例对象
     * @return 影响行数
     */
    int update(CreditCard creditCard);

    /**
     * 通过主键删除数据
     *
     * @param ccid 主键
     * @return 影响行数
     */
    int deleteById(Integer ccid);

}