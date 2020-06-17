package com.debug.kill.server.controller;

import com.debug.kill.model.entity.ItemKill;
import com.debug.kill.model.entity.ItemKillVO;
import com.debug.kill.server.service.ItemKillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 待秒杀商品表(ItemKill)表控制层
 *
 * @author makejava
 * @since 2020-06-15 17:14:22
 */
@Controller
public class ItemKillController {
    /**
     * 服务对象
     */
    @Resource
    private ItemKillService itemKillService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public ItemKill selectOne(Integer id) {
        return this.itemKillService.queryById(id);
    }

    /**
     * 查找秒杀商品
     * @param modelMap
     * @return
     */
    @GetMapping({"/","/index","/index.html"})
    public String getKillList(ModelMap modelMap){
        List<ItemKillVO> killItem= itemKillService.queryKillItem();
        modelMap.put("list",killItem);
        System.out.println(modelMap.get("list"));
        return "list";
    }

    @GetMapping("/item/detail/{id}")
    public String itemDetail(@PathVariable Integer id, ModelMap modelMap, HttpSession session){
        if(id==null){
            return "error";
        }
        if (session.getAttribute("uid") == null) {
            return "login";
        }
        ItemKillVO result = this.itemKillService.queryById(id);
        modelMap.put("detail",result);
        return "info";
    }

}