package com.solvd.mavenFarm.resourses;

import java.io.Serializable;

public class Water extends AbstractResource implements Serializable
{
    public Water()
    {
        this.defaultCost(1);
        this.name("Water");
        ID = 2;
    }
}
