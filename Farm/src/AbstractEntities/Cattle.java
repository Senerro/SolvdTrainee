package AbstractEntities;

public abstract class Cattle extends Farming
{
    protected float workingHours;
    protected Boolean isDead;
    protected int age;
    public int GetAge()
    {
        return age;
    }
    public void SetAge(int age)
    {

            if (age >= 0) {
                this.age = age;
            } else {var ex = new Exception("Age can not be negative");}
    }
}
