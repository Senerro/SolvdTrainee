package ReqularClasses;

import CattleType.RawCattle;

public class Cow extends RawCattle {
    public Cow() {setName("Cow");}
    @Override
    public void Eat()
    {
        System.out.println("I need gross");
    }

    @Override
    public void Drink() {
        System.out.println("I need a bit water");

    }
    @Override
    public void GrowUp() {
        System.out.println("I will grow up till I will not be murdered ");
    }

    @Override
    public void GetSomeRaw() {
        System.out.println("Generic milk");
        if (isDead) System.out.println("Generic myself meat");
    }
}
