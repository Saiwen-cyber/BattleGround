package com.fangzhe.entity;

import lombok.Data;

@Data
public class Coordinates {
    private double highness = 0;
    private double x = 0;
    private double y = 0;
    //目标定位
    private Coordinates targetLocation = null;
}
