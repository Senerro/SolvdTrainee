package com.solvd.mavenFarm.foodTypes.reqularVegetablesSpawn;



import com.solvd.mavenFarm.foodTypes.VegetableSpawn;

import java.io.Serializable;

public class Cabbage extends VegetableSpawn implements Serializable {
    private int leavesCount;

    public int getLeavesCount() {
        return leavesCount;
    }
    public void setLeavesCount(int leavesCount)
    {
     this.leavesCount = leavesCount;
    }
    public Cabbage()
    {
        name("Cabbage");
        this.defaultCost(2);

    }
    @Override
    public void eat()
    {
        System.out.println("I need wood ash, ground chalk and ammonium nitrate");
    }
    @Override
    public void drink() {
        System.out.println("I need extra watering");
    }
    @Override
    public void growUp() {
        System.out.println("I will grow up till I'm not yield ");
    }
}
