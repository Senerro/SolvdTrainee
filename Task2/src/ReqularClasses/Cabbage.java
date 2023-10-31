package ReqularClasses;

import AbstractEntities.Food;

public class Cabbage extends Food {
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
        setName("Cabbage");
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
