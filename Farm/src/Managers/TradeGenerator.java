package Managers;

import CattleType.RawCattle;
import CattleType.ReqularRawCattle.Chicken;
import CattleType.ReqularRawCattle.Cow;
import CattleType.ReqularRawCattle.Pig;
import CattleType.ReqularRawCattle.Sheep;
import Farm.Farm;
import Exception.CostException;
import org.apache.log4j.Logger;

import java.util.zip.DataFormatException;

public final class TradeGenerator {
    static final org.apache.log4j.Logger LOGGER = Logger.getLogger(TradeGenerator.class);
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
                case 1:  farming = new Chicken(); GenerateRawCattleProperties(farming, save);break;
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
            save.farmingList.MarketRawCattleSellList().clear();

            int iterator = (int) (Math.random()*5)+2;
            for (int i = 0; i < iterator; i++) {
//                cattle.CattleWeight((int) (Math.random() * 8) + 2);
//                cattle.Age((int) (Math.random() * 9) + 1);
//                cattle.CurrentCost(cattle.DefaultCost() * ((float) Math.random() * 30 + 80) / 100);

                cattle.CattleWeight((int) (0));
                cattle.Age((int) (0));
                try {
                    cattle.CurrentCost(cattle.DefaultCost() * (0));
                }
                catch (CostException ex)
                {
                    save.farmingList.MarketRawCattleSellList();
                   LOGGER.error(ex.getMessage() + " Entered cost was " + ex.EnteredCost());

                }


                save.farmingList.MarketRawCattleSellList(cattle);
            }

        }
}
