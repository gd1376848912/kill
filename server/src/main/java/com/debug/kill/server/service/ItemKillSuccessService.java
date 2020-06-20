package com.debug.kill.server.service;

import com.debug.kill.model.entity.ItemKillSuccess;
import com.debug.kill.model.entity.OrderInfo;

import java.util.List;

/**
 * 秒杀成功订单表(ItemKillSuccess)表服务接口
 *
 * @author makejava
 * @since 2020-06-15 17:15:01
 */
public interface ItemKillSuccessService {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    OrderInfo queryById(String code);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItemKillSuccess> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itemKillSuccess 实例对象
     * @return 实例对象
     */
    Integer insert(ItemKillSuccess itemKillSuccess);

    /**
     * 修改数据
     *
     * @param itemKillSuccess 实例对象
     * @return 实例对象
     */
    ItemKillSuccess update(ItemKillSuccess itemKillSuccess);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    boolean deleteById(String code);

    /**
     *
     * @param itemKillSuccess
     * @return
     */
    ItemKillSuccess verifyRepeat(ItemKillSuccess itemKillSuccess);

    void expireOrder(String code);

}