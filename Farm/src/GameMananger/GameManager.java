package GameMananger;

import Farm.Farm;
import File.JsonFileConverter;

import java.util.Scanner;

public class GameManager
{
    Scanner input = new Scanner(System.in);
    public int answer;
    public GameManager()
        {
            MainMenu();
        }

    private void MainMenu()
    {
        boolean isCorrect = false;
        System.out.println("Welcome to the FarmIO");
        System.out.println("======================");
        do {
            System.out.println("1: Start new game");
            System.out.println("2: Load");
            System.out.println("3: Quit");

            this.answer = input.nextInt();

            switch (this.answer) {
                case 1:
                    Start();break;
                case 2:
                    Load();break;
                case 3:
                    Quit();break;
                default:
                    isCorrect = false;
                    System.out.println("Uncorrected answer. Try once more");
                    this.answer  =  input.nextInt();
            }
        }
        while (!isCorrect);
    }

    private void PauseMenu(Farm save)
    {
        boolean isCorrect = true;
        System.out.println("PAUSE?");
        System.out.println("===================");
        System.out.println("1: Save Game");
        System.out.println("2: Load Game");
        System.out.println("3: Continue");
        System.out.println("4: Return to main menu");

        this.answer  = input.nextInt();
        do
        {
            switch (this.answer ) {
                case 1:
                    SaveGame(save);
                    break;
                case 2:
                    Load();
                    break;
                case 3:
                    MainScene(save);
                    break;
                case 4:
                    MainMenu();
                    break;
                default:
                    isCorrect = false;
                    System.out.println("Uncorrected answer. Try once more");
                    this.answer  =  input.nextInt();
            }
        }
        while (!isCorrect);
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
        //farm.ChangeCurrentResurse();
        return farm;
    }

    private void ChangeFarmingBalance(Farm farm, float delta)
    {

    }


    private void FarmScene(Farm save)
    {
        boolean isCorrect = false;
        System.out.println("There is our Farm");
        System.out.println("What shall we do?");
        System.out.println("1. Check resources");
        System.out.println("2. Check Cattle");
        System.out.println("3. Fall back");


        this.answer  = input.nextInt();
        do
        {
            switch (this.answer ) {
                case 1:
                    FarmResursesScene(save);
                    break;
                case 2:
                    FarmCattleScene(save);
                    break;
                case 3:
                    MainScene(save);
                    break;
                case 4:
                    MainMenu();
                    break;
                default:
                    isCorrect = false;
                    System.out.println("Uncorrected answer. Try once more");
                    this.answer  =  input.nextInt();
            }
        }
        while (!isCorrect);
    }
    private void FarmCattleScene(Farm farm)
    {
        int chickenCount = 0;
        int cowCount = 0;
        int pigCount = 0;
        int sheepCount = 0;
        System.out.println("Right now we have " + farm.farmingList.GetRawCattleList().size() + "amount of right castle");
        for(int i = 0; i < farm.farmingList.GetRawCattleList().size(); i++)
        {
            switch ((farm.farmingList.GetRawCattleList().get(i)).ID)
            {
                case 1: chickenCount++; break;
                case 2: cowCount++; break;
                case 3: pigCount++; break;
                case 4: sheepCount++; break;
            }
            System.out.println(chickenCount + "chicken, " + cowCount + " cow, "+ pigCount + " pigs and "+ sheepCount + "sheep");
            System.out.println("Do you want to kill someone?");
            System.out.println("============================");

            System.out.println("1: Yes");
            System.out.println("2: No, leave");
            boolean isCorrect = true;
            this.answer  = input.nextInt();
            do
            {
                switch (this.answer ) {
                    case 1:
                        PreparationToKill(farm); break;
                    case 2:
                        FarmScene(farm);
                        break;

                    default:
                        isCorrect = false;
                        System.out.println("Uncorrected answer. Try once more");
                        this.answer  =  input.nextInt();
                }
            }
            while (!isCorrect);
}

        }

    private void MarcketScene()
    {

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
    private void MainScene(Farm save)
    {
        System.out.println("Day: " + save.GetCurrentDay());
        System.out.println("Money: " + save.GetBalance());
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
                    MarcketScene();break;
                case 2:
                    FarmScene(save);break;
                case 3:
                    ScipDay(save);break;
                case 4:
                    PauseMenu(save);break;
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
