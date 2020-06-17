package com.debug.kill.server.controller;

import com.debug.kill.api.response.BaseResponse;
import com.debug.kill.model.entity.ItemKill;
import com.debug.kill.model.entity.ItemKillSuccess;
import com.debug.kill.server.enums.SysConstant;
import com.debug.kill.server.service.ItemKillService;
import com.debug.kill.server.service.ItemKillSuccessService;
import com.debug.kill.server.utils.SnowFlake;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 秒杀成功订单表(ItemKillSuccess)表控制层
 *
 * @author makejava
 * @since 2020-06-15 17:15:01
 */
@Controller
public class ItemKillSuccessController {
    /**
     * 服务对象
     */
    @Resource
    private ItemKillSuccessService itemKillSuccessService;

    @Resource
    private ItemKillService itemKillService;

    private SnowFlake snowFlake=new SnowFlake(2,3);


    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @PostMapping("/execute")
    @ResponseBody
    @Transactional
    public BaseResponse killSuccess(HttpSession session, @RequestBody @Validated ItemKillSuccess itemKillSuccess) {
        if(itemKillSuccess.getKillId() <= 0 || itemKillSuccess.getItemId() <= 0){
            System.out.println("itemKillSuccess----"+itemKillSuccess.getKillId()+""+itemKillSuccess.getItemId());
            return new BaseResponse(1,"没有商品号或秒杀号");
        }
        //1先验证该用户有没有秒杀过该商品
        Integer userId = (Integer) session.getAttribute("uid");
        itemKillSuccess.setUserId(String.valueOf(userId));
        System.out.println("-------"+this.itemKillSuccessService.verifyRepeat(itemKillSuccess)+"---"+(this.itemKillSuccessService.verifyRepeat(itemKillSuccess) == null));
        if(this.itemKillSuccessService.verifyRepeat(itemKillSuccess) == null){
            //2查看库存是否足够
            if(this.itemKillService.queryById(itemKillSuccess.getKillId()).getTotal() > 0){
                String code = String.valueOf(snowFlake.nextId());
                itemKillSuccess.setCode(code);
                itemKillSuccess.setStatus(SysConstant.OrderStatus.SuccessNotPayed.getCode().intValue());
                //生成订单，
                this.itemKillSuccessService.insert(itemKillSuccess);
                //减少库存
                ItemKill updateKill = new ItemKill();
                updateKill.setId(itemKillSuccess.getKillId());
                this.itemKillService.update(updateKill);
                return new BaseResponse(0,"秒杀成功");
            }
            return new BaseResponse(2,"秒杀失败，库存已不足");
        }
        return new BaseResponse(2,"秒杀失败，您已秒杀过改商品");
    }

    @GetMapping("/execute/success")
    public String killSuccess(){
        return  "executeSuccess";
    }

    @GetMapping("/execute/fail")
    public String killFail(){
        return  "executeFail";
    }

}