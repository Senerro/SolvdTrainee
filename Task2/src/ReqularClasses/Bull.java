package ReqularClasses;

import CattleType.WorkCastle;

public class Bull extends WorkCastle {
    private float tonnage;

    public float GetTonnage() {
        return tonnage;
    }
    public void SetTonage(float tonage)
    {this.tonnage = tonnage;}

    public Bull()
    {
        setName("Bull");
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
