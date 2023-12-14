package com.solvd.mavenFarm.raw;
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
        this.shelfLife(7*365);
        this.defaultCost(74.56f);
        this.name("Wool");
    }
}
