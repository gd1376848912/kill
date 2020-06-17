package com.debug.kill.model.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 秒杀成功订单表(ItemKillSuccess)实体类
 *
 * @author makejava
 * @since 2020-06-15 16:59:37
 */
public class ItemKillSuccess implements Serializable {
    private static final long serialVersionUID = -25833380737735740L;
    /**
    * 秒杀成功生成的订单编号
    */
    private String code;
    /**
    * 商品id
    */
    private Integer itemId;
    /**
    * 秒杀id
    */
    private Integer killId;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 秒杀结果: -1无效  0成功(未付款)  1已付款  2已取消
    */
    private Object status;
    /**
    * 创建时间
    */
    private Date createTime;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getKillId() {
        return killId;
    }

    public void setKillId(Integer killId) {
        this.killId = killId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ItemKillSuccess{" +
                "code='" + code + '\'' +
                ", itemId=" + itemId +
                ", killId=" + killId +
                ", userId='" + userId + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}