package CattleType.ReqularWorkCattle;

import CattleType.WorkCastle;
import Resourses.Corn;
import Resourses.Water;

import java.io.Serializable;

public class Bull extends WorkCastle implements Serializable {
    private float tonnage;

    public float Tonnage() {
        return tonnage;
    }
    public void Tonnage(float tonnage)
    {this.tonnage = tonnage;}

    public Bull()
    {
        Name("Bull");

        Corn corn = new Corn();
        Water water = new Water();


        this.DefaultCost(2.5f);
        this.DefaultCost(this.DefaultCost() * this.Tonnage());
        this.LiquidAbstractResource(water);
        this.LiquidResourceVolumeRequirement(50);
        this.SolidAbstractResource(corn);
        this.SolidResourceVolumeRequirement(50);
    }
    @Override
    public void Eat()
    {
        System.out.println("I need grass and vegetables");
    }

    @Override
    public void Drink() {
        System.out.println("I need water");

    }
    @Override
    public void GrowUp() {
        System.out.println("I will grow till I am 7");
    }

    @Override
    public void DoSomeWork() {
        System.out.println("I am able to work in field");
    }
}
