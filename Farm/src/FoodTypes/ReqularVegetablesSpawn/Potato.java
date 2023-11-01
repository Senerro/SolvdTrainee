package FoodTypes.ReqularVegetablesSpawn;

import FoodTypes.Vegetable;

import java.io.Serializable;

public class Potato extends Vegetable implements Serializable {
    private int size;

    public int getSize() {
        return size;
    }
    public void SetSize(int size)
    {
        this.size = size;
    }

    public void Eat() {
        System.out.println("I need potato fertilizers");
    }
    public void Drink() {
        System.out.println("I need 3 litters of water");
    }
    @Override
    public void GrowUp() {
        System.out.println("I will grow up till I'am ripped ");
    }
}
