package com.example.jsproducercreditcard.service.impl;

import com.example.jsproducercreditcard.dao.CurrentAddressDao;
import com.example.jsproducercreditcard.entity.CurrentAddress;
import com.example.jsproducercreditcard.service.CurrentAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CurrentAddress)表服务实现类
 *
 * @author makejava
 * @since 2018-12-25 12:36:06
 */
@Service("currentAddressService")
public class CurrentAddressServiceImpl implements CurrentAddressService {
    @Resource
    private CurrentAddressDao currentAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param caid 主键
     * @return 实例对象
     */
    @Override
    public CurrentAddress queryById(Integer caid) {
        return this.currentAddressDao.queryById(caid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CurrentAddress> queryAllByLimit(int offset, int limit) {
        return this.currentAddressDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param currentAddress 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(CurrentAddress currentAddress) {
        if(currentAddress.getCaprovince() == null || currentAddress.getCacity() == null || currentAddress.getCacounty() == null || currentAddress.getCaaddress() == null){
            return -1;
        }else if ("".equals(currentAddress.getCaprovince()) || "".equals(currentAddress.getCacity()) || "".equals(currentAddress.getCacounty()) || "".equals(currentAddress.getCaaddress())){
            return -1;
        }
        Integer result = null;
        int count = currentAddressDao.insert(currentAddress);
        if(count == 1){
            result = currentAddressDao.maxById();
        }
        return result;
    }

    /**
     * 修改数据
     *
     * @param currentAddress 实例对象
     * @return 实例对象
     */
    @Override
    public CurrentAddress update(CurrentAddress currentAddress) {
        this.currentAddressDao.update(currentAddress);
        return this.queryById(currentAddress.getCaid());
    }

    /**
     * 通过主键删除数据
     *
     * @param caid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer caid) {
        return this.currentAddressDao.deleteById(caid) > 0;
    }
}