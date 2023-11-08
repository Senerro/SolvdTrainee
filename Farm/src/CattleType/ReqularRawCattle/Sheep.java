package CattleType.ReqularRawCattle;

import CattleType.RawCattle;
import Raw.*;
import Resourses.Corn;
import Resourses.Water;

import java.io.Serializable;
import java.util.ArrayList;

public class Sheep extends RawCattle implements Serializable {
    public Sheep()
    {
        Name("Sheep");

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
    public ArrayList<AbstractRaw> Harvest() {

        ArrayList<AbstractRaw> rawArrayList = new ArrayList<>();
        Milk milk = new Milk();
        rawArrayList.add(milk);
        Wool wool = new Wool();

        if (isDead())
        {
            Meat meat = new Meat();
            rawArrayList.add(meat);
        }
        return rawArrayList;
    }
}
