package com.solvd.mavenFarm.exception;

public class ShelfLifeException extends Exception
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
