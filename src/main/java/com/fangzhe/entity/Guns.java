package com.fangzhe.entity;

public class Guns extends Goods {
    private String bullet;
    private Integer bulletNum;

    Guns(){
        this.setGoodName(GUN);
    }
    public void shooting(){
        while (true){
            this.bulletNum-- ;
            if (bulletNum == 0 || this.getOwner() == null){
                break;
            }
        }
    }
}
