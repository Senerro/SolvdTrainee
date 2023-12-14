package com.solvd.mavenFarm.raw;
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

        this.shelfLife(45);
        this.defaultCost(0.9f/6);
        this.name("Apple");
    }
}
