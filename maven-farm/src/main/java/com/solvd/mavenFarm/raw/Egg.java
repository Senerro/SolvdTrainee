package com.solvd.mavenFarm.raw;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.Serializable;

public class Egg extends AbstractRaw implements Serializable
{
    static final Logger LOGGER = LogManager.getLogger(Egg.class);
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    public Egg()
    {
        this.shelfLife(25);
        this.defaultCost(0.1f);
        this.name("Egg");
    }
}
