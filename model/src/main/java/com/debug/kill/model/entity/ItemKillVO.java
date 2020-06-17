package com.debug.kill.model.entity;


public class ItemKillVO extends ItemKill {
    private static final long serialVersionUID = 488779593352690459L;


    private Integer canKill;

    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "ItemKillVO{" +
                "canKill=" + canKill +
                ", itemName='" + itemName + '\'' +
                '}';
    }

    public Integer getCanKill() {
        return canKill;
    }

    public void setCanKill(Integer canKill) {
        this.canKill = canKill;
    }
}
