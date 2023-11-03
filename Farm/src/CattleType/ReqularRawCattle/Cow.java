package CattleType.ReqularRawCattle;

import CattleType.RawCattle;
import Raw.Egg;
import Raw.Meat;
import Raw.Milk;
import Resourses.AbstractResourse;
import Resourses.Corn;
import Resourses.Watter;

import java.io.Serializable;

public class Cow extends RawCattle implements Serializable {
    public Cow() {
        SetName("Cow");
        ID = 2;
        this.SetCattleWeight(850);
        this.SetDefaultCost(2.5f * GetCattleWeight());
        Watter water = new Watter();
        this.SetAbstractResourse(water);
        this.SetResourseVolumRequierment(500);
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
        Milk milk = new Milk();
        this.AddRaw(milk);

        if (isDead())
        {
            Meat meat = new Meat();
            this.AddRaw(meat);
        }
    }
}
