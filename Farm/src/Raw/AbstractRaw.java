package Raw;

import Resourses.AbstractResourse;

import java.io.Serializable;

import static Farm.Farm.CurrentDay;

public class AbstractRaw extends AbstractResourse implements Serializable
{
    AbstractRaw()
    {
        spawnDay = CurrentDay();
    }
    private float volume = 0f;
    private int spawnDay;

    private float shelfLife = 0f;
    public float ShelfLife() {
        return shelfLife;
    }


    public void ShelfLife(float shelfLife) {
        this.shelfLife = shelfLife;
    }
    public int SpawnDay()
    {
        return this.spawnDay;
    }
    public void SpawnDay(int spawnDay)
    {
        this.spawnDay = spawnDay;
    }
    public boolean IsRot(int today)
    {
        if(SpawnDay() + ShelfLife() < today)
        {
            Rot(this);
        }
        return false;
    }
    public String toString() {
        return "Cattle{" + "name='" + this.Name() + ", collected in day ='" + this.spawnDay + ", shelfLife is ='" + this.shelfLife+'}';
    }

    private void Rot(AbstractRaw raw)
    {

    }

}
