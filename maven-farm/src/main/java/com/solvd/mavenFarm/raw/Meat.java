package com.solvd.mavenFarm.raw;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.Serializable;

public class Meat extends AbstractRaw implements Serializable {
    static final Logger LOGGER = LogManager.getLogger(Meat.class);

    static {
        System.setProperty("log4j.configurationFile", "log4j.xml");
    }

    public Meat() {
        this.shelfLife(25);
        this.defaultCost(5);
        this.name("Meat");
    }
}
