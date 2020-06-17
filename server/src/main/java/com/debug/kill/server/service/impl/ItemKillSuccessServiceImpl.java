package com.debug.kill.server.service.impl;

import com.debug.kill.model.dao.ItemKillSuccessDao;
import com.debug.kill.model.entity.ItemKillSuccess;
import com.debug.kill.server.service.ItemKillSuccessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 秒杀成功订单表(ItemKillSuccess)表服务实现类
 *
 * @author makejava
 * @since 2020-06-15 17:15:01
 */
@Service("itemKillSuccessService")
@Transactional
public class ItemKillSuccessServiceImpl implements ItemKillSuccessService {
    @Resource
    private ItemKillSuccessDao itemKillSuccessDao;

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    @Override
    public ItemKillSuccess queryById(String code) {
        return this.itemKillSuccessDao.queryById(code);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItemKillSuccess> queryAllByLimit(int offset, int limit) {
        return this.itemKillSuccessDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itemKillSuccess 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(ItemKillSuccess itemKillSuccess) {
        return this.itemKillSuccessDao.insert(itemKillSuccess);
    }

    /**
     * 修改数据
     *
     * @param itemKillSuccess 实例对象
     * @return 实例对象
     */
    @Override
    public ItemKillSuccess update(ItemKillSuccess itemKillSuccess) {
        this.itemKillSuccessDao.update(itemKillSuccess);
        return this.queryById(itemKillSuccess.getCode());
    }

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String code) {
        return this.itemKillSuccessDao.deleteById(code) > 0;
    }

    @Override
    public ItemKillSuccess verifyRepeat(ItemKillSuccess itemKillSuccess) {
        return this.itemKillSuccessDao.verifyRepeat(itemKillSuccess);
    }
}