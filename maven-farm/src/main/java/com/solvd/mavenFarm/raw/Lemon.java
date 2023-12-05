package com.solvd.mavenFarm.raw;
import com.solvd.mavenFarm.exception.ShelfLifeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.Serializable;

public class Lemon extends AbstractRaw implements Serializable
{
    static final Logger LOGGER = LogManager.getLogger(Lemon.class);
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    public Lemon()
    {
        try{
            this.shelfLife(25);
        }
        catch (ShelfLifeException ex)
        {
            LOGGER.error(ex.getMessage() +" entered shelflife was "+ ex.enteredShelfLife());
        }
        this.defaultCost(0.2f);
        this.name("Lemon");
        ID =3;
    }
}
