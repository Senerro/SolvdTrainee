package FoodTypes.ReqularFruitsSpawn;

import FoodTypes.FruitSpawn;

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
        SetName("Lemon tree");
        this.SetDefaultCost(17);
        this.SetCropYield(50);
    }
    @Override
    public void Eat()
    {
        System.out.println("I need humus and calcium");
    }

    @Override
    public void Drink() {
        System.out.println("I need a watering with well-standing water");

    }
    @Override
    public void GrowUp() {
        System.out.println("I will grow up till I grow up ");
        System.out.println("My lemon will grow up till they is not started to be rotten");
    }
}
