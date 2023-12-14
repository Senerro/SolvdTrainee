package com.solvd.mavenFarm.farm;

import com.solvd.mavenFarm.abstractEntities.Farming;
import com.solvd.mavenFarm.cattleType.RawCattle;
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
    private static int currentDayStatic;
    private static float sessionGain;
    private  float globalGain;
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
        currentDayStatic = 1;
        sessionGain = 0;
    }
    private static final Logger LOGGER = LogManager.getLogger(Farm.class);
    private float balance = 500000;
    public ResourcesContainer container = new ResourcesContainer();
    public FarmingList farmingList = new FarmingList();

    public float balance() {
        return balance;
    }

    public void increaseGain(float gain) {
        sessionGain += gain;
    }

    public static float getGain() {
        return sessionGain;
    }

    public void changeBalance(float balance) {
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

    public void changeCurrentDay() {
        currentDay++;
        currentDayStatic = currentDay;
    }

    public boolean buySomeFarming(RawCattle production, Farm farm) {
        if (isAbleToBuy(production)) {
            farmingList.rawCattle(production);
            farm.changeBalance(-production.currentCost());
            farm.farmingList.purgeMarketRawCattle(production);
            return true;
        }
        return false;
    }

    private boolean isAbleToBuy(Farming farming) {
        return this.balance>= farming.currentCost();
    }

    public void containing() {
        for (int i = 0; i < this.farmingList.rawCattle().size(); i++) {
            this.container.ReduceResource(this.farmingList.rawCattle().get(i));
        }
    }

    public float getAllRawCost() {
        float totalPrice = 0f;
        for (int i = 0; i < this.farmingList.rawFarm().size(); i++) {
            totalPrice +=  this.farmingList.rawFarm().get(i).defaultCost();
        }
        return totalPrice;
    }

    public void harvesting() {
        for (int i = 0; i < this.farmingList.rawCattle().size(); i++) {
            this.farmingList.rawFarm().addAll(this.farmingList.rawCattle().get(i).harvest());
        }
    }

    @Override
    public boolean checkFarmRawCattle() {
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

    public void validateExpirationDate() {
        for(int i = 0; i < this.farmingList.rawFarm().size(); i++)
        {
            if(this.farmingList.rawFarm().get(i).isRot())
            {
                this.farmingList.purgeRawFarm(this.farmingList.rawFarm().get(i));
            }
        }
    }
    public float globalGain() {
        return this.globalGain;
    }

    @Override
    public float calculateCurrentProfit() {
        calculateGlobalProfit(getGain());
        return getGain();
    }

    @Override
    public void calculateGlobalProfit(float gain) {
        this.globalGain += gain;
    }

    public void purgeCorpse() {
        Predicate<RawCattle> isDead = animal -> animal.isDead();
        Comparator<RawCattle> RCcomp = new RawCattleNameComparator().thenComparing(new RawCattleAgeComparator()).thenComparing(new RawCattleWeighComparator());

        Stream<RawCattle> stream = farmingList.rawCattle().stream();
        stream.filter(isDead).sorted(RCcomp).forEach(x -> LOGGER.debug(x.toString() + " should be purge"));

        farmingList.rawCattle().removeIf(isDead);
    }
}

