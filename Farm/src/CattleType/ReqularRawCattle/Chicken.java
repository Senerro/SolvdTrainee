package CattleType.ReqularRawCattle;

import CattleType.RawCattle;
import Raw.AbstractRaw;
import Raw.Egg;
import Raw.Meat;
import Resourses.Corn;

import java.io.Serializable;
import java.util.ArrayList;

public class Chicken extends RawCattle implements Serializable {



    public Chicken()
    {
        SetName("Chicken");
        ID = 1;
        this.SetCattleWeight(4);
        this.SetDefaultCost(2.5f * GetCattleWeight());
        Corn corn = new Corn();
        this.SetAbstractResourse(corn);
        this.SetResourseVolumRequierment(50);
    }
    @Override
    public void Eat()
    {
        System.out.println("I need chicken feed");

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


        Egg egg = new Egg();
        this.AddRaw(egg);

        if (isDead())
        {
            Meat meat = new Meat();
            this.AddRaw(meat);
        }
    }
}

