package GameMananger;

import AbstractEntities.Farming;
import Farm.Farm;
import File.JsonFileConverter;

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
                    FarmRawScene(farm);
                    break;
                case 2:
                    this.isCorrect = true;
                    FarmCattleScene(farm);
                    break;
                case 3:
                    this.isCorrect = true;
                    FarmResursesScene(farm);
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

    private void FarmRawScene(Farm farm)
    {
        System.out.println("There is our resourse tank. There we have ");
        for (int i = 0; i < farm.farmingList.GetRawFromFarmList().size(); i++)
        {
            System.out.println(i + ": Name " + farm.farmingList.GetRawFromFarmList().get(i).GetName() + ", Collected  "+ (farm.GetCurrentDay()- farm.farmingList.GetRawFromFarmList().get(i).GetSpawnDay()));
        }
    }

    private void FarmCattleScene(Farm farm)
    {
        int chickenCount = 0; int cowCount = 0; int pigCount = 0; int sheepCount = 0;
        System.out.println("Right now we have " + farm.farmingList.GetRawCattleList().size() + "amount of right castle");
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
        }
    }

    private void PreparationToKill(Farm farm) {
        boolean isCorrect = true;
        int number = 0;
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
            {
                if(farm.farmingList.GetRawCattleList().get(i).ID == this.answer)
                {
                    number += 1;
                    System.out.println(number+": name " +farm.farmingList.GetRawCattleList().get(i).GetName() +", age"+ +farm.farmingList.GetRawCattleList().get(i).GetAge() + ", mass is "+ farm.farmingList.GetRawCattleList().get(i).GetCattleWeight());
                }
            }
        }
        while (!isCorrect);

        System.out.println("Choose number of animal");

        for (int i = 0; i < farm.farmingList.GetRawCattleList().size(); i++)
        {
            if(farm.farmingList.GetRawCattleList().get(i).ID == this.answer)
            {
                number += 1;
                System.out.println(number+": name " +farm.farmingList.GetRawCattleList().get(i).GetName() +", age"+ +farm.farmingList.GetRawCattleList().get(i).GetAge() + ", mass is "+ farm.farmingList.GetRawCattleList().get(i).GetCattleWeight());
            }
        }
        int pointer =  input.nextInt()-1;
        int currentPointer=0;
        int globalPoiner = 0;
        while (currentPointer!=pointer)
        {
            for (int i = 0; i < farm.farmingList.GetRawCattleList().size(); i++)
            {
                if (farm.farmingList.GetRawCattleList().get(i).ID == this.answer)
                {
                    currentPointer++;
                }
                globalPoiner++;
            }
        }
        farm.farmingList.GetRawCattleList().get(globalPoiner).Death();

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

    private void MarcketBuyAnimalScene(Farm farm) {
        System.out.println("Here is our market place Look at these trades:");
        int i = 0;
        for (var element:farm.farmingList.GetMarketRawCattleSellList())
        {
            i++;
            System.out.println(i+ ": "+ "Name is "+ element.GetName() + ", Age is "+ element.GetAge() + ", weight is  " +element.GetCattleWeight() );
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
                        if(IsAbleToBuy(farm.farmingList.GetMarketRawCattleSellList().get(this.answer), farm))
                    farm.BuySomeFarming(farm.farmingList.GetMarketRawCattleSellList().get(this.answer));
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
        System.out.println("All is working");
    }
}
