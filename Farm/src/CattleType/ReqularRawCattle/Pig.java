package CattleType.ReqularRawCattle;

import CattleType.RawCattle;
import Raw.AbstractRaw;
import Raw.Egg;
import Raw.Meat;
import Resourses.Corn;
import Resourses.Water;

import java.io.Serializable;
import java.util.ArrayList;

public class Pig extends RawCattle implements Serializable {
    private float mass;
    public float GetMass()
    {return this.mass;}
    public void SetMass(float mass)
    {
        this.mass = mass;
    }
    public Pig()
    {
        Name("Pig");


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
        System.out.println("I need seed");
    }

    @Override
    public void Drink() {
        System.out.println("I need water in 4 times more than seed");

    }
    @Override
    public void GrowUp() {
        System.out.println("I will grow up till I'm 3");
    }

    @Override
    public ArrayList<AbstractRaw> Harvest() {

        ArrayList<AbstractRaw> rawArrayList = new ArrayList<>();

        if (isDead())
        {
            Meat meat = new Meat();
            rawArrayList.add(meat);
        }
        return rawArrayList;
    }
}
