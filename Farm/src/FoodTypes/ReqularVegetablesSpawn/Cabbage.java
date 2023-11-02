package FoodTypes.ReqularVegetablesSpawn;

import FoodTypes.VegetableSpawn;

import java.io.Serializable;

public class Cabbage extends VegetableSpawn implements Serializable {
    private int leavesCount;

    public int getLeavesCount() {
        return leavesCount;
    }
    public void setLeavesCount(int leavesCount)
    {
     this.leavesCount = leavesCount;
    }
    public Cabbage()
    {
        SetName("Cabbage");
        this.SetDefaultCost(2);

    }
    @Override
    public void Eat()
    {
        System.out.println("I need wood ash, ground chalk and ammonium nitrate");
    }
    @Override
    public void Drink() {
        System.out.println("I need extra watering");
    }
    @Override
    public void GrowUp() {
        System.out.println("I will grow up till I'm not yield ");
    }
}
