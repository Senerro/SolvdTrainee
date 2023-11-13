package Managers.Comparators;

import CattleType.RawCattle;

import java.util.Comparator;

public class RawCattleAgeComparator implements Comparator<RawCattle> {
    @Override
    public int compare(RawCattle animal1, RawCattle animal2){

        return Integer.compare(animal2.Age(), animal1.Age());
    }
}
