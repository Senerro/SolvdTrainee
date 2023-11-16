package com.solvd.mavenFarm.farm;






import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.cattleType.WorkCattle;
import com.solvd.mavenFarm.foodTypes.FruitSpawn;
import com.solvd.mavenFarm.foodTypes.VegetableSpawn;
import com.solvd.mavenFarm.interfaces.IChunkable;
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

public final class FarmingList implements Serializable, IChunkable {
    static final Logger LOGGER = LogManager.getLogger(Egg.class);
    Comparator<RawCattle> RCcomp = new RawCattleNameComparator().thenComparing(new RawCattleAgeComparator()).thenComparing(new RawCattleWeighComparator());
    ArrayList<FruitSpawn> fruitArrayList = new ArrayList<>();
    ArrayList<VegetableSpawn> vegetablesList = new ArrayList<>();
    ArrayList<RawCattle> rawCattleList = new ArrayList<>();
    ArrayList<WorkCattle> workCastlesList = new ArrayList<>();
    ArrayList<RawCattle> marketRawCattleSellList = new ArrayList<>();

    LinkedList<FruitSpawn> marketFruitSpawnSellLinkedList = new LinkedList<>();
    public void marketFruitSpawnSellLinkedList(final FruitSpawn fruitSpawn) {
        this.marketFruitSpawnSellLinkedList.add(fruitSpawn);
    }
    public LinkedList<FruitSpawn> marketFruitSpawnSellLinkedList() {
        return this.marketFruitSpawnSellLinkedList;
    }
    HashMap<Integer, RawCattle> rawCattleHashMap = new HashMap<>();
    public void rawCattleHashMap(RawCattle animal)
    {
        boolean isUnique= true;
        if(rawCattleHashMap.containsKey(animal.hashCode())) {
            for (var element : rawCattleHashMap.values()) {
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
    TreeSet<RawCattle> animal = new TreeSet<>(RCcomp);
    public  void animal()
    {
        animal.clear();
        animal.addAll(rawCattle());
    }
    public  ArrayList<RawCattle> animal(int a)
    {
        return new ArrayList<>(animal);
    }
    public ArrayList<RawCattle> rawCattleHashMap()
    {
        return new ArrayList<>(rawCattleHashMap.values());
    }

    ArrayList<AbstractRaw> rawFarmArrayList = new ArrayList<>();
    ArrayList<AbstractRaw> rawMarcketArrayList = new ArrayList<>();
    ArrayList<AbstractResource> resoursesArrayList = new ArrayList<>();



    public void PurgeRawFarmList()
    {
        this.rawFarmArrayList.clear();
    }
    public void PurgeRawFarm(AbstractRaw raw)
    {
        this.rawFarmArrayList.remove(raw);
    }

    public ArrayList<AbstractResource> resoursesArrayList()
    {
        return this.resoursesArrayList;
    }


    public ArrayList<VegetableSpawn> vegetablesList() {
        return vegetablesList;
    }

    public ArrayList<FruitSpawn> fruitArrayList() {
        return fruitArrayList;
    }


    public ArrayList<RawCattle> rawCattle() {
        return rawCattleList;
    }


    public ArrayList<WorkCattle> workCastlesList() {
        return workCastlesList;
    }


    public void FruitSpawn(final FruitSpawn fruit) {
        this.fruitArrayList.add(fruit);
    }

    public void rawCattle(final RawCattle animal) {
        if(rawCattle().isEmpty())
            this.rawCattleList.add(animal);
        else
        {
            // for (var element : RawCattle()) {
            // if (!MergeInChunk(element, animal))
            this.rawCattleList.add(animal);
        }
        // }


    }
    public void vegetableSpawn(final VegetableSpawn vegetable) {
        this.vegetablesList.add(vegetable);
    }

    public void workCastles(final WorkCattle animal) {
        this.workCastlesList.add(animal);
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

    @Override
    public boolean mergeInChunk(RawCattle animal, RawCattle animal2) {
        if(animal.equals(animal2)) {
            animal.increaseChunk(animal2.chunk());
            return true;
        }
        return false;
    }
}