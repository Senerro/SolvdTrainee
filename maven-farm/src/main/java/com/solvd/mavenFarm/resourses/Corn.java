package com.solvd.mavenFarm.resourses;

import java.io.Serializable;

public class Corn extends AbstractResource implements Serializable {
    public Corn()
    {
        this.defaultCost(0.5f);
        this.name("Corn");
        ID = 1;
    }
}
