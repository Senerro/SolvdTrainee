package Raw;

import Interfaces.IRotting;
import Resourses.AbstractResourse;
import Exception.*;

import java.io.Serializable;

import static Farm.Farm.CurrentDayStatic;

public class AbstractRaw extends AbstractResourse implements Serializable, IRotting
{
    AbstractRaw()
    {
        spawnDay = CurrentDayStatic();
    }
    private final int spawnDay;

    private float shelfLife;
    public float ShelfLife() {
        return shelfLife;
    }


    public void ShelfLife(final float shelfLife) throws ShelfLifeException {
        if(shelfLife<=0)
            throw new ShelfLifeException("Resource must have period of lide", shelfLife);
        this.shelfLife = shelfLife;
    }
    public int SpawnDay()
    {
        return this.spawnDay;
    }

    public String toString() {
        return "Cattle{" + "name='" + this.Name() + ", collected in day ='" + this.SpawnDay() + ", shelfLife is ='" + this.ShelfLife()+'}';
    }


    @Override
    public boolean IsRot() {
           return (SpawnDay() + ShelfLife() < CurrentDayStatic());
        }

}
