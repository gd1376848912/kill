package com.debug.kill.model.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 待秒杀商品表(ItemKill)实体类
 *
 * @author makejava
 * @since 2020-06-15 16:59:59
 */
public class ItemKill implements Serializable {
    private static final long serialVersionUID = -97684283960897428L;
    /**
    * 主键id
    */
    private Integer id;
    /**
    * 商品id
    */
    private Integer itemId;
    /**
    * 可被秒杀的总数
    */
    private Integer total;
    /**
    * 秒杀开始时间
    */
    private Date startTime;
    /**
    * 秒杀结束时间
    */
    private Date endTime;
    /**
    * 是否有效（1=是；0=否）
    */
    private Object isActive;
    /**
    * 创建的时间
    */
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Object getIsActive() {
        return isActive;
    }

    public void setIsActive(Object isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}