package Farm;
import AbstractEntities.Farming;
import CattleType.RawCattle;
import CattleType.ReqularRawCattle.Chicken;
import CattleType.ReqularRawCattle.Cow;
import CattleType.ReqularRawCattle.Pig;
import CattleType.ReqularRawCattle.Sheep;
import CattleType.ReqularWorkCattle.Bull;
import CattleType.ReqularWorkCattle.Horse;
import CattleType.WorkCastle;
import FoodTypes.FruitSpawn;
import FoodTypes.ReqularFruitsSpawn.Appletree;
import FoodTypes.ReqularVegetablesSpawn.Cabbage;
import FoodTypes.ReqularFruitsSpawn.LemonTree;
import FoodTypes.ReqularVegetablesSpawn.Potato;
import FoodTypes.VegetableSpawn;
import Resourses.ResoursesContainer;

import java.io.Serializable;

public class Farm implements Serializable {

    private static int purchase;
    private int currentDay = 1;
    private float balance = 5000;
    public ResoursesContainer container = new ResoursesContainer();

    public float Balance() {
        return balance;
    }


    public void Balance(float balance) {
        this.balance = balance;
    }
    public void ChangeBalanse(float balance)
    {
        this.balance += balance;
    }

    public int CurrentDay() {
        return currentDay;
    }
    public void ChangeCurrentDay()
    {
        currentDay++;
    }


    public FarmingList farmingList = new FarmingList();

    public void PlantAppleTree(int count, String sort)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Appletree();
            acquisition.Name("Apple tree number " + i + " from procurement " + purchase);
            acquisition.SetCropYield(50);
            acquisition.Sort(sort);
            farmingList.AddFruitSpawn(acquisition);
        }
    }
    public void BullPurchase (int count, int age, float tonnage)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Bull();
            acquisition.Name("Bull number " + i + " from procurement " + purchase);
            acquisition.SetTonage(tonnage);
            acquisition.Age(age);
            farmingList.AddWorkCastles(acquisition);
        }
    }
    public void PlantCabbage (int count, String sort)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Cabbage();
            acquisition.Sort(sort);
            farmingList.AddVegetableSpawn(acquisition);
        }
    }
    public boolean BuySomeFarming(RawCattle production, Farm farm)
    {
        if (IsAbleToBuy(production)) {
            farmingList.AddRawCattle(production);
            farm.ChangeBalanse(-production.CurrentCost());
            farm.farmingList.GetMarketRawCattleSellList().remove(production);
            return true;
        }
        return false;
    }
    public void BuySomeFarming(WorkCastle production)
    {
        if (IsAbleToBuy(production))
            farmingList.AddWorkCastles(production);
    }
    public void BuySomeFarming(FruitSpawn production)
    {
        if (IsAbleToBuy(production))
            farmingList.AddFruitSpawn(production);
    }
    public void BuySomeFarming(VegetableSpawn production)
    {
        if (IsAbleToBuy(production))
            farmingList.AddVegetableSpawn(production);
    }

    private boolean IsAbleToBuy(Farming farming) {
        return this.balance>= farming.CurrentCost();
    }

    public void ChickenPurchase (int count, int age, boolean sex)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Chicken();
            acquisition.Name("Chicken number " + i + " from procurement " + purchase);
            acquisition.Age(age);
            acquisition.Age(i);
            farmingList.AddRawCattle(acquisition);
        }
    }
    public void CowPurchase (int count, int age)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Cow();
            acquisition.Name("Cow number " + i + " from procurement " + purchase);
            acquisition.Age(age);
            acquisition.SetColor(0);//black
            farmingList.AddRawCattle(acquisition);
        }
    }

    public void HorsePurchase (int count, int age, int endurance)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Horse();
            acquisition.Name("horse number " + i + " from procurement " + purchase);
            acquisition.SetMaxEndurance(endurance);
            acquisition.Age(age);
            farmingList.AddWorkCastles(acquisition);
        }
    }
    public void PlantLemonTree(int count)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new LemonTree();
            acquisition.Name("Lemon tree number " + i + " from procurement " + purchase);
            acquisition.SetCropYield(50);
            acquisition.SetAcidLevel(4);//very acid
            farmingList.AddFruitSpawn(acquisition);
        }
    }
    public void PigPurchase (int count, int age)
    {
        purchase++;
        for (int i = 0; i < count; i++) {
            var acquisition = new Pig();
            acquisition.Name("Pig number " + i + " from procurement " + purchase);
            acquisition.Age(age);
            farmingList.AddRawCattle(acquisition);
        }
    }
    public void PlantPotato (int count, String sort)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Potato();
            acquisition.Sort(sort);
            acquisition.Name("Potato number " + i + " from procurement" + purchase);
            acquisition.Sort(sort);
            acquisition.SetSize(2);// little
            farmingList.AddVegetableSpawn(acquisition);
        }
    }
    public void SheepPurchase (int count, int age)
    {
        purchase++;
        for (int i = 0; i < count; i++) {
            var acquisition = new Sheep();
            acquisition.Name("Sheep number " + i + " from procurement " + purchase);
            acquisition.Age(age);
            farmingList.AddRawCattle(acquisition);
        }
    }

    public void ChangeCurrentResurse(Farm farm) {
        for (int i = 0; i < farm.farmingList.GetRawCattleList().size(); i++)
        {
            farm.container.ReduceResource(farm.farmingList.GetRawCattleList().get(i));
        }

    }
    public float GetAllRawCost()
    {
        float totalPrice = 0f;
        for (int i = 0; i < this.farmingList.GetRawFromFarmList().size(); i++)
        {
           totalPrice +=  this.farmingList.GetRawFromFarmList().get(i).DefaultCost();
        }
        return totalPrice;
    }
}
