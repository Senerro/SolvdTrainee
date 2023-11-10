package AbstractEntities;
import Exception.CattleAgeException;
import org.apache.log4j.Logger;

import java.io.Serializable;

public abstract class Cattle extends Farming implements Serializable
{
    private static final Logger LOGGER = Logger.getLogger(Cattle.class);

    protected float workingHours;
    protected int age;

    public int Age()
    {
        return age;
    }
    public void Age(final int age)
    {
            if (age <= 0) {
                try {
                    throw new CattleAgeException(age);
                }
                catch (CattleAgeException e)
                {
                    this.age = 1;
                    LOGGER.warn(e.GetInfo());
                }
            }
        this.age = age;
    }
}
