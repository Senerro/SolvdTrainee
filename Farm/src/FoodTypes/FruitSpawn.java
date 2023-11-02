package FoodTypes;

import AbstractEntities.Food;

import java.io.Serializable;

public abstract class FruitSpawn extends Food implements Serializable
{
    private int cropYield;

    public int GetCropYield() {
        return cropYield;
    }
    public void SetCropYield(int cropYield)
    {
        this.cropYield = cropYield;
    }

    public void GetNewFruit()
    {
        System.out.println("I give fruit of myself because I am a fruit");
    }
}
