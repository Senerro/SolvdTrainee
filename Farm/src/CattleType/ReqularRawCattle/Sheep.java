package CattleType.ReqularRawCattle;

import CattleType.RawCattle;
import Raw.Meat;
import Raw.Milk;
import Raw.Wool;
import Resourses.Watter;

import java.io.Serializable;

public class Sheep extends RawCattle implements Serializable {
    public Sheep()
    {
        ID = 4;
        this.CattleWeight(90.3f);
        this.DefaultCost(4.5f * CattleWeight());
        Watter water = new Watter();
        this.LiquidAbstractResourse(water);
        this.SolidResourseVolumRequierment(80);
        Name("Sheep");
    }
    public void Eat()
    {
        System.out.println("I need corn");

    }

    @Override
    public void Drink() {
        System.out.println("I need 7-8 liters of water");

    }
    @Override
    public void GrowUp() {
        System.out.println("I will grow up till I'm 3");
    }

    @Override
    public void SomeRaw() {
        Wool wool = new Wool();
        this.Raw(wool);
        Milk milk = new Milk();
        this.Raw(milk);

        if (isDead())
        {
            Meat meat = new Meat();
            this.Raw(meat);
        }
    }
}
