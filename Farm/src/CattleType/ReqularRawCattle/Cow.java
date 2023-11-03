package CattleType.ReqularRawCattle;

import CattleType.RawCattle;
import Raw.Meat;
import Raw.Milk;
import Resourses.Watter;

import java.io.Serializable;

public class Cow extends RawCattle implements Serializable {
    public Cow() {
        Name("Cow");
        ID = 2;
        this.CattleWeight(850);
        this.DefaultCost(2.5f * CattleWeight());
        Watter water = new Watter();
        this.LiquidAbstractResourse(water);
        this.SolidResourseVolumRequierment(500);
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
    public void SomeRaw() {
        Milk milk = new Milk();
        this.Raw(milk);

        if (isDead())
        {
            Meat meat = new Meat();
            this.Raw(meat);
        }
    }
}
