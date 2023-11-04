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
    private static int currentDay = 1;
    private float balance = 500000;
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

    public static int CurrentDay() {
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
            acquisition.CropYield(50);
            acquisition.Sort(sort);
            farmingList.FruitSpawn(acquisition);
        }
    }
    public void BullPurchase (int count, int age, float tonnage)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Bull();
            acquisition.Name("Bull number " + i + " from procurement " + purchase);
            acquisition.Tonnage(tonnage);
            acquisition.Age(age);
            farmingList.WorkCastles(acquisition);
        }
    }
    public void PlantCabbage (int count, String sort)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Cabbage();
            acquisition.Sort(sort);
            farmingList.VegetableSpawn(acquisition);
        }
    }
    public boolean BuySomeFarming(RawCattle production, Farm farm)
    {
        if (IsAbleToBuy(production)) {
            farmingList.RawCattle(production);
            farm.ChangeBalanse(-production.CurrentCost());
            farm.farmingList.MarketRawCattleSellList().remove(production);
            return true;
        }
        return false;
    }
    public void BuySomeFarming(WorkCastle production)
    {
        if (IsAbleToBuy(production))
            farmingList.WorkCastles(production);
    }
    public void BuySomeFarming(FruitSpawn production)
    {
        if (IsAbleToBuy(production))
            farmingList.FruitSpawn(production);
    }
    public void BuySomeFarming(VegetableSpawn production)
    {
        if (IsAbleToBuy(production))
            farmingList.VegetableSpawn(production);
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
            farmingList.RawCattle(acquisition);
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
            farmingList.RawCattle(acquisition);
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
            farmingList.WorkCastles(acquisition);
        }
    }
    public void PlantLemonTree(int count)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new LemonTree();
            acquisition.Name("Lemon tree number " + i + " from procurement " + purchase);
            acquisition.CropYield(50);
            acquisition.SetAcidLevel(4);//very acid
            farmingList.FruitSpawn(acquisition);
        }
    }
    public void PigPurchase (int count, int age)
    {
        purchase++;
        for (int i = 0; i < count; i++) {
            var acquisition = new Pig();
            acquisition.Name("Pig number " + i + " from procurement " + purchase);
            acquisition.Age(age);
            farmingList.RawCattle(acquisition);
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
            farmingList.VegetableSpawn(acquisition);
        }
    }
    public void SheepPurchase (int count, int age)
    {
        purchase++;
        for (int i = 0; i < count; i++) {
            var acquisition = new Sheep();
            acquisition.Name("Sheep number " + i + " from procurement " + purchase);
            acquisition.Age(age);
            farmingList.RawCattle(acquisition);
        }
    }

    public void ChangeCurrentRecurse() {

    }

    public void Containing()
    {
        for (int i = 0; i < this.farmingList.RawCattleList().size(); i++)
        {
            this.container.ReduceResource(this.farmingList.RawCattleList().get(i));
        }
    }
    public float GetAllRawCost()
    {
        float totalPrice = 0f;
        for (int i = 0; i < this.farmingList.RawFarmList().size(); i++)
        {
           totalPrice +=  this.farmingList.RawFarmList().get(i).DefaultCost();
        }
        return totalPrice;
    }

    public void Harvesting()
    {
        for (int i = 0; i < this.farmingList.RawCattleList().size(); i++)
        {
            this.farmingList.RawFarmList().addAll(this.farmingList.RawCattleList().get(i).Harvest());
        }
    }
}
