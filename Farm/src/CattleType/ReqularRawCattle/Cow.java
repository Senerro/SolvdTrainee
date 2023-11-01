package CattleType.ReqularRawCattle;

import CattleType.RawCattle;

import java.io.Serializable;

public class Cow extends RawCattle implements Serializable {
    public Cow() {
        SetName("Cow");
        ID = 2;
    }
    private int color;

    public int getColor() {
        return color;
    }
    public void SetColor(int color)
    {
        this.color = color;
    }

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
