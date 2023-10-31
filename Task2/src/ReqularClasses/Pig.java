package ReqularClasses;

import CattleType.RawCattle;

public class Pig extends RawCattle {
    private float mass;
    public float GetMass()
    {return this.mass;}
    public void SetMass(float mass)
    {
        this.mass = mass;
    }
    public Pig() {setName("Pig");}
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
        if (isDead)
        {   System.out.println("Generic myself meat");
            System.out.println("Generic myself lard");
        }

    }
}
