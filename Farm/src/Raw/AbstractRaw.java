package Raw;

import Resourses.AbstractResourse;

import java.io.Serializable;

import static Farm.Farm.CurrentDayStatic;

public class AbstractRaw extends AbstractResourse implements Serializable
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


    public void ShelfLife(final float shelfLife) {
        this.shelfLife = shelfLife;
    }
    public int SpawnDay()
    {
        return this.spawnDay;
    }
    public boolean IsRot(final int today)
    {
        if(SpawnDay() + ShelfLife() < today)
        {
            Rot(this);
        }
        return false;
    }
    public String toString() {
        return "Cattle{" + "name='" + this.Name() + ", collected in day ='" + this.SpawnDay() + ", shelfLife is ='" + this.ShelfLife()+'}';
    }

    private void Rot(AbstractRaw raw)
    {
        
    }

}
