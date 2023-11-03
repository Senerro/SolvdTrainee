package CattleType.ReqularRawCattle;

import CattleType.RawCattle;
import Raw.Egg;
import Raw.Meat;
import Resourses.Corn;

import java.io.Serializable;

public class Chicken extends RawCattle implements Serializable {



    public Chicken()
    {
        Name("Chicken");
        ID = 1;
        this.CattleWeight(4);
        this.DefaultCost(2.5f * CattleWeight());
        Corn corn = new Corn();
        this.LiquidAbstractResourse(corn);
        this.SolidResourseVolumRequierment(50);
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
    public void SomeRaw() {


        Egg egg = new Egg();
        this.Raw(egg);

        if (isDead())
        {
            Meat meat = new Meat();
            this.Raw(meat);
        }
    }
}

