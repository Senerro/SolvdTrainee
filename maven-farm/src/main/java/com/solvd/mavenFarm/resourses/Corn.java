package com.solvd.mavenFarm.resourses;

import java.io.Serializable;

public class Corn extends AbstractResource implements Serializable {
    public Corn()
    {
        this.DefaultCost(0.5f);
        this.Name("Corn");
        ID = 1;
    }
}
