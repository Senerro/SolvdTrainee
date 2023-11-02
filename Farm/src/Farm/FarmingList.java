package Farm;

import CattleType.RawCattle;
import CattleType.WorkCastle;
import FoodTypes.FruitSpawn;
import FoodTypes.VegetableSpawn;
import Raw.AbstractRaw;

import java.io.Serializable;
import java.util.ArrayList;

public class FarmingList implements Serializable {
    ArrayList<FruitSpawn> fruitArrayList = new ArrayList<FruitSpawn>();
    ArrayList<VegetableSpawn> vegetablesList = new ArrayList<VegetableSpawn>();
    ArrayList<RawCattle> rawCattleList = new ArrayList<RawCattle>();
    ArrayList<WorkCastle> workCastlesList = new ArrayList<WorkCastle>();
    ArrayList<RawCattle> marketRawCattleSellList = new ArrayList<RawCattle>();
    ArrayList<FruitSpawn> marketFruitSpawnSellList = new ArrayList<FruitSpawn>();

    ArrayList<AbstractRaw> rawFarmArrayList = new ArrayList<>();
    ArrayList<AbstractRaw> rawMarcketArrayList = new ArrayList<>();

    public ArrayList<VegetableSpawn> GetVegetablesList() {
        return vegetablesList;
    }

    public ArrayList<FruitSpawn> GetFruitArrayList() {
        return fruitArrayList;
    }


    public ArrayList<RawCattle> GetRawCattleList() {
        return rawCattleList;
    }

    public ArrayList<WorkCastle> GetWorkCastlesList() {
        return workCastlesList;
    }


    public void AddFruitSpawn(FruitSpawn fruit) {
        this.fruitArrayList.add(fruit);
    }

    public void AddRawCattle(RawCattle animal) {
        this.rawCattleList.add(animal);
    }

    public void AddVegetableSpawn(VegetableSpawn vegetable) {
        this.vegetablesList.add(vegetable);
    }

    public void AddWorkCastles(WorkCastle animal) {
        this.workCastlesList.add(animal);
    }

    public ArrayList<RawCattle> GetMarketRawCattleSellList() {
        return this.marketRawCattleSellList;
    }

    public ArrayList<FruitSpawn> GetMarketFruitSpawnSellList() {
        return this.marketFruitSpawnSellList;
    }

    public void AddMarketRawCattleSellList(RawCattle cattle) {
        this.marketRawCattleSellList.add(cattle);
    }

    public void AddMarketFruitSpawnSellList(FruitSpawn fruitSpawwn) {
        this.marketFruitSpawnSellList.add(fruitSpawwn);
    }

    public void AddRawInFarmList(AbstractRaw raw) {
        this.rawFarmArrayList.add(raw);
    }

    public void AddRawInMarketList(AbstractRaw raw) {
        this.rawMarcketArrayList.add(raw);
    }

    public ArrayList<AbstractRaw> GetRawFromFarmList() {
        return this.rawFarmArrayList;
    }

    public ArrayList<AbstractRaw> GetRawFromMarketList() {
        return this.rawFarmArrayList;
    }
}