package com.solvd.mavenFarm.cattleType.reqularRawCattle;

import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.raw.AbstractRaw;
import com.solvd.mavenFarm.raw.Meat;
import com.solvd.mavenFarm.resourses.Corn;
import com.solvd.mavenFarm.resourses.Water;

import java.io.Serializable;
import java.util.ArrayList;

public class Pig extends RawCattle implements Serializable {
    private float mass;
    public float GetMass()
    {return this.mass;}
    public void SetMass(float mass)
    {
        this.mass = mass;
    }
    public Pig()
    {
        name("Pig");


        Corn corn = new Corn();
        Water water = new Water();

        this.cattleWeight(850);
        this.defaultCost(2.5f);
        this.defaultCost(this.defaultCost() * cattleWeight());
        this.liquidAbstractResource(water);
        this.liquidResourceVolumeRequirement(50);
        this.solidAbstractResource(corn);
        this.solidResourceVolumeRequirement(50);
    }
    @Override
    public void eat()
    {
        System.out.println("I need seed");
    }

    @Override
    public void drink() {
        System.out.println("I need water in 4 times more than seed");

    }
    @Override
    public void growUp() {
        System.out.println("I will grow up till I'm 3");
    }

    @Override
    public ArrayList<AbstractRaw> harvest() {

        ArrayList<AbstractRaw> rawArrayList = new ArrayList<>();

        if (isDead())
        {
            Meat meat = new Meat();
            rawArrayList.add(meat);
        }
        return rawArrayList;
    }
}

