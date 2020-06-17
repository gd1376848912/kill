package com.debug.kill.model.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品表(Item)实体类
 *
 * @author makejava
 * @since 2020-06-15 16:59:39
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 488779593352690459L;
    
    private Integer id;
    /**
    * 商品名
    */
    private String name;
    /**
    * 商品编号
    */
    private String code;
    /**
    * 库存
    */
    private Long stock;
    /**
    * 采购时间
    */
    private Date purchaseTime;
    /**
    * 是否有效（1=是；0=否）
    */
    private Integer isActive;
    
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}