package com.solvd.mavenFarm.resourses;

import java.io.Serializable;

public class Water extends AbstractResource implements Serializable
{
    public Water()
    {
        this.DefaultCost(1);
        this.Name("Water");
        ID = 2;
    }
}
