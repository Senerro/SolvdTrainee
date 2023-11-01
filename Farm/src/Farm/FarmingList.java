package Farm;

import CattleType.RawCattle;
import CattleType.WorkCastle;
import FoodTypes.FruitSpawn;
import FoodTypes.Vegetable;

import java.io.Serializable;
import java.util.ArrayList;

public class FarmingList implements Serializable
{
    ArrayList<FruitSpawn> fruitArrayList = new ArrayList<FruitSpawn>();
    ArrayList<Vegetable> vegetablesList = new ArrayList<Vegetable>();
    ArrayList<RawCattle> rawCattleList = new ArrayList<RawCattle>();
    ArrayList<WorkCastle> workCastlesList = new ArrayList<WorkCastle>();
    public ArrayList<Vegetable> GetVegetablesList() {
        return vegetablesList;
    }
    public  ArrayList<FruitSpawn> GetFruitArrayList()
    {
        return fruitArrayList;
    }

    public ArrayList<RawCattle> GetRawCattleList() {
        return rawCattleList;
    }

    public ArrayList<WorkCastle> GetWorkCastlesList() {
        return workCastlesList;
    }



    public void AddFruit(FruitSpawn fruit) {
        this.fruitArrayList.add(fruit);
    }

    public void AddRawCattle(RawCattle animal) {
        this.rawCattleList.add(animal);
    }

    public void AddVegetable(Vegetable vegetable) {
        this.vegetablesList.add(vegetable);
    }

    public void AddWorkCastles(WorkCastle animal) {
        this.workCastlesList.add(animal);
    }
}
