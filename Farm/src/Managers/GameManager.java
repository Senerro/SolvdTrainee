package Managers;

import AbstractEntities.Farming;
import CattleType.RawCattle;
import Farm.Farm;
import File.JsonFileConverter;
import Resourses.AbstractResourse;
import Resourses.Corn;
import Resourses.Water;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager
{
    final Scanner input = new Scanner(System.in);
    public int answer;
    public boolean isCorrect = true;
    public GameManager()
        {
            MainMenu();
        }

    private  void MainMenu()
    {

        System.out.println("Welcome to the FarmIO");
        System.out.println("======================");
        do {
            System.out.println("1: Start new game");
            System.out.println("2: Load");
            System.out.println("3: Quit");

            this.answer = input.nextInt();

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
                    System.out.println("Uncorrected answer. Try once more");
            }
        }
        while (!this.isCorrect);
    }

    private void PauseMenu(final Farm save)
    {
        System.out.println("PAUSE?");
        System.out.println("===================");
        System.out.println("1: Save Game");
        System.out.println("2: Load Game");
        System.out.println("3: Continue");
        System.out.println("4: Return to main menu");
        do
        {
            this.answer  = input.nextInt();
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
                    System.out.println("Uncorrected answer. Try once more");
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
        farm.Containing();
        farm.Harvesting();
        farm.ChangeCurrentDay();
        TradeGenerator.GenerateMarketRawCattleTrades(farm);
        return farm;
    }
    private void FarmScene(final Farm farm)
    {
        System.out.println("There is our Farm");
        do
        {
            System.out.println("What shall we do?");
            System.out.println("1. Check resources");
            System.out.println("2. Check Cattle");
            System.out.println("3. Check Raw");
            System.out.println("4. Fall back");
            this.answer  = input.nextInt();
            switch (this.answer ) {
                case 1:
                    this.isCorrect = true;
                    FarmResursesScene(farm);
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
                    System.out.println("Uncorrected answer. Try once more");
                    this.answer  =  input.nextInt();
            }
        }
        while (!this.isCorrect);
    }

    private void FarmResursesScene(final Farm farm)
    {
        System.out.println("There is our resource tank. There we have ");
        System.out.println("1: Corn volume " + farm.container.CornVolume() );
        System.out.println("2: Water volume " + farm.container.WatterVolume() );
        this.FarmScene(farm);
    }

    private void FarmRawScene(final Farm farm)
    {
        if(farm.farmingList.RawFarmList().isEmpty()) {
            System.out.println("We don't have any raw");
            System.out.println("[redirecting to farm scene]");
            this.FarmScene(farm);
        }

        System.out.println("There is our raw container. There we have: ");
        for (int i = 0; i < farm.farmingList.RawFarmList().size(); i++)
        {
            System.out.println(farm.farmingList.RawFarmList().get(i).toString());
        }
        System.out.println("[redirecting to farm scene]");
        this.FarmScene(farm);
    }

    private void FarmCattleScene(final Farm farm)
    {
            if(farm.CheckRawCattleInFarm())
            {
                System.out.println("We don't have any cattle");
                System.out.println("[Redirecting to FarmScene...]");
                FarmScene(farm);
            }

        ArrayList<RawCattle> cattleTypeList = new ArrayList<>();
        ArrayList<RawCattle> tmpList = new ArrayList<>();

        System.out.println("Right now we have " + farm.farmingList.RawCattleList().size() + " castles");
        System.out.println("groups: ");
        cattleTypeList.add(farm.farmingList.RawCattleList().get(0));
        for(int i = 0; i < farm.farmingList.RawCattleList().size(); i++)
        {
            boolean isUnique = false;
            for ( int a = 0; a <cattleTypeList.size(); a++)
            {
              if((farm.farmingList.RawCattleList().get(i).equals(cattleTypeList.get(a))))
                {
                    isUnique = false;
                    break;
                }
              else
                  isUnique = true;
            }

            if (isUnique)
                cattleTypeList.add(farm.farmingList.RawCattleList().get(i));
        }
        int iterator = 0;
        for (var tmp:cattleTypeList)
        {
            iterator++;
        System.out.print(iterator + ": " +tmp.Name() + "     ");
        }
        System.out.println(" ");
        do
        {
            System.out.println("Do you want to kill someone?");
            System.out.println("============================");
            System.out.println("1: Yes");
            System.out.println("2: No, leave");
            this.answer  = input.nextInt();
            switch (this.answer ) {
                case 1:
                    this.isCorrect = true;
                    PreparationToKill(farm, cattleTypeList); break;
                case 2:
                    this.isCorrect = true;
                    FarmScene(farm);break;
                default:
                    this.isCorrect = false;
                    System.out.println("Uncorrected answer. Try once more");
            }
        }
        while (!this.isCorrect);
        this.MainScene(farm);
    }

    private void PreparationToKill(final Farm farm, final ArrayList<RawCattle> typeList) {
        ArrayList<RawCattle> tmp = new ArrayList<RawCattle>();
        System.out.println("Who will be killed?");
        System.out.println("===================");
        do {
            this.answer = input.nextInt();
            if(answer>typeList.size()) {
                isCorrect = false;
                System.out.println("Wrong input. Try once more");
            } else if (answer<1) {
                isCorrect = false;
                System.out.println("Wrong input. Try once more");

            } else isCorrect = true;
        }
        while (!isCorrect);

        System.out.println("Here are your chosen animals");
        for (int i = 0; i < farm.farmingList.RawCattleList().size(); i++)
            if(farm.farmingList.RawCattleList().get(i).getClass() == typeList.get( this.answer-1).getClass())
            {
                tmp.add(farm.farmingList.RawCattleList().get(i));
            }

        for (RawCattle cattle : tmp) {
            System.out.println(cattle.toStringInFarm());
        }
        tmp.get(0).Death(farm, tmp.get(0));

        FarmCattleScene(farm);
    }

    private void MarketScene(final Farm farm)
    {
        System.out.println("Here is our market");
        System.out.println("What shall we do");
        System.out.println("1: Buy a cattle");
        System.out.println("2: Buy a resourses");
        System.out.println("3: Sell a raw");
        System.out.println("4: Fall back");
        this.answer =  input.nextInt();
        do
        {
            switch (this.answer)
            {
                case 1:  this.isCorrect = true; MarketBuyAnimalScene(farm);
                case 2:  this.isCorrect = true; MarketBuyResursesScene(farm);
                case 3:  this.isCorrect = true; MarketSellRawScene(farm); break;
                case 4:  this.isCorrect = true; MainScene(farm); break;
                default: this.isCorrect = false; break;
            }
        }
        while (!this.isCorrect);
    }

    private void MarketSellRawScene(final Farm farm)
    {
        System.out.println("Here is raw selling place");
        do {
            System.out.println("Are you ready to sell all your raw");
            System.out.println("1: Yes");
            System.out.println("2: No, go back");
            this.answer = input.nextInt();
            switch (this.answer)
            {
                case 1:
                    System.out.println("You gained " + farm.GetAllRawCost() + " money\n");
                    farm.ChangeBalance(farm.GetAllRawCost());
                    farm.farmingList.PurgeRawFarmList();
                    MarketScene(farm);
                    break;
                case 2: this.MarketScene(farm);
            }
        }
        while (!this.isCorrect);
    }

    private void MarketBuyResursesScene(final Farm farm)
    {
        AbstractResourse resourse = new AbstractResourse();
        System.out.println("Here is resource spot");
        do {

            System.out.println("What are you going to buy?");
            System.out.println("1: Corn");
            System.out.println("2: Water");
            System.out.println("3: Nothing, go back");
            this.answer = input.nextInt();
            switch (this.answer)
            {
                case 1:
                    this.isCorrect = true;
                    resourse = new Corn();
                    System.out.println("How much corn do you need?");

                    break;
                case 2:
                    this.isCorrect = true;
                    resourse = new Water();
                    System.out.println("How much water do you need?");
                    break;
                case 3:
                    this.isCorrect = true;
                    System.out.println("[Returning to the MarketScene]]");
                    this.MarketScene(farm);
                default: this.isCorrect = false;
            }
        }while (!isCorrect);

        resourse.Volume(input.nextInt());

        if(farm.Balance()> resourse.Volume()* resourse.DefaultCost() )
        {
            var price = resourse.Volume()* resourse.DefaultCost();
            farm.container.ChangeResurсeVolume(resourse, resourse.Volume());
            farm.ChangeBalance(-price);
            System.out.println("you lost " + price + " money");

            System.out.println("[redirecting to the marcket scene]\n");
            this.MarketBuyResursesScene(farm);
        }
        else
        {
            System.out.println("You don't have enough money");
            this.MarketBuyResursesScene(farm);
        }
    }

    private void MarketBuyAnimalScene(final Farm farm) {
        if(farm.farmingList.MarketRawCattleSellList().size() == 0)
        {
            System.out.println("Unlucky day. Come later");
            this.MarketScene(farm);
        }
        System.out.println("Here is our market place. Look at these trades:");
        int i = 0;
        for (var element:farm.farmingList.MarketRawCattleSellList())
        {
            i++;
            System.out.println(element.toString());
        }
        do
        {
            System.out.println("Do you want to by someone?");
            System.out.println("1: Yes");
            System.out.println("2: No, go back");
            this.answer = input.nextInt();
            switch (this.answer)
            {
                case 1:  this.isCorrect = true;
                    System.out.println("Enter number of your choosing");
                    this.answer = input.nextInt();
                        if(IsAbleToBuy(farm.farmingList.MarketRawCattleSellList().get(this.answer-1), farm))
                            farm.BuySomeFarming(farm.farmingList.MarketRawCattleSellList().get(this.answer-1), farm);
                        else {
                            System.out.println("You don't have enough money");
                        }
                case 2:  this.isCorrect = true; MainScene(farm);
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
        boolean isCorrect = true;
        System.out.println("Day: " + farm.CurrentDay());
        System.out.println("Money: " + farm.Balance());

        System.out.println("What we shall to do?");
        System.out.println("1: Go to the market");
        System.out.println("2: Check our Farm");
        System.out.println("3: Scip this day");
        System.out.println("4: Pause menu");

        this.answer  = input.nextInt();
        do
        {
            switch (this.answer ) {
                case 1:
                    MarketScene(farm);break;
                case 2:
                    FarmScene(farm);break;
                case 3:
                    ScipDay(farm);break;
                case 4:
                    PauseMenu(farm);break;
                default:
                    isCorrect = false;
                    System.out.println("Uncorrected answer. Try once more");
                    this.answer  =  input.nextInt();
            }
        }
        while (!isCorrect);
    }

    public static void main(String[] args)
    {
        var game = new GameManager();
    }
}