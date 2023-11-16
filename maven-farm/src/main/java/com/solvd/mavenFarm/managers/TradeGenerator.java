package com.solvd.mavenFarm.managers;


import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Chicken;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Cow;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Pig;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Sheep;
import com.solvd.mavenFarm.farm.Farm;
import com.solvd.mavenFarm.listic.MyList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TradeGenerator {
    static final Logger LOGGER = LogManager.getLogger(TradeGenerator.class);
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
        public static void GenerateMarketRawCattleTrades(final Farm farming)
        {
            double random = Math.random()*6+2;
            var iterator = (int)Math.round(random);
            for(int i =  0; i < iterator; i++)
            {
                GenerateMarketRawCattle(farming);
            }
        }

        public static void GenerateMarketRawCattle(final Farm save)
        {
            double random = Math.random()*5;
            int iterator = (int)Math.round(random);
            RawCattle farming;
            switch (iterator)
            {
                case 1:  farming = new Chicken();
                    GenerateRawCattleProperties(farming, save);break;
                case 2:  farming = new Cow();
                    GenerateRawCattleProperties(farming, save);break;
                case 3:  farming = new Pig();
                    GenerateRawCattleProperties(farming, save);break;
                case 4:  farming = new Sheep();
                    GenerateRawCattleProperties(farming, save);break;
                default: GenerateMarketRawCattle(save);
            }
        }
        public static void GenerateRawCattleProperties(final RawCattle cattle, final Farm save)
        {
            save.farmingList.marketRawCattleSellList().clear();
            MyList<RawCattle> rawCattleMySellList = new MyList<>();

            int iterator = (int) (Math.random()*5)+2;
            for (int i = 0; i < iterator; i++) {
                cattle.cattleWeight((int) (Math.random() * 8) + 2);
                cattle.age((int) (Math.random() * 9) + 1);
                cattle.currentCost(cattle.defaultCost() * ((float) Math.random() * 30 + 80) / 100);
//                cattle.CattleWeight((int) (0));
//                cattle.Age((int) (0));
              /*  try {
                    cattle.CurrentCost(cattle.DefaultCost() * (0));
                }
                catch (CostException ex)
                {
                    save.farmingList.MarketRawCattleSellList();
                   LOGGER.error(ex.getMessage() + " Entered cost was " + ex.EnteredCost());

                }*/
                rawCattleMySellList.add(cattle);
                //save.farmingList.MarketRawCattleSellList(cattle);
            }
            var rawCattleArrayList = rawCattleMySellList.toArrayList();
            for (int i = 0; i<rawCattleArrayList.size(); i++)
            {
                save.farmingList.marketRawCattleSellList(rawCattleArrayList.get(i));
            }
        }
}
