package com.debug.kill.server.service.impl;

import com.debug.kill.model.entity.ItemKill;
import com.debug.kill.model.dao.ItemKillDao;
import com.debug.kill.model.entity.ItemKillVO;
import com.debug.kill.server.service.ItemKillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 待秒杀商品表(ItemKill)表服务实现类
 *
 * @author makejava
 * @since 2020-06-15 17:14:22
 */
@Service("itemKillService")
public class ItemKillServiceImpl implements ItemKillService {
    @Resource
    private ItemKillDao itemKillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItemKillVO queryById(Integer id) {
        return this.itemKillDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItemKill> queryAllByLimit(int offset, int limit) {
        return this.itemKillDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itemKill 实例对象
     * @return 实例对象
     */
    @Override
    public ItemKill insert(ItemKill itemKill) {
        this.itemKillDao.insert(itemKill);
        return itemKill;
    }

    /**
     * 修改数据
     *
     * @param itemKill 实例对象
     * @return 实例对象
     */
    @Override
    public ItemKill update(ItemKill itemKill) {
        this.itemKillDao.update(itemKill);
        return this.queryById(itemKill.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.itemKillDao.deleteById(id) > 0;
    }

    @Override
    public List<ItemKillVO> queryKillItem() {
        return this.itemKillDao.queryKillItem();
    }


}