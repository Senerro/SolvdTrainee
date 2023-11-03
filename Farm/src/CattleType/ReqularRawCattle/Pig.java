package CattleType.ReqularRawCattle;

import CattleType.RawCattle;
import Raw.Meat;
import Resourses.Corn;

import java.io.Serializable;

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
        ID = 3;
        this.CattleWeight(250);
        this.DefaultCost(3 * CattleWeight());
        Corn corn = new Corn();
        this.LiquidAbstractResourse(corn);
        this.SolidResourseVolumRequierment(150);
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
    public void SomeRaw() {

        if (isDead())
        {
            Meat meat = new Meat();
            this.Raw(meat);
        }

    }
}
