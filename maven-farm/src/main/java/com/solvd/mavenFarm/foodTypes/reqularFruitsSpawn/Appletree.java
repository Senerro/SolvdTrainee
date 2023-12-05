package com.solvd.mavenFarm.foodTypes.reqularFruitsSpawn;



import com.solvd.mavenFarm.foodTypes.FruitSpawn;

import java.io.Serializable;

public class Appletree extends FruitSpawn implements Serializable {
    private Boolean helthStatus;
    public Appletree()
    {
        this.helthStatus = false;
        this.name("Apple tree");
        this.defaultCost(17);
        this.cropYield(50);
    }
    public Boolean getHealthStatus()
    {
        return helthStatus;
    }
    public void changeHealthStatus(){ this.helthStatus = !helthStatus;}
    @Override
    public void eat()
    {
        System.out.println("I need fertilization");
    }

    @Override
    public void drink() {
        System.out.println("I need a watering");

    }
    @Override
    public void growUp() {
        System.out.println("I will grow up till I grow up ");
        System.out.println("My apple will grow up till they is not started to be rotten");

    }
}
