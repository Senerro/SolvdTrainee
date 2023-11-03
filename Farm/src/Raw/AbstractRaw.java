package Raw;

import Resourses.AbstractResourse;

import java.io.Serializable;

public class AbstractRaw extends AbstractResourse implements Serializable
{

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

    private void Rot(AbstractRaw raw)
    {

    }

}
