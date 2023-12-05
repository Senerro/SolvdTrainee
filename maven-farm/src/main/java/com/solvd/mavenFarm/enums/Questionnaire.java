package com.solvd.mavenFarm.enums;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public enum Questionnaire
{
    START,
    MainMenu,
    MainScene,
    PauseMenu,
    FarmScene,
    FarmCattleScene,
    PreparationToKill,
    MarketScene,
    MarketSellRawScene,
    MarketBuyResourcesScene,
    MarketBuyAnimalScene,
    FarmRawScene,


    ;private String invokeMethod;
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    private static final Logger LOGGER = LogManager.getLogger(Questionnaire.class);
    public void currentSceneQuestionary()
    {
        inicializator();
    }
    public void info()
    {
        switch (this) {
            case MainMenu:
                LOGGER.info("1: Start new game");
                LOGGER.info("2: Load");
                LOGGER.info("3: Quit");
                break;
            case MainScene:
                LOGGER.info("What we shall to do?");
                LOGGER.info("1: Go to the market");
                LOGGER.info("2: Check our Farm");
                LOGGER.info("3: Scip this day");
                LOGGER.info("4: Pause menu");
                break;
            case PauseMenu:
                LOGGER.info("PAUSE");
                LOGGER.info("===================");
                LOGGER.info("1: Save Game");
                LOGGER.info("2: Load Game");
                LOGGER.info("3: Continue");
                LOGGER.info("4: Return to main menu");
                break;
            case FarmScene:
                LOGGER.info("What shall we do?");
                LOGGER.info("1. Check resources");
                LOGGER.info("2. Check Cattle");
                LOGGER.info("3. Check Raw");
                LOGGER.info("4. Fall back");
                break;
            case FarmCattleScene:
                LOGGER.info("Do you want to kill someone?");
                LOGGER.info("============================");
                LOGGER.info("1: Yes");
                LOGGER.info("2: No, leave");
                break;
            case PreparationToKill:
                LOGGER.info("Who will be killed?");
                LOGGER.info("===================");
                break;
            case MarketScene:
                LOGGER.info("Here is our market");
                LOGGER.info("What shall we do?");
                LOGGER.info("1: Buy a cattle");
                LOGGER.info("2: Buy a resources");
                LOGGER.info("3: Sell a raw");
                LOGGER.info("4: Fall back");
                break;
            case MarketSellRawScene:
                LOGGER.info("Are you ready to sell all your raw");
                LOGGER.info("1: Yes");
                LOGGER.info("2: No, go back");
                break;
            case MarketBuyResourcesScene:
                LOGGER.info("What are you going to buy?");
                LOGGER.info("1: Corn");
                LOGGER.info("2: Water");
                LOGGER.info("3: Nothing, go back");
                break;
            case MarketBuyAnimalScene:
                LOGGER.info("Do you want to by someone?");
                LOGGER.info("1: Yes");
                LOGGER.info("2: No, go back");
                break;
            case FarmRawScene:
                LOGGER.info("We don't have any raw");
                LOGGER.info("[redirecting to farm scene]");
                break;

            default:
                LOGGER.error("Invoke method isn't founded. Provide method is " + invokeMethod);
        }
    }

    private void inicializator()
    {
        detectInvokeMethod();
        var newEnum = transformToEnum();
        launch(newEnum);

    }

    private void launch(Questionnaire newEnum)
    {
        newEnum.info();
    }

    private void detectInvokeMethod()
    {
        StackTraceElement[] tracer;
        tracer = new Throwable().getStackTrace();
        this.invokeMethod = tracer[3].getMethodName();
    }
    private Questionnaire transformToEnum()
    {
        this.invokeMethod = StringUtils.capitalize(this.invokeMethod);
        try
        {
            return Questionnaire.valueOf(invokeMethod);
        }
        catch (RuntimeException exception)
        {
            LOGGER.error(exception.getMessage() + " invoke method " + invokeMethod + " wasn't founded in enum");
        }
        return this;
    }
}