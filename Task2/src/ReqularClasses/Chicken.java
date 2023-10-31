package ReqularClasses;

import CattleType.RawCattle;

public class Chicken extends RawCattle {
    private Boolean SEX;
    public Boolean GetSex()
    {
        return SEX;
    }


    public Chicken()
    {
        setName("Chicken");
    }
    public Chicken(boolean sex)
    {
        setName("Chicken");
        this.SEX = sex;
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
