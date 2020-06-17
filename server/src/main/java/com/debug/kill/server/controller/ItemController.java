package com.debug.kill.server.controller;


import com.debug.kill.model.entity.Item;
import com.debug.kill.server.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品表(Item)表控制层
 *
 * @author makejava
 * @since 2020-06-15 17:12:38
 */
@Controller
@RequestMapping("item")
public class ItemController {
    /**
     * 服务对象
     */
    @Resource
    private ItemService itemService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Item selectOne(Integer id) {
        return this.itemService.queryById(id);
    }



}