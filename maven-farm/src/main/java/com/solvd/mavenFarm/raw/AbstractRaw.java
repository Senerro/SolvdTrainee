package com.solvd.mavenFarm.raw;

import com.solvd.mavenFarm.exception.ShelfLifeException;
import com.solvd.mavenFarm.farm.Farm;
import com.solvd.mavenFarm.interfaces.IRotting;
import com.solvd.mavenFarm.resourses.AbstractResource;

import java.io.Serializable;

import static com.solvd.mavenFarm.farm.Farm.*;


public class AbstractRaw extends AbstractResource implements Serializable, IRotting
{
    AbstractRaw()
    {
        spawnDay = Farm.currentDayStatic();
    }
    private final int spawnDay;
    private float shelfLife;
    public float shelfLife() {
        return shelfLife;
    }
    public void shelfLife(final float shelfLife) throws ShelfLifeException {
        if(shelfLife<=0)
            throw new ShelfLifeException("Resource must have period of lide", shelfLife);
        this.shelfLife = shelfLife;
    }
    public int spawnDay()
    {
        return this.spawnDay;
    }

    public String toString() {
        return "Cattle{" + "name='" + this.name() + ", collected in day ='" + this.spawnDay() + ", shelfLife is ='" + this.shelfLife()+'}';
    }
    @Override
    public boolean isRot() {
           return (spawnDay() + shelfLife() < currentDayStatic());
        }

}
