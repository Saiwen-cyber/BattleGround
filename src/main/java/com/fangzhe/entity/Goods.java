package com.fangzhe.entity;

import lombok.Data;

@Data
public class Goods {

    public static final String GUN = "GUN";
    private double volume;
    private Player owner;
    private double damageValue;
    private String goodName;
    public void pickup(Player owner){
        setOwner(owner);
    }
    public void throwaway(){
        this.owner = null;
    }
}
