package com.solvd.mavenFarm.exception;

import java.io.Serializable;

public class ShelfLifeException extends Exception implements Serializable
{
    private final float shelfLife;
    public ShelfLifeException(String message, float seedingArea)
    {
        super(message);
        this.shelfLife = seedingArea;
    }
    public float enteredShelfLife()
    {
        return this.shelfLife;
    }
}
