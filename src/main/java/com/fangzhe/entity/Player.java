package com.fangzhe.entity;

import java.util.List;

import  com.fangzhe.entity.Goods;
import lombok.Data;

import static com.fangzhe.entity.Goods.GUN;

/**
 * @author ASUS
 */
@Data
public class Player {

    //玩家姿势
    public static final String STAND = "STAND";
    public static final String SQUAT = "SQUAT";
    public static final String CRAWL= "CRAWL";
    /*
    动作状态
     */
    public static final String WALK = "WALK";
    public static final String FLY = "FLY";
    public static final String RUN = "RUN";
    public static final String ACCELERATE = "ACCELERATE";
    public static final String FALLING = "FALLING";
    public static final String RESCUE = "RESCUE";
    public static final String GET_RESCUED = "GET_RESCUED";

    /*
    游戏开局状态
    开局中 or 未开局
     */
    private Boolean gameState;
    //坐标
    private Coordinates coordinates;
    /*
    血槽
     */
    private double bloodVolume;
    private List<Goods> goods;
    private String action;
    private String posture;
    private String direction;

    public Player(){
        this.gameState = false;
    }
    public void startGame(){
        //可以组队
        this.gameState = true;
        this.action = FLY;
        this.posture = STAND;

    }
    //降落
    public void parachute(){
        coordinates.setHighness(1000);
        //方向往下
        move(direction);
        if (coordinates.getHighness() == 0){
            this.action = WALK;
        }
    }
    //移动
    public void move(String direction){
        String action = this.action;
        //每个动作 有相应的速度
        //朝着direction方向
    }
    public void postureChange(String posture){
        this.posture = posture;
    }
    //攻击
    public void attack(Goods goods){
        if (goods.getGoodName().equals(GUN)){
            ((Guns) goods).shooting();
        }

    }
    //受袭击
    public void gotAttacked(Goods goods){

        bloodVolume = bloodVolume - goods.getDamageValue();
//        状态变倒地
        if (bloodVolume == 0){
            this.action = FALLING;
        }
    }
    //救援
    public void rescue(Player player){
        double bloodVolume = player.getBloodVolume();
        int rescueTime = 10;
        while (rescueTime >=0 && this.action.equals(RESCUE) && player.getAction().equals(GET_RESCUED)){
            player.setBloodVolume(bloodVolume + 10);
            rescueTime--;
            if (player.getBloodVolume() == 0 || this.getBloodVolume() == 0){
                break;
            }
        }
    }
    //被救援
    public void getRescued(Player rescuer){
        double bloodVolume = rescuer.getBloodVolume();
        int rescueTime = 10;
        while (rescueTime >=0 && rescuer.getAction().equals(RESCUE) && this.getAction().equals(GET_RESCUED)){
            this.setBloodVolume(bloodVolume + 10);
            rescueTime--;
            if (rescuer.getBloodVolume() == 0 || this.getBloodVolume() == 0){
                break;
            }
        }
    }
    //舔包、捡东西
    //扔东西

}
