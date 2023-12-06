package com.solvd.mavenFarm.raw;
import com.solvd.mavenFarm.exception.ShelfLifeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.Serializable;

public class Meat extends AbstractRaw implements Serializable
{
    static final Logger LOGGER = LogManager.getLogger(Meat.class);
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    public Meat()
    {
        try{
            this.shelfLife(25);
        }
        catch (ShelfLifeException ex)
        {
            LOGGER.error(ex.getMessage() +" entered shelflife was "+ ex.enteredShelfLife());
        }
        this.defaultCost(5);
        this.name("Meat");
        ID =4;
    }
}
