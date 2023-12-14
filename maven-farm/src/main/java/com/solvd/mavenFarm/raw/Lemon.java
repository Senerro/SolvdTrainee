package com.solvd.mavenFarm.raw;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.Serializable;

public class Lemon extends AbstractRaw implements Serializable {
    static final Logger LOGGER = LogManager.getLogger(Lemon.class);

    static {
        System.setProperty("log4j.configurationFile", "log4j.xml");
    }

    public Lemon() {
        this.shelfLife(25);
        this.defaultCost(0.2f);
        this.name("Lemon");
    }
}
