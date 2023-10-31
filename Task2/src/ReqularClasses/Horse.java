package ReqularClasses;

import CattleType.WorkCastle;

public class Horse extends WorkCastle {
    public Horse() {setName("Horse");}
    @Override
    public void Eat()
    {
        System.out.println("I need vegetables");
    }

    @Override
    public void Drink() {
        System.out.println("I need water");

    }
    @Override
    public void GrowUp() {
        System.out.println("I will grow up till I die");
    }

    @Override
    public void DoSomeWork() {
        System.out.println("I am able to relocate some things");
    }
}
