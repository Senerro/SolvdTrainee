package com.solvd.mavenFarm.file;

import com.solvd.mavenFarm.farm.Farm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;


public class JsonFileConverter implements Serializable {
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    static final Logger LOGGER = LogManager.getLogger(JsonFileConverter.class);
    private final String PATH;

    public JsonFileConverter() {
        this.PATH = "C:\\solvd\\maven-farm\\src\\main\\resources\\SaveFile.dat";
    }
    public JsonFileConverter (final String Path) {
        this.PATH = Path;
    }

    public void saveObjectToFile(final Farm object)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH))) {
            oos.writeObject(object);
            LOGGER.debug("Save file has been saved");
        }
        catch(Exception ex) {
            LOGGER.error(ex.getMessage());
        }
    }
    public Farm loadObjectFromFile()
    {
        Farm newFarm = new Farm();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))) {
            newFarm=((Farm)ois.readObject());
        }
        catch(Exception ex){
            LOGGER.error(ex.getMessage());
        }

        return newFarm;
    }
}



