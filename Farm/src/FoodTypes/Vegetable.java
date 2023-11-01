package FoodTypes;

import AbstractEntities.Food;

public abstract class Vegetable extends Food
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
