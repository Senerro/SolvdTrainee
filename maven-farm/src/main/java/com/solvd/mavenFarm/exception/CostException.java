package com.solvd.mavenFarm.exception;

import java.io.Serializable;

public class CostException extends Exception implements Serializable {
    private final float cost;
    public CostException(String message, float cost)
    {
        super(message);
        this.cost = cost;
    }
    public float enteredCost()
    {
        return this.cost;
    }
}

