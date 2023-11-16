package com.solvd.mavenFarm.exception;

public class NameFarmingException extends Exception
{
    private final String name;
    public NameFarmingException()
    {
        super("Name can not be empty");
        this.name = "unknown";
    }
    public String name()
    {
        return this.name;
    }
    public String getInfo()
    {
        return super.getMessage() + " You entered empty name. Now it was given an " + name() + " name";
    }
}

