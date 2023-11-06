package Farm;

import CattleType.RawCattle;
import CattleType.WorkCastle;
import FoodTypes.FruitSpawn;
import FoodTypes.VegetableSpawn;
import Interfaces.IChunkable;
import Raw.AbstractRaw;
import Resourses.AbstractResourse;

import java.io.Serializable;
import java.util.ArrayList;

public final class FarmingList implements Serializable, IChunkable {
    ArrayList<FruitSpawn> fruitArrayList = new ArrayList<FruitSpawn>();
    ArrayList<VegetableSpawn> vegetablesList = new ArrayList<VegetableSpawn>();
    ArrayList<RawCattle> rawCattleList = new ArrayList<RawCattle>();
    ArrayList<WorkCastle> workCastlesList = new ArrayList<WorkCastle>();
    ArrayList<RawCattle> marketRawCattleSellList = new ArrayList<RawCattle>();
    ArrayList<FruitSpawn> marketFruitSpawnSellList = new ArrayList<FruitSpawn>();

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
        for (var element:RawCattle())
        {
           if(!MergeInChunk(element, animal))
           {
               this.rawCattleList.add(animal);
           }
        }
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

    public ArrayList<FruitSpawn> MarketFruitSpawnSellList() {
        return this.marketFruitSpawnSellList;
    }

    public void MarketRawCattleSellList(final RawCattle cattle) {
        this.marketRawCattleSellList.add(cattle);
    }

    public void MarketFruitSpawnSellList(final FruitSpawn fruitSpawn) {
        this.marketFruitSpawnSellList.add(fruitSpawn);
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