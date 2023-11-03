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
        this.SetCattleWeight(90.3f);
        this.SetDefaultCost(4.5f * GetCattleWeight());
        Watter water = new Watter();
        this.SetAbstractResourse(water);
        this.SetResourseVolumRequierment(80);
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
    public void GetSomeRaw() {
        Wool wool = new Wool();
        this.AddRaw(wool);
        Milk milk = new Milk();
        this.AddRaw(milk);

        if (isDead())
        {
            Meat meat = new Meat();
            this.AddRaw(meat);
        }
    }
}
