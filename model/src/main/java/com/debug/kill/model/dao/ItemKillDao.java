package com.debug.kill.model.dao;

import com.debug.kill.model.entity.ItemKill;
import com.debug.kill.model.entity.ItemKillVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 待秒杀商品表(ItemKill)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-15 16:59:59
 */
@Mapper
public interface ItemKillDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItemKillVO queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItemKill> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itemKill 实例对象
     * @return 对象列表
     */
    List<ItemKill> queryAll(ItemKill itemKill);

    /**
     * 新增数据
     *
     * @param itemKill 实例对象
     * @return 影响行数
     */
    int insert(ItemKill itemKill);

    /**
     * 修改数据
     *
     * @param itemKill 实例对象
     * @return 影响行数
     */
    int update(ItemKill itemKill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<ItemKillVO> queryKillItem();

}