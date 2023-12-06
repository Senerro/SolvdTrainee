package com.solvd.mavenFarm.managers.Comparators;


import com.solvd.mavenFarm.cattleType.RawCattle;

import java.io.Serializable;
import java.util.Comparator;

public class RawCattleWeighComparator implements Serializable, Comparator<RawCattle> {
    @Override
    public int compare(RawCattle animal1, RawCattle animal2){

        return Float.compare(animal2.cattleWeight(), animal1.cattleWeight());
    }
}
