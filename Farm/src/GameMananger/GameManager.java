package GameMananger;

import AbstractEntities.Farming;
import CattleType.RawCattle;
import CattleType.ReqularRawCattle.Chicken;
import CattleType.ReqularRawCattle.Cow;
import CattleType.ReqularRawCattle.Pig;
import CattleType.ReqularRawCattle.Sheep;
import Farm.Farm;
import File.JsonFileConverter;
import Resourses.AbstractResourse;
import Resourses.Corn;
import Resourses.Watter;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager
{
    Scanner input = new Scanner(System.in);
    public int answer;
    public boolean isCorrect = true;
    public GameManager()
        {
            MainMenu();
        }
    public GameManager(Farm save)
    {
        MainMenu();
    }
    public static class TradeGenerator
    {
        public static void GenerateMarketRawCattleTrades(Farm farming)
        {
            double random = Math.random()*6+2;
            var iterator = (int)Math.round(random);
            for(int i =  0; i < iterator; i++)
            {
                GenerateMarketRaw(farming);
            }
        }

        public static void GenerateMarketRaw( Farm save)
        {
            double random = Math.random()*5;
            int iterator = (int)Math.round(random);
            RawCattle farming;
            switch (iterator)
            {
                case 1:  farming = new Chicken(); GenerateRawValue(farming, save);break;
                case 2:  farming = new Cow();GenerateRawValue(farming, save);break;
                case 3:  farming = new Pig();GenerateRawValue(farming, save);break;
                case 4:  farming = new Sheep();GenerateRawValue(farming, save);break;
                default: GenerateMarketRaw(save);
            }
        }
        public static void GenerateRawValue( RawCattle cattle, Farm save)
        {
            double a = Math.random()*5+2;
            int iterator = (int)Math.round(a);
            for (int i = 0; i < iterator; i++) {
                cattle.SetCattleWeight((int) Math.random() * 8 + 2);
                cattle.SetAge((int) Math.random() * 9 + 1);
                cattle.SetCurrentCost(cattle.GetDefaultCost() * ((float) Math.random() * 30 + 80) / 100);
                save.farmingList.AddMarketRawCattleSellList(cattle);
            }

        }
    }
    private void MainMenu()
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

    private void PauseMenu(Farm save)
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

    private void SaveGame(Farm save)
    {
        JsonFileConverter converter = new JsonFileConverter();
        converter.SaveObjectToFile(save);
        PauseMenu(save);
    }
    private void ScipDay(Farm farm)
    {
        MainScene(ChangeFarmState(farm));//calculate and call main scene dialog
    }

    private Farm ChangeFarmState(Farm farm)
    {
        farm.ChangeCurrentDay();
        TradeGenerator.GenerateMarketRawCattleTrades(farm);
        farm.ChangeCurrentResurse(farm);
        return farm;
    }
    private void FarmScene(Farm farm)
    {
        boolean isCorrect = false;
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

    private void FarmResursesScene(Farm farm)
    {

        if(!farm.container.CheckCornAvailability())
            System.out.println("We don't have corn");
        if(!farm.container.CheckWaterAvailability())
            System.out.println("We don't have any water");

        System.out.println("There is our resource tank. There we have ");

        System.out.println("1: Corn volume " + farm.container.GetCornVolume() );
        System.out.println("2: Water volume " + farm.container.GetWatterVolume() );
        this.FarmScene(farm);
    }

    private void FarmRawScene(Farm farm)
    {
        if(farm.farmingList.GetRawFromFarmList().isEmpty())
            System.out.println("We don't have any raw");

        System.out.println("There is our raw container. There we have: ");
        for (int i = 0; i < farm.farmingList.GetRawFromFarmList().size(); i++)
        {
            System.out.println(i + ": Name " + farm.farmingList.GetRawFromFarmList().get(i).GetName() + ", Collected  "+ (farm.GetCurrentDay()- farm.farmingList.GetRawFromFarmList().get(i).GetSpawnDay()));
        }
        System.out.println("[redirecting to main scene]");
        this.MainScene(farm);
    }

    private void FarmCattleScene(Farm farm)
    {
        if(farm.farmingList.GetRawCattleList().isEmpty())
            System.out.println("We don't have any cattle");

        int chickenCount = 0; int cowCount = 0; int pigCount = 0; int sheepCount = 0;
        System.out.println("Right now we have " + farm.farmingList.GetRawCattleList().size() + "amount of castles");
        for(int i = 0; i < farm.farmingList.GetRawCattleList().size(); i++)
        {
            do {
                switch ((farm.farmingList.GetRawCattleList().get(i)).ID) {
                    case 1:
                        this.isCorrect = true;
                        chickenCount++;
                        break;
                    case 2:
                        this.isCorrect = true;
                        cowCount++;
                        break;
                    case 3:
                        this.isCorrect = true;
                        pigCount++;
                        break;
                    case 4:
                        this.isCorrect = true;
                        sheepCount++;
                        break;
                }
            }
            while (!this.isCorrect);


        }
        System.out.println(chickenCount + "chicken, " + cowCount + " cow, "+ pigCount + " pigs and "+ sheepCount + "sheep");
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
                    PreparationToKill(farm); break;
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

    private void PreparationToKill(Farm farm) {
        boolean isCorrect = true;
        int number = 0;
        ArrayList<RawCattle> tmp = new ArrayList<RawCattle>();
        System.out.println("Who will be killed?");
        System.out.println("===================");
        do {
            System.out.println("1: Chicken");
            System.out.println("2: Cow");
            System.out.println("3: Pig");
            System.out.println("4: Sheep");
            this.answer = input.nextInt();

            System.out.println("Here is your choosen animal");


            for (int i = 0; i < farm.farmingList.GetRawCattleList().size(); i++)
                if(farm.farmingList.GetRawCattleList().get(i).ID == this.answer)
                {
                    tmp.add(farm.farmingList.GetRawCattleList().get(i));
                }

            for (int i = 0; i < tmp.size(); i++)
            {
                    System.out.println(i+": name " +tmp.get(i).GetName() +", age"+ +tmp.get(i).GetAge() + ", mass is "+ tmp.get(i).GetCattleWeight());
            }
        }
        while (!isCorrect);

        System.out.println("Choose number of animal");


//        int pointer =  input.nextInt()-1;
//        int currentPointer=0;
//        int globalPoiner = 0;
//        while (currentPointer!=pointer)
//        {
//            for (int i = 0; i < farm.farmingList.GetRawCattleList().size(); i++)
//            {
//                if (farm.farmingList.GetRawCattleList().get(i).ID == this.answer)
//                {
//                    currentPointer++;
//                }
//                globalPoiner++;
//            }
//        }
        tmp.get(0).Death(farm, tmp.get(0));

        FarmCattleScene(farm);
    }

    private void MarcketScene(Farm farm)
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
                case 1:  this.isCorrect = true; MarcketBuyAnimalScene(farm);
                case 2:  this.isCorrect = true; MarcketBuyResursesScene(farm);
                case 3:  this.isCorrect = true; MarcketSellRawScene(farm); break;
                case 4:  this.isCorrect = true; MainScene(farm); break;
                default: this.isCorrect = false; break;
            }
        }
        while (!this.isCorrect);
    }

    private void MarcketSellRawScene(Farm farm)
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
                    farm.ChangeBalanse(farm.GetAllRawCost());
                    farm.farmingList.PurgeRawFarmList();
                    MarcketScene(farm);
                    break;
                case 2: this.MarcketScene(farm);
            }
        }
        while (!this.isCorrect);

    }

    private void MarcketBuyResursesScene(Farm farm)
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
                    resourse = new Watter();
                    System.out.println("How much water do you need?");
                    break;
                case 3:
                    this.isCorrect = true;
                    System.out.println("[Returning to the MarketScene]]");
                    this.MarcketScene(farm);
                default: this.isCorrect = false;
            }
        }while (!isCorrect);

        resourse.SetVolume(input.nextInt());

        if(farm.GetBalance()> resourse.GetVolume()* resourse.GetDefaultCost() )
        {
            var price = resourse.GetVolume()* resourse.GetDefaultCost();
            farm.container.ChangeResurseVolume(resourse, resourse.GetVolume());
            farm.ChangeBalanse(-price);
            System.out.println("you lost " + price + " money");

            System.out.println("[redirecting to the marcket scene]\n");
            this.MarcketBuyResursesScene(farm);
        }
        else
        {
            System.out.println("You don't have enough money");
            this.MarcketBuyResursesScene(farm);
        }
    }

    private void MarcketBuyAnimalScene(Farm farm) {
        if(farm.farmingList.GetMarketRawCattleSellList().size() == 0)
        {
            System.out.println("Unlucky day. Come later");
            this.MarcketScene(farm);
        }
        System.out.println("Here is our market place. Look at these trades:");
        int i = 0;
        for (var element:farm.farmingList.GetMarketRawCattleSellList())
        {
            i++;
            System.out.println(i+ ": "+ "Name is "+ element.GetName() + ", Age is "+ element.GetAge() + ", weight is  " +element.GetCattleWeight() + " , cost "+element.GetCurrentCost() );
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
                        if(IsAbleToBuy(farm.farmingList.GetMarketRawCattleSellList().get(this.answer-1), farm))
                            farm.BuySomeFarming(farm.farmingList.GetMarketRawCattleSellList().get(this.answer-1), farm);

                        else {
                            System.out.println("You don't have enough money");
                        }
                case 2:  this.isCorrect = true; MainScene(farm);
                default: this.isCorrect = false;
            }
        }
        while (!this.isCorrect);


    }
    private boolean IsAbleToBuy(Farming farming, Farm farm) {
        return farming.GetCurrentCost() <= farm.GetBalance();
    }
    private void Start()
    {
        Farm save = new Farm();
        TradeGenerator.GenerateMarketRaw(save);

        MainScene(save);
    }
    private void Start(Farm save)
    {
        MainScene(save);
    }
    private void Load()
    {
        JsonFileConverter file = new JsonFileConverter();
        var save =  file.LoadObjectFromFile();
        Start(save);
    }
    private int Quit()
    {
        return 0;
    }
    private void MainScene(Farm farm)
    {
        System.out.println("Day: " + farm.GetCurrentDay());
        System.out.println("Money: " + farm.GetBalance());
        boolean isCorrect = true;
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
                    MarcketScene(farm);break;
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
      //  game.MainMenu();
    }
}
