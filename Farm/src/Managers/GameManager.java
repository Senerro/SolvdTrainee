package Managers;

import AbstractEntities.Farming;
import CattleType.RawCattle;
import Farm.Farm;
import File.JsonFileConverter;
import Resourses.AbstractResourse;
import Resourses.Corn;
import Resourses.Water;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager
{
    final Scanner input = new Scanner(System.in);
    static final Logger LOGGER = Logger.getLogger(GameManager.class);

    public int answer;
    public boolean isCorrect = true;
    public GameManager()
        {
            LOGGER.trace("Application successfully started");
            MainMenu();
        }

    private  void MainMenu()
    {
        LOGGER.info("Welcome to the FarmIO");
        LOGGER.info("======================");
        do {
            LOGGER.info("1: Start new game");
            LOGGER.info("2: Load");
            LOGGER.info("3: Quit");

            this.answer = input.nextInt();
            LOGGER.trace(this.answer);
            switch (this.answer) {
                case 1:
                    this.isCorrect = true;
                    Start();break;
                case 2:
                    this.isCorrect = true;
                    Load();break;
                case 3:
                    this.isCorrect = true;
                    Quit();break;
                default:
                   this.isCorrect = false;
                    LOGGER.info("Uncorrected answer. Try once more");
            }
        }
        while (!this.isCorrect);
    }

    private void PauseMenu(final Farm save)
    {
        LOGGER.info("PAUSE");
        LOGGER.info("===================");
        LOGGER.info("1: Save Game");
        LOGGER.info("2: Load Game");
        LOGGER.info("3: Continue");
        LOGGER.info("4: Return to main menu");
        do
        {
            this.answer  = input.nextInt();
            LOGGER.trace(this.answer);
            switch (this.answer ) {
                case 1:
                    SaveGame(save);
                    this.isCorrect = true;
                    break;
                case 2:
                    this.isCorrect = true;
                    Load();
                    break;
                case 3:
                    this.isCorrect = true;
                    MainScene(save);
                    break;
                case 4:
                    this.isCorrect = true;
                    MainMenu();
                    break;
                default:
                    this.isCorrect = false;
                    LOGGER.info("Uncorrected answer. Try once more");
            }
        }
        while (!this.isCorrect);
    }
    private void SaveGame(final Farm save)
    {
        JsonFileConverter converter = new JsonFileConverter();
        converter.SaveObjectToFile(save);
        PauseMenu(save);
    }
    private void ScipDay(final Farm farm)
    {
        MainScene(ChangeFarmState(farm));
    }
    private Farm ChangeFarmState(final Farm farm)
    {
        farm.ValidateExpirationDate();
        farm.Containing();
        farm.Harvesting();
        farm.ChangeCurrentDay();
        TradeGenerator.GenerateMarketRawCattleTrades(farm);
        return farm;
    }
    private void FarmScene(final Farm farm)
    {
        LOGGER.info("There is our Farm");
        do
        {
            LOGGER.info("What shall we do?");
            LOGGER.info("1. Check resources");
            LOGGER.info("2. Check Cattle");
            LOGGER.info("3. Check Raw");
            LOGGER.info("4. Fall back");
            this.answer  = input.nextInt();
            LOGGER.trace(this.answer);

            switch (this.answer ) {
                case 1:
                    this.isCorrect = true;
                    FarmResourcesScene(farm);
                    break;
                case 2:
                    this.isCorrect = true;
                    FarmCattleScene(farm);
                    break;
                case 3:
                    this.isCorrect = true;
                    FarmRawScene(farm);
                    break;
                case 4:
                    this.isCorrect = true;
                    MainScene(farm);
                    break;
                default:
                    this.isCorrect = false;
                    LOGGER.info("Uncorrected answer. Try once more");
                    this.answer  =  input.nextInt();
            }
        }
        while (!this.isCorrect);
    }

    private void FarmResourcesScene(final Farm farm)
    {
        if(farm.CheckCorn()) {
            LOGGER.info("We don't have any corn");
            this.FarmScene(farm);
        }
        if(farm.CheckWater()) {
            LOGGER.info("We don't have any water");
            this.FarmScene(farm);
        }
        LOGGER.info("There is our resource tank. There we have ");
        LOGGER.info("1: Corn volume " + farm.container.CornVolume() );
        LOGGER.info("2: Water volume " + farm.container.WatterVolume() );
        this.FarmScene(farm);
    }

    private void FarmRawScene(final Farm farm)
    {
        if(!farm.CheckRaw()) {
            LOGGER.info("We don't have any raw");
            LOGGER.info("[redirecting to farm scene]");
            this.FarmScene(farm);
        }

        LOGGER.info("There is our raw container. There we have: ");
        for (int i = 0; i < farm.farmingList.RawFarm().size(); i++)
        {
            LOGGER.info(farm.farmingList.RawFarm().get(i).toString());
        }
        LOGGER.info("[redirecting to farm scene]");
        this.FarmScene(farm);
    }

    private void FarmCattleScene(final Farm farm)
    {
            if(farm.CheckFarmRawCattle())
            {
                LOGGER.info("We don't have any cattle");
                LOGGER.info("[Redirecting to FarmScene...]");
                FarmScene(farm);
            }
        ArrayList<RawCattle> cattleTypeList = new ArrayList<>();

        LOGGER.info("Right now we have " + farm.farmingList.RawCattle().size() + " castles");
        LOGGER.info("groups: ");
        cattleTypeList.add(farm.farmingList.RawCattle().get(0));
        for(int i = 0; i < farm.farmingList.RawCattle().size(); i++)
        {
            boolean isUnique = false;
            for (RawCattle cattle : cattleTypeList) {
                if ((farm.farmingList.RawCattle().get(i).equals(cattle))) {
                    isUnique = false;
                    break;
                } else
                    isUnique = true;
            }

            if (isUnique)
                cattleTypeList.add(farm.farmingList.RawCattle().get(i));
        }
        int iterator = 0;
        for (var tmp:cattleTypeList)
        {
            iterator++;
        System.out.print(iterator + ": " +tmp.Name() + "     ");
        }
        LOGGER.info(" ");
        do
        {
            LOGGER.info("Do you want to kill someone?");
            LOGGER.info("============================");
            LOGGER.info("1: Yes");
            LOGGER.info("2: No, leave");
            this.answer  = input.nextInt();
            LOGGER.trace(this.answer);

            switch (this.answer ) {
                case 1:
                    this.isCorrect = true;
                    PreparationToKill(farm, cattleTypeList); break;
                case 2:
                    this.isCorrect = true;
                    FarmScene(farm);break;
                default:
                    this.isCorrect = false;
                    LOGGER.info("Uncorrected answer. Try once more");
            }
        }
        while (!this.isCorrect);
        this.MainScene(farm);
    }

    private void PreparationToKill(final Farm farm, final ArrayList<RawCattle> typeList) {
        ArrayList<RawCattle> tmp = new ArrayList<>();
        LOGGER.info("Who will be killed?");
        LOGGER.info("===================");
        do {
            this.answer = input.nextInt();
            if(answer>typeList.size()) {
                isCorrect = false;
                LOGGER.info("Wrong input. Try once more");
            } else if (answer<1) {
                isCorrect = false;
                LOGGER.info("Wrong input. Try once more");

            } else isCorrect = true;
        }
        while (!isCorrect);

        LOGGER.info("Here are your chosen animals");
        for (int i = 0; i < farm.farmingList.RawCattle().size(); i++)
            if(farm.farmingList.RawCattle().get(i).getClass() == typeList.get( this.answer-1).getClass())
            {
                tmp.add(farm.farmingList.RawCattle().get(i));
            }

        for (RawCattle cattle : tmp) {
            LOGGER.info(cattle.toStringInFarm());
        }
        tmp.get(0).Death(farm, tmp.get(0));

        FarmCattleScene(farm);
    }

    private void MarketScene(final Farm farm)
    {
        LOGGER.info("Here is our market");
        LOGGER.info("What shall we do");
        LOGGER.info("1: Buy a cattle");
        LOGGER.info("2: Buy a resources");
        LOGGER.info("3: Sell a raw");
        LOGGER.info("4: Fall back");
        this.answer =  input.nextInt();
        LOGGER.trace(this.answer);

        do
        {
            switch (this.answer)
            {
                case 1:  this.isCorrect = true; MarketBuyAnimalScene(farm);
                case 2:  this.isCorrect = true; MarketBuyResourcesScene(farm);
                case 3:  this.isCorrect = true; MarketSellRawScene(farm); break;
                case 4:  this.isCorrect = true; MainScene(farm); break;
                default: this.isCorrect = false; break;
            }
        }
        while (!this.isCorrect);
    }

    private void MarketSellRawScene(final Farm farm)
    {
        LOGGER.info("Here is raw selling place");
        do {
            LOGGER.info("Are you ready to sell all your raw");
            LOGGER.info("1: Yes");
            LOGGER.info("2: No, go back");
            this.answer = input.nextInt();
            LOGGER.trace(this.answer);

            switch (this.answer)
            {
                case 1:
                    LOGGER.info("You gained " + farm.GetAllRawCost() + " money\n");
                    farm.ChangeBalance(farm.GetAllRawCost());
                    farm.farmingList.PurgeRawFarmList();
                    MarketScene(farm);
                    break;
                case 2: this.MarketScene(farm);
            }
        }
        while (!this.isCorrect);
    }

    private void MarketBuyResourcesScene(final Farm farm)
    {
            AbstractResourse resource = new AbstractResourse();
            LOGGER.info("Here is resource spot");
            do {

                LOGGER.info("What are you going to buy?");
                LOGGER.info("1: Corn");
                LOGGER.info("2: Water");
                LOGGER.info("3: Nothing, go back");
                this.answer = input.nextInt();
                LOGGER.trace(this.answer);

                switch (this.answer) {
                    case 1:
                        this.isCorrect = true;
                        resource = new Corn();
                        LOGGER.info("How much corn do you need?");

                        break;
                    case 2:
                        this.isCorrect = true;
                        resource = new Water();
                        LOGGER.info("How much water do you need?");
                        break;
                    case 3:
                        this.isCorrect = true;
                        LOGGER.info("[Returning to the MarketScene]]");
                        this.MarketScene(farm);
                    default:
                        this.isCorrect = false;
                }
            } while (!isCorrect);

            resource.Volume(input.nextInt());

            if (farm.Balance() > resource.Volume() * resource.DefaultCost()) {
                var price = resource.Volume() * resource.DefaultCost();
                farm.container.ChangeResurceVolume(resource, resource.Volume());
                farm.ChangeBalance(-price);
                LOGGER.info("you lost " + price + " money");

                LOGGER.info("[redirecting to the market scene]\n");
                this.MarketBuyResourcesScene(farm);
            } else {
                LOGGER.info("You don't have enough money");
                this.MarketBuyResourcesScene(farm);
            }

    }

    private void MarketBuyAnimalScene(final Farm farm) {
        if(!farm.CheckMarketRawCattle())
        {
            LOGGER.info("Unlucky day. Come later");
            this.MarketScene(farm);
        }
        LOGGER.info("Here is our market place. Look at these trades:");

        for(int i = 0; i < farm.farmingList.MarketRawCattleSellList().size(); i++)
        {
            LOGGER.info(farm.farmingList.MarketRawCattleSellList().get(i).toString());
        }
        do
        {
            LOGGER.info("Do you want to by someone?");
            LOGGER.info("1: Yes");
            LOGGER.info("2: No, go back");
            this.answer = input.nextInt();
            LOGGER.trace(this.answer);

            switch (this.answer)
            {
                case 1:  this.isCorrect = true;
                    LOGGER.info("Enter number of your choosing");
                    this.answer = input.nextInt();
                        if(IsAbleToBuy(farm.farmingList.MarketRawCattleSellList().get(this.answer-1), farm))
                            farm.BuySomeFarming(farm.farmingList.MarketRawCattleSellList().get(this.answer-1), farm);
                        else {
                            LOGGER.info("You don't have enough money");
                        }
                case 2:  this.isCorrect = true; MainScene(farm); break;
                default: this.isCorrect = false;
            }
        }
        while (!this.isCorrect);
    }
    private boolean IsAbleToBuy(final Farming farming, final Farm farm) {
        return farming.CurrentCost() <= farm.Balance();
    }
    private void Start()
    {
        Farm save = new Farm();
        TradeGenerator.GenerateMarketRawCattle(save);
        MainScene(save);
    }
    private void Start(final Farm save)
    {
        MainScene(save);
    }
    private void Load()
    {
        JsonFileConverter save = new JsonFileConverter();
        var farm = save.LoadObjectFromFile();
        Start(farm);
    }
    private void Quit()
    {
        System.exit(200);
    }
    private void MainScene(final Farm farm)
    {
        LOGGER.info("Day: " + farm.CurrentDay());
        LOGGER.info("Money: " + farm.Balance());
        if(farm.CalculateCurrentProfit()>0)
            LOGGER.info("Current gain: " + farm.CalculateCurrentProfit());
        if(farm.GlobalGain() > 0)
            LOGGER.info("Global gain: " + farm.GlobalGain());


        LOGGER.info("What we shall to do?");
        LOGGER.info("1: Go to the market");
        LOGGER.info("2: Check our Farm");
        LOGGER.info("3: Scip this day");
        LOGGER.info("4: Pause menu");

        this.answer  = input.nextInt();
        LOGGER.trace(this.answer);

        do
        {
            switch (this.answer ) {
                case 1:
                    this.isCorrect = true;
                    MarketScene(farm);break;
                case 2:
                    this.isCorrect = true;
                    FarmScene(farm);break;
                case 3:
                    this.isCorrect = true;
                    ScipDay(farm);break;
                case 4:
                    this.isCorrect = true;
                    PauseMenu(farm);break;
                default:
                    this.isCorrect = false;
                    LOGGER.info("Uncorrected answer. Try once more");
                    this.answer  =  input.nextInt();
            }
        }
        while (!this.isCorrect);
    }

    public static void main(String[] args)
    {
        var game = new GameManager();
    }
}