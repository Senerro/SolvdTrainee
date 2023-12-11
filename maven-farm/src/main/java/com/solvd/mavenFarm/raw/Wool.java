package com.solvd.mavenFarm.raw;

import com.solvd.mavenFarm.exception.ShelfLifeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public class Wool extends AbstractRaw implements Serializable
{
    static final Logger LOGGER = LogManager.getLogger(Wool.class);
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    public Wool()
    {
        try{
            this.shelfLife(7*365);
        }
        catch (ShelfLifeException ex)
        {
            LOGGER.error(ex.getMessage() +" entered shelflife was "+ ex.enteredShelfLife());
        }
        this.defaultCost(74.56f);
        this.name("Wool");
        ID = 6;
    }
}
