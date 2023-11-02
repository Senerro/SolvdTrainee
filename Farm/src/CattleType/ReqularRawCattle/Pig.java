package CattleType.ReqularRawCattle;

import CattleType.RawCattle;
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
        SetName("Pig");
        ID = 3;
        this.SetCattleWeight(250);
        this.SetDefaultCost(3 * GetCattleWeight());
        Corn corn = new Corn();
        this.SetAbstractResourse(corn);
        this.SetResourseVolumRequierment(150);
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
    public void GetSomeRaw() {
        if (isDead())
        {   System.out.println("Generic myself meat");
            System.out.println("Generic myself lard");
        }

    }
}
