package CattleType.ReqularWorkCattle;

import CattleType.WorkCastle;

public class Horse extends WorkCastle {

    private float maxEndurance;
    private float currentEndurance;

    public float getCurrentEndurance() {
        return currentEndurance;
    }

    public float getMaxEndurance() {
        return maxEndurance;
    }
    public void SetMaxEndurance(float maxEndurance)
    {
        this.maxEndurance = maxEndurance;
    }
    public void ChangeCurrentEndurance(float endurance)
    {
        this.currentEndurance += endurance;
        if(currentEndurance > maxEndurance)
            currentEndurance = maxEndurance;
    }

    public Horse() {
        SetName("Horse");}
    @Override
    public void Eat()
    {
        System.out.println("I need vegetables");
    }

    @Override
    public void Drink() {
        System.out.println("I need water");
    }
    @Override
    public void GrowUp() {
        System.out.println("I will grow up till I die");
    }

    @Override
    public void DoSomeWork() {
        System.out.println("I am able to relocate some things");
    }
}
