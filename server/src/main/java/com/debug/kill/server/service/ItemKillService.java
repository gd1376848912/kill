package com.debug.kill.server.service;

import com.debug.kill.model.entity.ItemKill;
import com.debug.kill.model.entity.ItemKillVO;

import java.util.List;

/**
 * 待秒杀商品表(ItemKill)表服务接口
 *
 * @author makejava
 * @since 2020-06-15 17:14:22
 */
public interface ItemKillService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItemKillVO queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItemKill> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itemKill 实例对象
     * @return 实例对象
     */
    ItemKill insert(ItemKill itemKill);

    /**
     * 修改数据
     *
     * @param itemKill 实例对象
     * @return 实例对象
     */
    ItemKill update(ItemKill itemKill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查找秒杀商品
     * @return
     */
    List<ItemKillVO> queryKillItem();

}