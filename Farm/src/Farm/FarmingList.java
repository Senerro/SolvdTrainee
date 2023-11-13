package Farm;

import CattleType.RawCattle;
import CattleType.WorkCastle;
import FoodTypes.FruitSpawn;
import FoodTypes.VegetableSpawn;
import Interfaces.IChunkable;
import Managers.Comparators.RawCattleAgeComparator;
import Managers.Comparators.RawCattleNameComparator;
import Managers.Comparators.RawCattleWeighComparator;
import Raw.AbstractRaw;
import Raw.Egg;
import Resourses.AbstractResourse;
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
    ArrayList<WorkCastle> workCastlesList = new ArrayList<>();
    ArrayList<RawCattle> marketRawCattleSellList = new ArrayList<>();

    LinkedList<FruitSpawn> marketFruitSpawnSellLinkedList = new LinkedList<>();
    public void MarketFruitSpawnSellLinkedList(final FruitSpawn fruitSpawn) {
        this.marketFruitSpawnSellLinkedList.add(fruitSpawn);
    }
    public LinkedList<FruitSpawn> MarketFruitSpawnSellLinkedList() {
        return this.marketFruitSpawnSellLinkedList;
    }
    HashMap<Integer, RawCattle> rawCattleHashMap = new HashMap<>();
    public void RawCattleHashMap(RawCattle animal)
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
    public  void Animal()
    {
        animal.clear();
        animal.addAll(RawCattle());
    }
    public  ArrayList<RawCattle> Animal(int a)
    {
        return new ArrayList<>(animal);
    }
    public ArrayList<RawCattle> RawCattleHashMap()
    {
        return new ArrayList<>(rawCattleHashMap.values());
    }

    ArrayList<AbstractRaw> rawFarmArrayList = new ArrayList<>();
    ArrayList<AbstractRaw> rawMarcketArrayList = new ArrayList<>();
    ArrayList<AbstractResourse> resoursesArrayList = new ArrayList<>();



    public void PurgeRawFarmList()
    {
        this.rawFarmArrayList.clear();
    }
    public void PurgeRawFarm(AbstractRaw raw)
    {
        this.rawFarmArrayList.remove(raw);
    }

    public ArrayList<AbstractResourse> ResoursesArrayList()
    {
        return this.resoursesArrayList;
    }


    public ArrayList<VegetableSpawn> VegetablesList() {
        return vegetablesList;
    }

    public ArrayList<FruitSpawn> FruitArrayList() {
        return fruitArrayList;
    }


    public ArrayList<RawCattle> RawCattle() {
        return rawCattleList;
    }


    public ArrayList<WorkCastle> WorkCastlesList() {
        return workCastlesList;
    }


    public void FruitSpawn(final FruitSpawn fruit) {
        this.fruitArrayList.add(fruit);
    }

    public void RawCattle(final RawCattle animal) {
        if(RawCattle().isEmpty())
            this.rawCattleList.add(animal);
        else
        {
           // for (var element : RawCattle()) {
               // if (!MergeInChunk(element, animal))
                    this.rawCattleList.add(animal);
                }
           // }


    }
    public void VegetableSpawn(final VegetableSpawn vegetable) {
        this.vegetablesList.add(vegetable);
    }

    public void WorkCastles(final WorkCastle animal) {
        this.workCastlesList.add(animal);
    }

    public ArrayList<RawCattle> MarketRawCattleSellList() {
        return this.marketRawCattleSellList;
    }
    public void PurgeMarketRawCattle(RawCattle cattle) {
       MarketRawCattleSellList().remove(cattle);
    }



    public void MarketRawCattleSellList(final RawCattle cattle) {
        this.marketRawCattleSellList.add(cattle);
    }



    public void RawFarm(final AbstractRaw raw) {
        this.rawFarmArrayList.add(raw);
    }

    public void RawInMarketList(final AbstractRaw raw) {
        this.rawMarcketArrayList.add(raw);
    }

    public ArrayList<AbstractRaw> RawFarm() {
        return this.rawFarmArrayList;
    }


    public ArrayList<AbstractRaw> RawFromMarketList() {
        return this.rawFarmArrayList;
    }

    @Override
    public boolean MergeInChunk(RawCattle animal, RawCattle animal2) {
        if(animal.equals(animal2)) {
            animal.IncreaseChunk(animal2.Chunk());
            return true;
        }
        return false;
    }
}