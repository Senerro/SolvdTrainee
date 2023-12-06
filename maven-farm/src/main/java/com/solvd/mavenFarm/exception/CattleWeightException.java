package com.solvd.mavenFarm.exception;

import java.io.Serializable;

public class CattleWeightException extends Exception implements Serializable {
    private final float value;
    public CattleWeightException(final float value)
    {

        super("Value isn't able to be negative");
        this.value = value;
    }
    private float getEnteredValue()
    {
        return this.value;
    }
    public String getInfo()
    {
        return super.getMessage() + " You entered " + getEnteredValue();
    }

}

