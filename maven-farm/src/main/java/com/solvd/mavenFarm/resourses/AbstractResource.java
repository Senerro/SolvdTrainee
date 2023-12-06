package com.solvd.mavenFarm.resourses;

import java.io.Serializable;
import java.util.Objects;

public class AbstractResource implements Serializable
{
    public int ID;
    private String name;
    private float volume;
    private int chunk;
    private float defaultCost;
    private float currentCost;
    public int chunk()
    {
        return this.chunk;
    }
    public void increaseChunk(int chunk)
    {
        this.chunk+=chunk;
    }


    public float defaultCost() {
        return defaultCost;
    }
    public void defaultCost(float defaultCost)
    {
        this.defaultCost = defaultCost;
    }
    public void currentCost(float currentCost)
    {
        this.currentCost = currentCost;
    }
    public void changeCurrentCost(float currentCost)
    {
     this.currentCost += currentCost;
     if(this.currentCost<0)
         this.currentCost = 0;
    }


    public float volume() {
        return this.volume;
    }
    public void volume(float volume)
    {
        this.volume = volume;
    }
    public void changeVolume(float volume)
    {
        this.volume+= volume;
    }

    public void name(String name) {
        this.name = name;
    }
    public String name()
    {
        return this.name;
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(this.getClass(), this.name)+34;
    }
}

