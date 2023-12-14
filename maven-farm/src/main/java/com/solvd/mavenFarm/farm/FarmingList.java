package com.solvd.mavenFarm.farm;
import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.managers.Comparators.RawCattleAgeComparator;
import com.solvd.mavenFarm.managers.Comparators.RawCattleNameComparator;
import com.solvd.mavenFarm.managers.Comparators.RawCattleWeighComparator;
import com.solvd.mavenFarm.raw.AbstractRaw;
import com.solvd.mavenFarm.raw.Egg;
import com.solvd.mavenFarm.resourses.AbstractResource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.Serializable;
import java.util.*;

public final class FarmingList implements Serializable {
    static final Logger LOGGER = LogManager.getLogger(Egg.class);
    Comparator<RawCattle> RCcomp = new RawCattleNameComparator().thenComparing(new RawCattleAgeComparator()).thenComparing(new RawCattleWeighComparator());
    ArrayList<RawCattle> rawCattleList = new ArrayList<>();
    ArrayList<RawCattle> marketRawCattleSellList = new ArrayList<>();

    HashMap<Integer, RawCattle> rawCattleHashMap = new HashMap<>();
    TreeSet<RawCattle> animal = new TreeSet<>(RCcomp);
    ArrayList<AbstractRaw> rawFarmArrayList = new ArrayList<>();
    ArrayList<AbstractRaw> rawMarcketArrayList = new ArrayList<>();

    public void rawCattleHashMap(RawCattle animal) {
        boolean isUnique= true;
        if(rawCattleHashMap.containsKey(animal.hashCode())) {
            for (RawCattle element : rawCattleHashMap.values()) {
                if (element.equals(animal)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                LOGGER.warn("RawCattle animal was rewritten to this animal ->" + animal.toString());
                rawCattleHashMap.put(animal.hashCode(), animal);
            }
        }
        else
            rawCattleHashMap.put(animal.hashCode(), animal);
    }

    public  void animal() {
        animal.clear();
        animal.addAll(rawCattle());
    }

    public  ArrayList<RawCattle> animal(int a) {
        return new ArrayList<>(animal);
    }

    public ArrayList<RawCattle> rawCattleHashMap() {
        return new ArrayList<>(rawCattleHashMap.values());
    }

    public void purgeRawFarmList() {
        this.rawFarmArrayList.clear();
    }

    public void purgeRawFarm(AbstractRaw raw) {
        this.rawFarmArrayList.remove(raw);
    }

    public ArrayList<RawCattle> rawCattle() {
        return rawCattleList;
    }

    public void rawCattle(final RawCattle animal) {
            this.rawCattleList.add(animal);
    }

    public ArrayList<RawCattle> marketRawCattleSellList() {
        return this.marketRawCattleSellList;
    }

    public void purgeMarketRawCattle(RawCattle cattle) {
        marketRawCattleSellList().remove(cattle);
    }

    public void marketRawCattleSellList(final RawCattle cattle) {
        this.marketRawCattleSellList.add(cattle);
    }
    public void rawFarm(final AbstractRaw raw) {
        this.rawFarmArrayList.add(raw);
    }

    public void rawInMarketList(final AbstractRaw raw) {
        this.rawMarcketArrayList.add(raw);
    }

    public ArrayList<AbstractRaw> rawFarm() {
        return this.rawFarmArrayList;
    }

    public ArrayList<AbstractRaw> rawFromMarketList() {
        return this.rawFarmArrayList;
    }
}