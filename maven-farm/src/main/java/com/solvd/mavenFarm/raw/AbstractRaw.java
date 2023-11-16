package com.solvd.mavenFarm.raw;

import com.solvd.mavenFarm.exception.ShelfLifeException;
import com.solvd.mavenFarm.interfaces.IRotting;
import com.solvd.mavenFarm.resourses.AbstractResource;

import java.io.Serializable;

import static com.solvd.mavenFarm.farm.Farm.*;


public class AbstractRaw extends AbstractResource implements Serializable, IRotting
{
    AbstractRaw()
    {
        spawnDay = currentDayStatic();
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
           return (SpawnDay() + ShelfLife() < currentDayStatic());
        }

}
