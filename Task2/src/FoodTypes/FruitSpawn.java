package FoodTypes;

import AbstractEntities.Food;

public abstract class FruitSpawn extends Food
{
    private int cropYield;

    public int GetCropYield() {
        return cropYield;
    }
    public void setCropYield(int cropYield)
    {
        this.cropYield = cropYield;
    }

    public void GetNewFruit()
    {
        System.out.println("I give fruit of myself because I am a fruit");
    }
}
