package com.solvd.mavenFarm.foodTypes.reqularFruitsSpawn;



import com.solvd.mavenFarm.foodTypes.FruitSpawn;

import java.io.Serializable;

public class LemonTree extends FruitSpawn implements Serializable
{
    private int acidLevel;

    public int GetAcidLevel() {
        return acidLevel;
    }
    public void SetAcidLevel(int acidLevel)
    {
        this.acidLevel = acidLevel;
    }

    public LemonTree()
    {
        name("Lemon tree");
        this.defaultCost(17);
        this.cropYield(50);
    }
    @Override
    public void eat()
    {
        System.out.println("I need humus and calcium");
    }

    @Override
    public void drink() {
        System.out.println("I need a watering with well-standing water");

    }
    @Override
    public void growUp() {
        System.out.println("I will grow up till I grow up ");
        System.out.println("My lemon will grow up till they is not started to be rotten");
    }
}
