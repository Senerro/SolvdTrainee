package com.solvd.mavenFarm.managers.Comparators;



import com.solvd.mavenFarm.cattleType.RawCattle;

import java.util.Comparator;

public class RawCattleAgeComparator implements Comparator<RawCattle> {
    @Override
    public int compare(RawCattle animal1, RawCattle animal2){

        return Integer.compare(animal2.age(), animal1.age());
    }
}
