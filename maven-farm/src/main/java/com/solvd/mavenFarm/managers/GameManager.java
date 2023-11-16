package com.solvd.mavenFarm.managers;

import com.solvd.mavenFarm.abstractEntities.Farming;
import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Pig;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Sheep;
import com.solvd.mavenFarm.farm.Farm;
import com.solvd.mavenFarm.file.JsonFileConverter;
import com.solvd.mavenFarm.foodTypes.FruitSpawn;
import com.solvd.mavenFarm.foodTypes.reqularFruitsSpawn.Appletree;
import com.solvd.mavenFarm.listic.MyList;
import com.solvd.mavenFarm.resourses.AbstractResource;
import com.solvd.mavenFarm.resourses.Corn;
import com.solvd.mavenFarm.resourses.Water;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class GameManager
{

    final Scanner input = new Scanner(System.in);

    public int answer;
    public boolean isCorrect = true;
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    private static final Logger LOGGER = LogManager.getLogger(GameManager.class);

    public GameManager()
        {
            LOGGER.trace("Application successfully started");
            mainMenu();
        }

    private  void mainMenu()
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
                    start();break;
                case 2:
                    this.isCorrect = true;
                    load();break;
                case 3:
                    this.isCorrect = true;
                    quit();break;
                default:
                   this.isCorrect = false;
                    LOGGER.info("Uncorrected answer. Try once more");
            }
        }
        while (!this.isCorrect);
    }

    private void pauseMenu(final Farm save)
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
                    saveGame(save);
                    this.isCorrect = true;
                    break;
                case 2:
                    this.isCorrect = true;
                    load();
                    break;
                case 3:
                    this.isCorrect = true;
                    mainScene(save);
                    break;
                case 4:
                    this.isCorrect = true;
                    mainMenu();
                    break;
                default:
                    this.isCorrect = false;
                    LOGGER.info("Uncorrected answer. Try once more");
            }
        }
        while (!this.isCorrect);
    }
    private void saveGame(final Farm save)
    {
        JsonFileConverter converter = new JsonFileConverter();
        converter.saveObjectToFile(save);
        pauseMenu(save);
    }
    private void scipDay(final Farm farm)
    {
        mainScene(changeFarmState(farm));
    }
    private Farm changeFarmState(final Farm farm)
    {
        farm.validateExpirationDate();
        farm.containing();
        farm.harvesting();
        farm.changeCurrentDay();
        TradeGenerator.GenerateMarketRawCattleTrades(farm);
        return farm;
    }
    private void farmScene(final Farm farm)
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
                    farmResourcesScene(farm);
                    break;
                case 2:
                    this.isCorrect = true;
                    farmCattleScene(farm);
                    break;
                case 3:
                    this.isCorrect = true;
                    farmRawScene(farm);
                    break;
                case 4:
                    this.isCorrect = true;
                    mainScene(farm);
                    break;
                default:
                    this.isCorrect = false;
                    LOGGER.info("Uncorrected answer. Try once more");
                    this.answer  =  input.nextInt();
            }
        }
        while (!this.isCorrect);
    }

    private void farmResourcesScene(final Farm farm)
    {
        if(farm.checkCorn()) {
            LOGGER.info("We don't have any corn");
            this.farmScene(farm);
        }
        if(farm.checkWater()) {
            LOGGER.info("We don't have any water");
            this.farmScene(farm);
        }
        LOGGER.info("There is our resource tank. There we have ");
        LOGGER.info("1: Corn volume " + farm.container.CornVolume() );
        LOGGER.info("2: Water volume " + farm.container.WatterVolume() );
        this.farmScene(farm);
    }

    private void farmRawScene(final Farm farm)
    {
        if(!farm.checkRaw()) {
            LOGGER.info("We don't have any raw");
            LOGGER.info("[redirecting to farm scene]");
            this.farmScene(farm);
        }

        LOGGER.info("There is our raw container. There we have: ");
        for (int i = 0; i < farm.farmingList.rawFarm().size(); i++)
        {
            LOGGER.info(farm.farmingList.rawFarm().get(i).toString());
        }
        LOGGER.info("[redirecting to farm scene]");
        this.farmScene(farm);
    }

    private void farmCattleScene(final Farm farm)
    {
            if(farm.checkFarmRawCattle())
            {
                LOGGER.info("We don't have any cattle");
                LOGGER.info("[Redirecting to FarmScene...]");
                farmScene(farm);
            }
        ArrayList<RawCattle> cattleTypeList = new ArrayList<>();

        LOGGER.info("Right now we have " + farm.farmingList.rawCattle().size() + " castles");
        farm.farmingList.animal();
        for (var element :farm.farmingList.animal(1))
        {
            LOGGER.info(element.toString());
        }
        LOGGER.info("groups: ");
        cattleTypeList.add(farm.farmingList.rawCattle().get(0));
        for(int i = 0; i < farm.farmingList.rawCattle().size(); i++)
        {
            boolean isUnique = false;
            for (RawCattle cattle : cattleTypeList) {
                if ((farm.farmingList.rawCattle().get(i).equals(cattle))) {
                    isUnique = false;
                    break;
                } else
                    isUnique = true;
            }

            if (isUnique)
                cattleTypeList.add(farm.farmingList.rawCattle().get(i));
        }
        int iterator = 0;
        for (var tmp:cattleTypeList)
        {
            iterator++;
        System.out.print(iterator + ": " +tmp.name() + "     ");
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
                    preparationToKill(farm, cattleTypeList); break;
                case 2:
                    this.isCorrect = true;
                    farmScene(farm);break;
                default:
                    this.isCorrect = false;
                    LOGGER.info("Uncorrected answer. Try once more");
            }
        }
        while (!this.isCorrect);
        this.mainScene(farm);
    }

    private void preparationToKill(final Farm farm, final ArrayList<RawCattle> typeList) {
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
        for (int i = 0; i < farm.farmingList.rawCattle().size(); i++)
            if(farm.farmingList.rawCattle().get(i).getClass() == typeList.get( this.answer-1).getClass())
            {
                tmp.add(farm.farmingList.rawCattle().get(i));
            }

        for (RawCattle cattle : tmp) {
            LOGGER.info(cattle.toStringInFarm());
        }
        tmp.get(0).death(farm, tmp.get(0));

        farmCattleScene(farm);
    }

    private void marketScene(final Farm farm)
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
                case 1:  this.isCorrect = true; marketBuyAnimalScene(farm);
                case 2:  this.isCorrect = true; marketBuyResourcesScene(farm);
                case 3:  this.isCorrect = true; marketSellRawScene(farm); break;
                case 4:  this.isCorrect = true; mainScene(farm); break;
                default: this.isCorrect = false; break;
            }
        }
        while (!this.isCorrect);
    }

    private void marketSellRawScene(final Farm farm)
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
                    LOGGER.info("You gained " + farm.getAllRawCost() + " money\n");
                    farm.changeBalance(farm.getAllRawCost());
                    farm.farmingList.PurgeRawFarmList();
                    marketScene(farm);
                    break;
                case 2: this.marketScene(farm);
            }
        }
        while (!this.isCorrect);
    }

    private void marketBuyResourcesScene(final Farm farm)
    {
            AbstractResource resource = new AbstractResource();
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
                        this.marketScene(farm);
                    default:
                        this.isCorrect = false;
                }
            } while (!isCorrect);

            resource.Volume(input.nextInt());

            if (farm.balance() > resource.Volume() * resource.DefaultCost()) {
                var price = resource.Volume() * resource.DefaultCost();
                farm.container.ChangeResurceVolume(resource, resource.Volume());
                farm.changeBalance(-price);
                LOGGER.info("you lost " + price + " money");

                LOGGER.info("[redirecting to the market scene]\n");
                this.marketBuyResourcesScene(farm);
            } else {
                LOGGER.info("You don't have enough money");
                this.marketBuyResourcesScene(farm);
            }

    }

    private void marketBuyAnimalScene(final Farm farm) {
        if(!farm.checkMarketRawCattle())
        {
            LOGGER.info("Unlucky day. Come later");
            this.marketScene(farm);
        }
        LOGGER.info("Here is our market place. Look at these trades:");

        for(int i = 0; i < farm.farmingList.marketRawCattleSellList().size(); i++)
        {
            LOGGER.info(farm.farmingList.marketRawCattleSellList().get(i).toString());
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
                        if(isAbleToBuy(farm.farmingList.marketRawCattleSellList().get(this.answer-1), farm))
                            farm.buySomeFarming(farm.farmingList.marketRawCattleSellList().get(this.answer-1), farm);
                        else {
                            LOGGER.info("You don't have enough money");
                        }
                case 2:  this.isCorrect = true; mainScene(farm); break;
                default: this.isCorrect = false;
            }
        }
        while (!this.isCorrect);
    }
    private boolean isAbleToBuy(final Farming farming, final Farm farm) {
        return farming.currentCost() <= farm.balance();
    }
    private void start()
    {
        Farm save = new Farm();
        TradeGenerator.GenerateMarketRawCattle(save);
        ArrayList<RawCattle> animals = new ArrayList<>();

        RawCattle animal1 = new Pig();
        RawCattle animal2 = new Pig();
        RawCattle animal3 = new Pig();
        RawCattle animal4 = new Pig();
        RawCattle animal5 = new Pig();
        RawCattle animal6 = new Pig();
        RawCattle animal7 = new Sheep();
        RawCattle animal8 = new Sheep();



        animal1.age(1);
        animal1.cattleWeight(52);
        animal2.age(2);
        animal2.cattleWeight(51);
        animal3.age(2);
        animal3.cattleWeight(52);
        animal4.age(3);
        animal4.cattleWeight(40);
        animal5.age(3);
        animal5.cattleWeight(34);
        animal6.age(3);
        animal6.cattleWeight(90);
        animal7.age(5);
        animal7.cattleWeight(120);
        animal8.age(6);
        animal8.cattleWeight(91);

        save.farmingList.rawCattle(animal1);
        save.farmingList.rawCattle(animal2);
        save.farmingList.rawCattle(animal3);
        save.farmingList.rawCattle(animal4);
        save.farmingList.rawCattle(animal5);
        save.farmingList.rawCattle(animal6);
        save.farmingList.rawCattle(animal7);
        save.farmingList.rawCattle(animal8);

        mainScene(save);
    }
    private void start(final Farm save)
    {
        mainScene(save);
        save.farmingList.rawCattleHashMap();
        RawCattle animal = new Sheep();
        save.farmingList.rawCattleHashMap(animal);
        save.farmingList.marketFruitSpawnSellLinkedList();
        FruitSpawn farming = new Appletree();
        save.farmingList.marketFruitSpawnSellLinkedList(farming);



    }
    private void load()
    {
        JsonFileConverter save = new JsonFileConverter();
        var farm = save.loadObjectFromFile();
        start(farm);
    }
    private void quit()
    {
        System.exit(200);
    }
    private void mainScene(final Farm farm)
    {
        LOGGER.info("Day: " + farm.currentDay());
        LOGGER.info("Money: " + farm.balance());
        if(farm.calculateCurrentProfit()>0)
            LOGGER.info("Current gain: " + farm.calculateCurrentProfit());
        if(farm.globalGain() > 0)
            LOGGER.info("Global gain: " + farm.globalGain());


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
                    marketScene(farm);break;
                case 2:
                    this.isCorrect = true;
                    farmScene(farm);break;
                case 3:
                    this.isCorrect = true;
                    scipDay(farm);break;
                case 4:
                    this.isCorrect = true;
                    pauseMenu(farm);break;
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
        MyList<String> listic = new MyList<>();
        listic.add("1");
        listic.add("2");
        listic.add("3");
        listic.add("4");
        listic.add("5");
        listic.add("6");
        listic.add("7");
        listic.add("8");
        listic.add("9");
        listic.add(0, "0");
        listic.add(9, "99");
        listic.set(4, "987");
       listic.remove(5);
       listic.remove("8");



        // listic.deleteLast();
        var a = listic.toArrayList();


        var game = new GameManager();
    }
}