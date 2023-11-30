package com.solvd.mavenFarm.raw;
import com.solvd.mavenFarm.exception.ShelfLifeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.Serializable;

public class Milk extends AbstractRaw implements Serializable
{
    static final Logger LOGGER = LogManager.getLogger(Milk.class);
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    public Milk()
    {
        try{
            this.ShelfLife(25);
        }
        catch (ShelfLifeException ex)
        {
            LOGGER.error(ex.getMessage() +" entered shelflife was "+ ex.enteredShelfLife());
        }
        this.DefaultCost(1.1f);
        this.Name("Milk");
        ID = 5;
    }
}
