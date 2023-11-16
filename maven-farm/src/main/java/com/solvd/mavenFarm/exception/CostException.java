package com.solvd.mavenFarm.exception;

public class CostException extends Exception {
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

