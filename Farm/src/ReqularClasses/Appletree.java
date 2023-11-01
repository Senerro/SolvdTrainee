package ReqularClasses;

import FoodTypes.FruitSpawn;

public class Appletree extends FruitSpawn {
    private Boolean helthStatus;
    public Appletree()
    {
        this.helthStatus = false;
        this.SetName("Apple tree");
    }
    public Boolean GetHealthStatus()
    {
        return helthStatus;
    }
    public void ChangeHealthStatus(){ this.helthStatus = !helthStatus;}
    @Override
    public void Eat()
    {
        System.out.println("I need fertilization");
    }

    @Override
    public void Drink() {
        System.out.println("I need a watering");

    }
    @Override
    public void GrowUp() {
        System.out.println("I will grow up till I grow up ");
        System.out.println("My apple will grow up till they is not started to be rotten");

    }
}
