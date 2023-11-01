package CattleType.ReqularRawCattle;

import CattleType.RawCattle;

import java.io.Serializable;

public class Chicken extends RawCattle implements Serializable {
    private boolean SEX;
    public Boolean GetSex()
    {
        return SEX;
    }


    public Chicken()
    {
        SetName("Chicken");
    }
    public Chicken(boolean sex)
    {
        SetName("Chicken");
        this.SEX = sex;
    }
    public void SetChickenSex (boolean sex)
    {
        this.SEX=sex;
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
    public void GetSomeRaw() {
        System.out.println("Generic eggs");
        System.out.println("Generic feathers");
        if (isDead) System.out.println("Generic myself meat");
    }
}
