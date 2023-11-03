package AbstractEntities;

import java.io.Serializable;

public abstract class Cattle extends Farming implements Serializable
{
    protected float workingHours;
    protected Boolean isDead;
    protected int age;

    public int Age()
    {
        return age;
    }
    public void Age(int age)
    {

            if (age >= 0) {
                this.age = age;
            } else {var ex = new Exception("Age can not be negative");}
    }
}
