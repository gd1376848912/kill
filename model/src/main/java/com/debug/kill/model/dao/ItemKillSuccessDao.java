package com.debug.kill.model.dao;

import com.debug.kill.model.entity.ItemKillSuccess;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 秒杀成功订单表(ItemKillSuccess)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-15 16:59:37
 */
@Mapper
public interface ItemKillSuccessDao {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    ItemKillSuccess queryById(String code);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItemKillSuccess> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itemKillSuccess 实例对象
     * @return 对象列表
     */
    List<ItemKillSuccess> queryAll(ItemKillSuccess itemKillSuccess);

    /**
     * 新增数据
     *
     * @param itemKillSuccess 实例对象
     * @return 影响行数
     */
    int insert(ItemKillSuccess itemKillSuccess);

    /**
     * 修改数据
     *
     * @param itemKillSuccess 实例对象
     * @return 影响行数
     */
    int update(ItemKillSuccess itemKillSuccess);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 影响行数
     */
    int deleteById(String code);


    ItemKillSuccess verifyRepeat(ItemKillSuccess itemKillSuccess);
}