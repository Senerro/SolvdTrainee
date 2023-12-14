package com.solvd.mavenFarm.raw;
import com.solvd.mavenFarm.farm.Farm;
import com.solvd.mavenFarm.interfaces.IRotting;
import com.solvd.mavenFarm.resourses.AbstractResource;
import java.io.Serializable;
import static com.solvd.mavenFarm.farm.Farm.currentDayStatic;


public class AbstractRaw extends AbstractResource implements Serializable, IRotting
{
    private final int spawnDay;
    private float shelfLife;

    AbstractRaw() {
        spawnDay = Farm.currentDayStatic();
    }

    public float shelfLife() {
        return shelfLife;
    }

    public void shelfLife(final float shelfLife) {
        this.shelfLife = shelfLife;
    }

    public int spawnDay() {
        return this.spawnDay;
    }

    @Override
    public String toString() {
        return "Cattle{" + "name='" + this.name() + ", collected in day ='" + this.spawnDay() + ", shelfLife is ='" + this.shelfLife()+'}';
    }
    @Override
    public boolean isRot() {
           return (spawnDay() + shelfLife() < currentDayStatic());
        }

}
