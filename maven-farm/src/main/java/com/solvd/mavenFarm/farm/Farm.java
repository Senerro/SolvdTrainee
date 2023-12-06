package com.solvd.mavenFarm.farm;

import com.solvd.mavenFarm.abstractEntities.Farming;
import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.cattleType.WorkCattle;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Chicken;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Cow;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Pig;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Sheep;
import com.solvd.mavenFarm.cattleType.reqularWorkCattle.Bull;
import com.solvd.mavenFarm.cattleType.reqularWorkCattle.Horse;
import com.solvd.mavenFarm.foodTypes.FruitSpawn;
import com.solvd.mavenFarm.foodTypes.VegetableSpawn;
import com.solvd.mavenFarm.foodTypes.reqularFruitsSpawn.Appletree;
import com.solvd.mavenFarm.foodTypes.reqularFruitsSpawn.LemonTree;
import com.solvd.mavenFarm.foodTypes.reqularVegetablesSpawn.Cabbage;
import com.solvd.mavenFarm.foodTypes.reqularVegetablesSpawn.Potato;
import com.solvd.mavenFarm.managers.Comparators.RawCattleAgeComparator;
import com.solvd.mavenFarm.managers.Comparators.RawCattleNameComparator;
import com.solvd.mavenFarm.managers.Comparators.RawCattleWeighComparator;
import com.solvd.mavenFarm.resourses.ResourcesContainer;
import com.solvd.mavenFarm.interfaces.IFarmingExistable;
import com.solvd.mavenFarm.interfaces.IGameSessionGain;
import com.solvd.mavenFarm.interfaces.IResourcesExistable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Farm implements Serializable, IFarmingExistable, IResourcesExistable, IGameSessionGain {

    private static int purchase;
    private  int currentDay = 1;
    transient  private static int currentDayStatic;
    transient private static float sessionGain;
    private  float globalGain;
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    private static final Logger LOGGER = LogManager.getLogger(Farm.class);
    private float balance = 500000;
    public ResourcesContainer container = new ResourcesContainer();

    static
    {
        currentDayStatic = 1;
        sessionGain = 0;
    }


    public float balance() {
        return balance;
    }
    public void increaseGain(float gain)
    {
        sessionGain += gain;
    }
    public static float getGain()
    {
        return sessionGain;
    }

    public void changeBalance(float balance)
    {
        this.balance += balance;
        if(balance>0)
            increaseGain(balance);
    }

    public  int currentDay() {
        return currentDay;
    }
    public static int currentDayStatic() {
        return currentDayStatic;

    }
    public void changeCurrentDay()
    {
        currentDay++;
        currentDayStatic = currentDay;
    }

    public FarmingList farmingList = new FarmingList();

    public void plantAppleTree(int count, String sort)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            Appletree acquisition = new Appletree();
            acquisition.name("Apple tree number " + i + " from procurement " + purchase);
            acquisition.cropYield(50);
            acquisition.sort(sort);
            farmingList.FruitSpawn(acquisition);
        }
    }
    public void bullPurchase(int count, int age, float tonnage)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            Bull acquisition = new Bull();
            acquisition.name("Bull number " + i + " from procurement " + purchase);
            acquisition.Tonnage(tonnage);
            acquisition.age(age);
            farmingList.workCastles(acquisition);
        }
    }
    public void plantCabbage(int count, String sort)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            Cabbage acquisition = new Cabbage();
            acquisition.sort(sort);
            farmingList.vegetableSpawn(acquisition);
        }
    }
    public boolean buySomeFarming(RawCattle production, Farm farm)
    {
        if (isAbleToBuy(production)) {
            farmingList.rawCattle(production);
            farm.changeBalance(-production.currentCost());
            farm.farmingList.purgeMarketRawCattle(production);
            return true;
        }
        return false;
    }
    public void buySomeFarming(WorkCattle production)
    {
        if (isAbleToBuy(production))
            farmingList.workCastles(production);
    }
    public void buySomeFarming(FruitSpawn production)
    {
        if (isAbleToBuy(production))
            farmingList.FruitSpawn(production);
    }
    public void buySomeFarming(VegetableSpawn production)
    {
        if (isAbleToBuy(production))
            farmingList.vegetableSpawn(production);
    }

    private boolean isAbleToBuy(Farming farming) {
        return this.balance>= farming.currentCost();
    }

    public void chickenPurchase(int count, int age, boolean sex)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            Chicken acquisition = new Chicken();
            acquisition.name("Chicken number " + i + " from procurement " + purchase);
            acquisition.age(age);
            acquisition.age(i);
            farmingList.rawCattle(acquisition);
        }
    }
    public void cowPurchase(int count, int age)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            Cow acquisition = new Cow();
            acquisition.name("Cow number " + i + " from procurement " + purchase);
            acquisition.age(age);
            acquisition.SetColor(0);//black
            farmingList.rawCattle(acquisition);
        }
    }

    public void horsePurchase(int count, int age, int endurance)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            Horse acquisition = new Horse();
            acquisition.name("horse number " + i + " from procurement " + purchase);
            acquisition.SetMaxEndurance(endurance);
            acquisition.age(age);
            farmingList.workCastles(acquisition);
        }
    }
    public void plantLemonTree(int count)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            LemonTree acquisition = new LemonTree();
            acquisition.name("Lemon tree number " + i + " from procurement " + purchase);
            acquisition.cropYield(50);
            acquisition.SetAcidLevel(4);//very acid
            farmingList.FruitSpawn(acquisition);
        }
    }
    public void pigPurchase(int count, int age)
    {
        purchase++;
        for (int i = 0; i < count; i++) {
            Pig acquisition = new Pig();
            acquisition.name("Pig number " + i + " from procurement " + purchase);
            acquisition.age(age);
            farmingList.rawCattle(acquisition);
        }
    }
    public void plantPotato(int count, String sort)
    {
        purchase++;
        for (int i = 0; i < count; i++)
        {
            Potato acquisition = new Potato();
            acquisition.sort(sort);
            acquisition.name("Potato number " + i + " from procurement" + purchase);
            acquisition.sort(sort);
            acquisition.setSize(2);// little
            farmingList.vegetableSpawn(acquisition);
        }
    }
    public void sheepPurchase(int count, int age)
    {
        purchase++;
        for (int i = 0; i < count; i++) {
            Sheep acquisition = new Sheep();
            acquisition.name("Sheep number " + i + " from procurement " + purchase);
            acquisition.age(age);
            farmingList.rawCattle(acquisition);
        }
    }
    public void containing()
    {
        for (int i = 0; i < this.farmingList.rawCattle().size(); i++)
        {
            this.container.ReduceResource(this.farmingList.rawCattle().get(i));
        }
    }
    public float getAllRawCost()
    {
        float totalPrice = 0f;
        for (int i = 0; i < this.farmingList.rawFarm().size(); i++)
        {
            totalPrice +=  this.farmingList.rawFarm().get(i).defaultCost();
        }
        return totalPrice;
    }

    public void harvesting()
    {
        for (int i = 0; i < this.farmingList.rawCattle().size(); i++)
        {
            var a = this.farmingList.rawCattle().get(i).harvest();
            this.farmingList.rawFarm().addAll(this.farmingList.rawCattle().get(i).harvest());
        }
    }

    @Override
    public boolean checkFarmRawCattle()
    {
        return this.farmingList.rawCattle().isEmpty();
    }

    @Override
    public boolean checkMarketRawCattle() {
        return !this.farmingList.marketRawCattleSellList().isEmpty();
    }

    @Override
    public boolean checkRaw() {
        return this.farmingList.rawFarm().isEmpty();
    }

    @Override
    public boolean checkWater() {
        return this.container.CheckWaterAvailability();
    }

    @Override
    public boolean checkCorn() {
        return this.container.CheckCornAvailability();
    }

    public void validateExpirationDate()
    {
        for(int i = 0; i < this.farmingList.rawFarm().size(); i++)
        {
            if(this.farmingList.rawFarm().get(i).isRot())
            {
                this.farmingList.purgeRawFarm(this.farmingList.rawFarm().get(i));
            }
        }
    }
    public float globalGain()
    {
        return this.globalGain;
    }

    @Override
    public float calculateCurrentProfit() {
        calculateGlobalProfit(getGain());
        return getGain();
    }

    @Override
    public void calculateGlobalProfit(float gain) {
        this.globalGain+=gain;
    }

    public void purgeCorpse()
    {
        Predicate<RawCattle> isDead = animal -> animal.isDead();
        Comparator<RawCattle> RCcomp = new RawCattleNameComparator().thenComparing(new RawCattleAgeComparator()).thenComparing(new RawCattleWeighComparator());

        Stream<RawCattle> stream = farmingList.rawCattle().stream();
        stream.filter(isDead).sorted(RCcomp).forEach(x -> LOGGER.debug(x.toString() + " should be purge"));

        farmingList.rawCattle().removeIf(isDead);
    }
}

