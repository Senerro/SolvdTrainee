package com.solvd.mavenFarm.managers;

import com.solvd.mavenFarm.abstractEntities.Farming;
import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Cow;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Pig;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Sheep;
import com.solvd.mavenFarm.enums.Questionnaire;
import com.solvd.mavenFarm.farm.Farm;
import com.solvd.mavenFarm.file.JsonFileConverter;
import com.solvd.mavenFarm.global.GlobalEvent;
import com.solvd.mavenFarm.global.GlobalStateEnum;
import com.solvd.mavenFarm.interfaces.functional.IClassGettable;
import com.solvd.mavenFarm.interfaces.functional.INamesakeAddable;
import com.solvd.mavenFarm.listick.MyList;
import com.solvd.mavenFarm.managers.Comparators.RawRottenComparator;
import com.solvd.mavenFarm.raw.AbstractRaw;
import com.solvd.mavenFarm.resourses.AbstractResource;
import com.solvd.mavenFarm.resourses.Corn;
import com.solvd.mavenFarm.resourses.Water;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import outPackage.ReflectionTemplate;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;


public class GameManager implements Serializable
{

    final Scanner input = new Scanner(System.in);

    public int answer;
    public boolean isCorrect = true;
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    private static final Logger LOGGER = LogManager.getLogger(GameManager.class);
    private Questionnaire question = Questionnaire.START;


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
            question.currentSceneQuestionary();
            if(GlobalEvent.state == GlobalStateEnum.REALIZE) {
                this.answer = input.nextInt();

            }
            else this.answer = 1;
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
        question.currentSceneQuestionary();
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
        farm.purgeCorpse();
        return farm;
    }
    private void farmScene(final Farm farm)
    {
        LOGGER.info("There is our Farm");
        do
        {
           question.currentSceneQuestionary();
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
        LOGGER.info("1: Corn volume " +  farm.container.CornVolume() );
        LOGGER.info("2: Water volume " + farm.container.WaterVolume() );
        this.farmScene(farm);
    }

    private void farmRawScene(final Farm farm)
    {
        if(farm.checkRaw()) {
            question.currentSceneQuestionary();
            this.farmScene(farm);
        }
        LOGGER.info("There is our raw container. There we have: ");

        for (int i = 0; i < farm.farmingList.rawFarm().size(); i++)
        {
            LOGGER.info(farm.farmingList.rawFarm().get(i).toString());
        }

        var readyToRot = farm.farmingList.rawFarm().stream()
                .filter(x -> ((x.spawnDay() + x.shelfLife()) - farm.currentDay() > 0))
                .filter(x -> ((x.spawnDay() + x.shelfLife()) - farm.currentDay() < 3))
                .peek(x -> LOGGER.debug(x.toString() + " current day is "+farm.currentDay()))
                .collect(Collectors.toList());

        if(!readyToRot.isEmpty())
        {
            Comparator<AbstractRaw> ARcomp = new RawRottenComparator();
            LOGGER.info("READY TO ROT " + readyToRot.stream().count() + " resources");
            LOGGER.info("the most 'rotten' raw is " + readyToRot.stream().max(ARcomp));
        }
        LOGGER.info("[redirecting to farm scene]");
        this.farmScene(farm);
    }

    private void farmCattleScene(final Farm farm)
    {
        var cattleTypeSet = new HashMap<String, RawCattle>();
        IClassGettable<String, RawCattle> className = (list) -> {
            for (var element: farm.farmingList.rawCattle()) {
                var path = element.getClass().toString();
                var wordsOfPath = StringUtils.split(path, " ");
                var packagePath = wordsOfPath[1];
                var packageNodes = StringUtils.split(packagePath, ".");
                var name = packageNodes[packageNodes.length - 1];
                cattleTypeSet.put(name, farm.farmingList.rawCattle().get(0));
            }
        };

        if(farm.checkFarmRawCattle())
        {
            LOGGER.info("We don't have any cattle");
            LOGGER.info("[Redirecting to FarmScene...]");
            farmScene(farm);
        }

        LOGGER.info("Right now we have " + farm.farmingList.rawCattle().size() + " castles");
        farm.farmingList.animal();
        for (RawCattle element :farm.farmingList.rawCattle())
        {
            LOGGER.info(element.toString());
        }
        LOGGER.info("Here also presences  " + farm.farmingList.rawCattle().stream().filter(cattle -> cattle.age()<2).filter(cattle -> cattle.cattleWeight() > 40).count() + " tough cubs");

        LOGGER.info("groups of cattle: ");
        className.name(cattleTypeSet);

        int iterator = 0;
        for (var tmp:cattleTypeSet.keySet())
        {
            iterator++;
            System.out.print(iterator + ": " +tmp + "     ");
        }
        System.out.println();
        do
        {
            question.currentSceneQuestionary();
            this.answer  = input.nextInt();
            LOGGER.trace(this.answer);
            switch (this.answer ) {
                case 1:
                    this.isCorrect = true;
                    var typeList = new ArrayList<>(cattleTypeSet.keySet());
                    preparationToKill(farm, typeList, className); break;
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

    private void preparationToKill(Farm farm, ArrayList<String> types, IClassGettable<String, RawCattle> className)
    {
        ArrayList<RawCattle> tmp = new ArrayList<>();
        question.currentSceneQuestionary();
        do {
            this.answer = input.nextInt();
            if(answer > types.size()) {
                isCorrect = false;
                LOGGER.info("Wrong input. Try once more");
            }
            if (answer<1) {
                isCorrect = false;
                LOGGER.info("Wrong input. Try once more");
            }
            else isCorrect = true;
        }
        while (!isCorrect);

        INamesakeAddable<RawCattle> nameSake = (String name, ArrayList<RawCattle> list) ->
        {
            for (var element:list) {
                if(element.getClass().getSimpleName().equals(name))
                    tmp.add(element);
            }
            if(tmp.size() == 1)
                LOGGER.debug("one cattle " + tmp.get(0).toStringInFarm() + "was added into tmp list");
            if(tmp.size()>1)
                LOGGER.debug(tmp.size() + " cattles were added into tmp list");
            else
                LOGGER.error("method nameSake couldn't add cattle into tmpList");

        };

        LOGGER.info("Here are your chosen animals");

        nameSake.add(types.get(this.answer-1), farm.farmingList.rawCattle());


        for (RawCattle cattle : tmp) {
            LOGGER.info(cattle.toStringInFarm());
        }
        if(!tmp.isEmpty()) {
            tmp.get(0).death(farm);
            LOGGER.info("First animal was murdered");
        }
        farmCattleScene(farm);
    }
    private void marketScene(final Farm farm)
    {
        question.currentSceneQuestionary();
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
            question.currentSceneQuestionary();
            this.answer = input.nextInt();
            LOGGER.trace(this.answer);
            switch (this.answer)
            {
                case 1:
                    LOGGER.info("You gained " + farm.getAllRawCost() + " money\n");
                    farm.changeBalance(farm.getAllRawCost());
                    farm.farmingList.purgeRawFarmList();
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
                question.currentSceneQuestionary();
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

            resource.volume(input.nextInt());

            if (farm.balance() > resource.volume() * resource.defaultCost())
            {
                float price = resource.volume() * resource.defaultCost();
                farm.container.ChangeResourceVolume(resource, resource.volume());
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
            question.currentSceneQuestionary();
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
        TradeGenerator.generateMarketRawCattle(save);

        RawCattle animal1 = new Pig();
        RawCattle animal2 = new Pig();
        RawCattle animal3 = new Pig();
        RawCattle animal4 = new Pig();
        RawCattle animal5 = new Pig();
        RawCattle animal6 = new Pig();
        RawCattle animal7 = new Sheep();
        RawCattle animal8 = new Sheep();
        RawCattle animal9 = new Cow();

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
        animal9.age(2);
        animal9.cattleWeight(550);

      /*  save.farmingList.rawCattle(animal1);
        save.farmingList.rawCattle(animal2);
        save.farmingList.rawCattle(animal3);
        save.farmingList.rawCattle(animal4);
        save.farmingList.rawCattle(animal5);
        save.farmingList.rawCattle(animal6);
        save.farmingList.rawCattle(animal7);
        save.farmingList.rawCattle(animal8);*/
        save.farmingList.rawCattle(animal9);
        mainScene(save);
    }
    private void start(final Farm save)
    {
        mainScene(save);
        save.farmingList.rawCattleHashMap();
        RawCattle animal = new Sheep();
        save.farmingList.rawCattleHashMap(animal);
    }
    private void load()
    {
        JsonFileConverter save = new JsonFileConverter();
        Farm farm = save.loadObjectFromFile();
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

        question.currentSceneQuestionary();
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


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, NoSuchMethodException {


        /*Field field = tmp.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String name = (String) field.get(tmp);

        System.out.println(name);*/

        //GameManager game = new GameManager();

        Class templateClass = ReflectionTemplate.class;
        LOGGER.info("Class access level is " + Modifier.toString(templateClass.getModifiers()));

        var constructors = new ArrayList<>(Arrays.asList(templateClass.getDeclaredConstructors()));
        constructors.stream().forEach(x -> LOGGER.debug(x.toString()));

        System.out.println();

        var methods = new ArrayList<>(Arrays.asList(templateClass.getDeclaredMethods()));
        methods.stream().forEach(x -> LOGGER.warn(Modifier.toString(x.getModifiers())
                + " " + x.getReturnType().getSimpleName()
                + " " +x.getName() + "("+ getParameters(x) +")"));

        System.out.println();

        var fields = new ArrayList<>(Arrays.asList(templateClass.getDeclaredFields()));
        fields.stream().forEach(x -> LOGGER.error(Modifier.toString(x.getModifiers())
                                + " " + x.getType().getSimpleName()
                                + " " + x.getName()));


        System.out.println();

        ReflectionTemplate tmp = new ReflectionTemplate("MyPrivateName","", 789);
        Class template = Class.forName(tmp.getClass().getName());
        ReflectionTemplate defaultTemplate = (ReflectionTemplate)template.newInstance();
        System.out.println(defaultTemplate);

        Constructor<?> constructor = null;
        for (var element:template.getDeclaredConstructors())
        {
            if(element.toString().equals("public outPackage.ReflectionTemplate(java.lang.String,java.lang.String,int)"))
                constructor = element;
        }
        ReflectionTemplate customeTemplate = (ReflectionTemplate)constructor.newInstance("Custome", "Consructor", 56);
        customeTemplate.ageCode();
        LOGGER.fatal(customeTemplate);

        Constructor<?> newConstructor = ReflectionTemplate.class.getConstructor(String.class, String.class, int.class);
        ReflectionTemplate myObject = (ReflectionTemplate)newConstructor.newInstance("Custome2", "Consructor2", 45);
        System.out.println(myObject);


        Method method = templateClass.getDeclaredMethod("getAgeCode");
        method.setAccessible(true);
        System.out.println(method.invoke(myObject));
    }

    private static String getParameters(Method x)
    {
        var a = x.getParameters();
        String result= "";
        for (var element:a) {
            result += (element.getParameterizedType() + " " + element.getName());
        }
        return result;
    }
}