package com.debug.kill.server.service.impl;

import com.debug.kill.model.dao.ItemDao;
import com.debug.kill.model.entity.Item;
import com.debug.kill.server.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品表(Item)表服务实现类
 *
 * @author makejava
 * @since 2020-06-15 17:12:37
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemDao itemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Item queryById(Integer id) {
        return this.itemDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Item> queryAllByLimit(int offset, int limit) {
        return this.itemDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    @Override
    public Item insert(Item item) {
        this.itemDao.insert(item);
        return item;
    }

    /**
     * 修改数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    @Override
    public Item update(Item item) {
        this.itemDao.update(item);
        return this.queryById(item.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.itemDao.deleteById(id) > 0;
    }

}