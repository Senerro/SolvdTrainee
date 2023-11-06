package GameMananger;

import CattleType.RawCattle;
import CattleType.ReqularRawCattle.Chicken;
import CattleType.ReqularRawCattle.Cow;
import CattleType.ReqularRawCattle.Pig;
import CattleType.ReqularRawCattle.Sheep;
import Farm.Farm;

public final class TradeGenerator {

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
                cattle.CattleWeight((int) (Math.random() * 8) + 2);
                cattle.Age((int) (Math.random() * 9) + 1);
                cattle.CurrentCost(cattle.DefaultCost() * ((float) Math.random() * 30 + 80) / 100);
                save.farmingList.MarketRawCattleSellList(cattle);
            }

        }
}
