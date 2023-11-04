package CattleType.ReqularRawCattle;

import CattleType.RawCattle;
import Raw.AbstractRaw;
import Raw.Egg;
import Raw.Meat;
import Resourses.Corn;
import Resourses.Water;

import java.io.Serializable;
import java.util.ArrayList;

public class Chicken extends RawCattle implements Serializable {
    public Chicken()
    {

        Name("Chicken");


        Corn corn = new Corn();
        Water water = new Water();

        this.CattleWeight(850);
        this.DefaultCost(2.5f);
        this.DefaultCost(this.DefaultCost() * CattleWeight());
        this.LiquidAbstractResource(water);
        this.LiquidResourceVolumeRequirement(50);
        this.SolidAbstractResource(corn);
        this.SolidResourceVolumeRequirement(50);
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
    public ArrayList<AbstractRaw> Harvest() {

        ArrayList<AbstractRaw> rawArrayList = new ArrayList<>();
        Egg egg = new Egg();
        rawArrayList.add(egg);

        if (isDead())
        {
            Meat meat = new Meat();
            rawArrayList.add(meat);
        }
        return rawArrayList;
    }
}

