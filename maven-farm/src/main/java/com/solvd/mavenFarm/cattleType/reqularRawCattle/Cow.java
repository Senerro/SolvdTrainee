package com.solvd.mavenFarm.cattleType.reqularRawCattle;

import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.raw.AbstractRaw;
import com.solvd.mavenFarm.raw.Meat;
import com.solvd.mavenFarm.raw.Milk;
import com.solvd.mavenFarm.resourses.Corn;
import com.solvd.mavenFarm.resourses.Water;

import java.io.Serializable;
import java.util.ArrayList;

public class Cow extends RawCattle implements Serializable {
    public Cow() {
        name("Cow");


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
    private int color;

    public int getColor() {
        return color;
    }
    public void SetColor(int color)
    {
        this.color = color;
    }

    @Override
    public void eat()
    {
        System.out.println("I need gross");
    }

    @Override
    public void drink() {
        System.out.println("I need a bit water");

    }
    @Override
    public void growUp() {
        System.out.println("I will grow up till I will not be murdered ");
    }

    @Override
    public ArrayList<AbstractRaw> harvest() {

        ArrayList<AbstractRaw> rawArrayList = new ArrayList<>();
        Milk milk = new Milk();
        rawArrayList.add(milk);

        if (isDead())
        {
            Meat meat = new Meat();
            rawArrayList.add(meat);
        }
        return rawArrayList;
    }
}
