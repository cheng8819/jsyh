package com.example.jsproducercreditcard.service.impl;

import com.example.jsproducercreditcard.dao.CreditCardDao;
import com.example.jsproducercreditcard.entity.CreditCard;
import com.example.jsproducercreditcard.service.CreditCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CreditCard)表服务实现类
 *
 * @author makejava
 * @since 2018-12-25 12:36:03
 */
@Service("creditCardService")
public class CreditCardServiceImpl implements CreditCardService {
    @Resource
    private CreditCardDao creditCardDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ccid 主键
     * @return 实例对象
     */
    @Override
    public CreditCard queryById(Integer ccid) {
        return this.creditCardDao.queryById(ccid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CreditCard> queryAllByLimit(int offset, int limit) {
        return this.creditCardDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param creditCard 实例对象
     * @return 实例对象
     */
    @Override
    public CreditCard insert(CreditCard creditCard) {
        this.creditCardDao.insert(creditCard);
        return creditCard;
    }

    /**
     * 修改数据
     *
     * @param creditCard 实例对象
     * @return 实例对象
     */
    @Override
    public CreditCard update(CreditCard creditCard) {
        this.creditCardDao.update(creditCard);
        return this.queryById(creditCard.getCcid());
    }

    /**
     * 通过主键删除数据
     *
     * @param ccid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer ccid) {
        return this.creditCardDao.deleteById(ccid) > 0;
    }
}