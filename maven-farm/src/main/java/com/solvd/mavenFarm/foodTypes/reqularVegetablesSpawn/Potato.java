package com.solvd.mavenFarm.foodTypes.reqularVegetablesSpawn;



import com.solvd.mavenFarm.foodTypes.VegetableSpawn;

import java.io.Serializable;

public class Potato extends VegetableSpawn implements Serializable {
    private int size;
    public Potato()
    {
        this.name("Potato");
        this.defaultCost(17);

    }
    public int getSize() {
        return size;
    }
    public void SetSize(int size)
    {
        this.size = size;
    }

    public void eat() {
        System.out.println("I need potato fertilizers");
    }
    public void drink() {
        System.out.println("I need 3 litters of water");
    }
    @Override
    public void growUp() {
        System.out.println("I will grow up till I'am ripped ");
    }
}
