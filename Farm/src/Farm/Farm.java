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

    public float GetBalance() {
        return balance;
    }


    public void SetBalance(float balance) {
        this.balance = balance;
    }
    public void ChangeBalanse(float balance)
    {
        this.balance += balance;
    }

    public int GetCurrentDay() {
        return currentDay;
    }
    public void ChangeCurrentDay()
    {
        currentDay++;
    }


    public FarmingList farmingList = new FarmingList();
  /*  public Farm()
    {
        PlantAppleTree (1, "golden");
        BullPurchase(2, 15, 950);
        PlantCabbage ( 3,  "Chineese");
        ChickenPurchase(2, 2, true);
        CowPurchase(5, 1);
        HorsePurchase(10, 7, 999);
        PlantLemonTree(10);
        PlantPotato(5, "Aspia");
        SheepPurchase(5, 4);
    }*/
    public void PlantAppleTree(int count, String sort)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Appletree();
            acquisition.SetName("Apple tree number " + i + " from procurement " + purchase);
            acquisition.SetCropYield(50);
            acquisition.SetSort(sort);
            farmingList.AddFruitSpawn(acquisition);
        }
    }
    public void BullPurchase (int count, int age, float tonnage)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Bull();
            acquisition.SetName("Bull number " + i + " from procurement " + purchase);
            acquisition.SetTonage(tonnage);
            acquisition.SetAge(age);
            farmingList.AddWorkCastles(acquisition);
        }
    }
    public void PlantCabbage (int count, String sort)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Cabbage();
            acquisition.SetSort(sort);
            farmingList.AddVegetableSpawn(acquisition);
        }
    }
    public boolean BuySomeFarming(RawCattle production, Farm farm)
    {
        if (IsAbleToBuy(production)) {
            farmingList.AddRawCattle(production);
            farm.ChangeBalanse(-production.GetCurrentCost());
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
        return this.balance>= farming.GetCurrentCost();
    }

    public void ChickenPurchase (int count, int age, boolean sex)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Chicken();
            acquisition.SetName("Chicken number " + i + " from procurement " + purchase);

            acquisition.SetAge(age);
            acquisition.SetAge(i);
            farmingList.AddRawCattle(acquisition);
        }
    }
    public void CowPurchase (int count, int age)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Cow();
            acquisition.SetName("Cow number " + i + " from procurement " + purchase);
            acquisition.SetAge(age);
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
            acquisition.SetName("horse number " + i + " from procurement " + purchase);
            acquisition.SetMaxEndurance(endurance);
            acquisition.SetAge(age);
            farmingList.AddWorkCastles(acquisition);
        }
    }
    public void PlantLemonTree(int count)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new LemonTree();
            acquisition.SetName("Lemon tree number " + i + " from procurement " + purchase);
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
            acquisition.SetName("Pig number " + i + " from procurement " + purchase);
            acquisition.SetAge(age);
            farmingList.AddRawCattle(acquisition);
        }
    }
    public void PlantPotato (int count, String sort)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Potato();
            acquisition.SetSort(sort);
            acquisition.SetName("Potato number " + i + " from procurement" + purchase);
            acquisition.SetSort(sort);
            acquisition.SetSize(2);// little
            farmingList.AddVegetableSpawn(acquisition);
        }
    }
    public void SheepPurchase (int count, int age)
    {
        purchase++;
        for (int i = 0; i < count; i++) {
            var acquisition = new Sheep();
            acquisition.SetName("Sheep number " + i + " from procurement " + purchase);
            acquisition.SetAge(age);
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
           totalPrice +=  this.farmingList.GetRawFromFarmList().get(i).GetDefaultCost();
        }
        return totalPrice;
    }
}
