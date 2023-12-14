package com.solvd.mavenFarm.managers.Comparators;

import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.raw.AbstractRaw;

import java.io.Serializable;
import java.util.Comparator;

public class RawRottenComparator implements Serializable, Comparator<AbstractRaw>
{
    public int compare(AbstractRaw animal1, AbstractRaw animal2){
        return Float.compare(animal2.spawnDay() - animal2.shelfLife(), animal1.spawnDay()-animal1.shelfLife());
    }
}

