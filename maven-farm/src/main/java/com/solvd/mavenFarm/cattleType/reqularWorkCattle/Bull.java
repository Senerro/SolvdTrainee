package com.solvd.mavenFarm.cattleType.reqularWorkCattle;

import com.solvd.mavenFarm.cattleType.WorkCattle;
import com.solvd.mavenFarm.resourses.Corn;
import com.solvd.mavenFarm.resourses.Water;

import java.io.Serializable;

public class Bull extends WorkCattle implements Serializable {
    private float tonnage;

    public float Tonnage() {
        return tonnage;
    }
    public void Tonnage(float tonnage)
    {this.tonnage = tonnage;}

    public Bull()
    {
        name("Bull");

        Corn corn = new Corn();
        Water water = new Water();


        this.defaultCost(2.5f);
        this.defaultCost(this.defaultCost() * this.Tonnage());
        this.liquidAbstractResource(water);
        this.liquidResourceVolumeRequirement(50);
        this.solidAbstractResource(corn);
        this.solidResourceVolumeRequirement(50);
    }
    @Override
    public void eat()
    {
        System.out.println("I need grass and vegetables");
    }

    @Override
    public void drink() {
        System.out.println("I need water");

    }
    @Override
    public void growUp() {
        System.out.println("I will grow till I am 7");
    }

    @Override
    public void doSomeWork() {
        System.out.println("I am able to work in field");
    }
}

