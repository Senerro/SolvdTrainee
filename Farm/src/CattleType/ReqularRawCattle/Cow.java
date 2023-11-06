package CattleType.ReqularRawCattle;

import CattleType.RawCattle;
import Raw.AbstractRaw;
import Raw.Egg;
import Raw.Meat;
import Raw.Milk;
import Resourses.Corn;
import Resourses.Water;

import java.io.Serializable;
import java.util.ArrayList;

public class Cow extends RawCattle implements Serializable {
    public Cow() {
        Name("Cow");


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
    public ArrayList<AbstractRaw> Harvest() {

        ArrayList<AbstractRaw> rawArrayList = new ArrayList<>();
        Milk milk = new Milk();
        rawArrayList.add(milk);

        if (isDead())
        {
            Meat meat = new Meat();
            rawArrayList.add(meat);
        }
        return rawArrayList;
    }
}
