package Managers.Comparators;

import CattleType.RawCattle;

import java.util.Comparator;

public class RawCattleNameComparator implements Comparator<RawCattle> {
    @Override
    public int compare(RawCattle a, RawCattle b){

        return a.Name().compareTo(b.Name());
    }
}
