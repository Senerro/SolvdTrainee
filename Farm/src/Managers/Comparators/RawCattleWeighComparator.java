package Managers.Comparators;

import CattleType.RawCattle;

import java.util.Comparator;

public class RawCattleWeighComparator implements Comparator<RawCattle> {
    @Override
    public int compare(RawCattle animal1, RawCattle animal2){

        return Float.compare(animal2.CattleWeight(), animal1.CattleWeight());
    }
}
