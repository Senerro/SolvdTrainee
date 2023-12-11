package com.solvd.mavenFarm.managers.Comparators;


import com.solvd.mavenFarm.cattleType.RawCattle;

import java.io.Serializable;
import java.util.Comparator;

public class RawCattleNameComparator implements Serializable, Comparator<RawCattle> {
    @Override
    public int compare(RawCattle a, RawCattle b){

        return a.name().compareTo(b.name());
    }
}
