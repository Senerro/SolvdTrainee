package ReqularClasses;

import FoodTypes.Vegetable;

public class Potato extends Vegetable {
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
