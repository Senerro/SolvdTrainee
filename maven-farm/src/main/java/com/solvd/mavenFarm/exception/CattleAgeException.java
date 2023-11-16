package com.solvd.mavenFarm.exception;

public class CattleAgeException extends Exception
{
    private final int age;
    public CattleAgeException(final int age)
    {
        super("Age isn't able to be negative or unnatural");
        this.age = age;
    }
    private float getEnteredValue()
    {
        return this.age;
    }
    public String getInfo()
    {
        return super.getMessage() + ". You entered " + getEnteredValue();
    }
}
