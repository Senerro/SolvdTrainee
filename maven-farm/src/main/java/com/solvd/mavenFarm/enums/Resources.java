package com.solvd.mavenFarm.enums;

import com.solvd.mavenFarm.resourses.AbstractResource;
import com.solvd.mavenFarm.resourses.Corn;
import com.solvd.mavenFarm.resourses.Water;

public enum Resources
{
    Corn(new Corn()),
    Water(new Water()),

    ;AbstractResource resource;
    Resources(AbstractResource resource)
    {
     this.resource = resource;
    }
    public AbstractResource get()
    {
        return this.resource;
    }

}
