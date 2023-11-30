package com.solvd.mavenFarm.foodTypes;


import com.solvd.mavenFarm.abstractEntities.Food;

import java.io.Serializable;

public abstract class VegetableSpawn extends Food implements Serializable
{
    private int ripeningTime;
    public int ripeningTime()
    {
        return ripeningTime;
    }
    public void ripeningTime(final int ripeningTime)
    {
        this.ripeningTime = ripeningTime;
    }

    public void getBenefit()
    {
        System.out.println("I give myself because I am a vegetable");
    }
}
