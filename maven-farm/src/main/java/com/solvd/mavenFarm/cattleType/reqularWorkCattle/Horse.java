package com.solvd.mavenFarm.cattleType.reqularWorkCattle;

import com.solvd.mavenFarm.cattleType.WorkCattle;

import java.io.Serializable;

public class Horse extends WorkCattle implements Serializable {

    private float maxEndurance;
    private float currentEndurance;

    public float getCurrentEndurance() {
        return currentEndurance;
    }

    public float getMaxEndurance() {
        return maxEndurance;
    }
    public void SetMaxEndurance(float maxEndurance)
    {
        this.maxEndurance = maxEndurance;
    }
    public void ChangeCurrentEndurance(float endurance)
    {
        this.currentEndurance += endurance;
        if(currentEndurance > maxEndurance)
            currentEndurance = maxEndurance;
    }

    public Horse() {
        name("Horse");
        this.defaultCost(1100);
    }
    @Override
    public void eat()
    {
        System.out.println("I need vegetables");
    }

    @Override
    public void drink() {
        System.out.println("I need water");
    }
    @Override
    public void growUp() {
        System.out.println("I will grow up till I die");
    }

    @Override
    public void doSomeWork() {
        System.out.println("I am able to relocate some things");
    }
}

