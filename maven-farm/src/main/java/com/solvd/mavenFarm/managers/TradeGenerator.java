package com.solvd.mavenFarm.managers;


import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.enums.RawCattleEnum;
import com.solvd.mavenFarm.farm.Farm;
import com.solvd.mavenFarm.interfaces.functional.IGeneratable;
import com.solvd.mavenFarm.listick.MyList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.BiFunction;

public final class TradeGenerator implements Serializable {
    static final Logger LOGGER = LogManager.getLogger(TradeGenerator.class);

    static {
        System.setProperty("log4j.configurationFile", "log4j.xml");
    }

    public static void GenerateMarketRawCattleTrades(final Farm farming) {
        double random = Math.random() * 6 + 2;
        int iterator = (int) Math.round(random);
        for (int i = 0; i < iterator; i++) {
            generateMarketRawCattle(farming);
        }
    }

    public static void generateMarketRawCattle(final Farm save) {
        IGeneratable<RawCattle> generator = (cattle, count, list) ->
        {
            for (int i = 0; i < count; i++) {
                cattle.cattleWeight((int) (Math.random() * 8) + 2);
                cattle.age((int) (Math.random() * 9) + 1);
                cattle.currentCost(cattle.defaultCost() * ((float) Math.random() * 30 + 80) / 100);
                list.add(cattle);
            }
        };

        double random = Math.random() * 5;
        int iterator = (int) Math.round(random);
        switch (iterator) {
            case 1:
                generateRawCattleProperties(RawCattleEnum.Chicken.get(), save, generator);
                break;
            case 2:
                generateRawCattleProperties(RawCattleEnum.Cow.get(), save, generator);
                break;
            case 3:
                generateRawCattleProperties(RawCattleEnum.Sheep.get(), save, generator);
                break;
            case 4:
                generateRawCattleProperties(RawCattleEnum.Pig.get(), save, generator);
                break;
            default:
                generateMarketRawCattle(save);
        }
    }

    public static void generateRawCattleProperties(final RawCattle cattle, final Farm save, IGeneratable<RawCattle> generator) {
        save.farmingList.marketRawCattleSellList().clear();
        MyList<RawCattle> rawCattleMySellList = new MyList<>();

        int iterator = (int) (Math.random() * 5) + 2;
        generator.fill(cattle, iterator, rawCattleMySellList);
        BiFunction<MyList<RawCattle>, ArrayList<RawCattle>, Boolean> convert = (x, y) ->
        {
            y.addAll(x.toArrayList());
            return true;
        };
        convert.apply(rawCattleMySellList, save.farmingList.marketRawCattleSellList());

    }
}
