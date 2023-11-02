package FoodTypes;

import AbstractEntities.Food;

import java.io.Serializable;

public abstract class VegetableSpawn extends Food implements Serializable
{
    private int ripeningTime;
    public int GetRipeningTime()
    {
        return ripeningTime;
    }
    public void SetRipeningTime(int ripeningTime)
    {
        this.ripeningTime = ripeningTime;
    }

    public void GetBenefit()
    {
        System.out.println("I give myself because I am a vegetable");
    }
}
