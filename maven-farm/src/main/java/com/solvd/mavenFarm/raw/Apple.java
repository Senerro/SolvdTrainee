package com.solvd.mavenFarm.raw;
import com.solvd.mavenFarm.exception.ShelfLifeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public class Apple extends AbstractRaw implements Serializable
{
    static final Logger LOGGER = LogManager.getLogger(Apple.class);
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    public Apple()
    {
        try{
            this.ShelfLife(45);
        }
        catch (ShelfLifeException ex)
        {
            LOGGER.error(ex.getMessage() +" entered shelflife was "+ ex.enteredShelfLife());
        }
        this.DefaultCost(0.9f/6);
        this.Name("Apple");
        ID = 1;
    }
}
