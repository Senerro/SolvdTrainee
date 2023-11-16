package com.solvd.mavenFarm.abstractEntities;

import com.solvd.mavenFarm.exception.NameFarmingException;
import com.solvd.mavenFarm.resourses.AbstractResource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public abstract class Farming implements Serializable
{
    static final Logger LOGGER = LogManager.getLogger(Farming.class);
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    private int chunk = 1;

    public void increaseChunk(final int chunk)
    {
        this.chunk += chunk;
    }
    public int chunk()
    {
        return this.chunk;
    }

    protected float defaultCost;
    protected float currentCost;
    protected String name;
    private float solidResourceVolumeRequirement;
    private float liquidResourceVolumeRequirement;

    private AbstractResource solidFood = new AbstractResource();
    private AbstractResource liquidFood = new AbstractResource();



    public void liquidAbstractResource(final AbstractResource resource)
    {
        this.liquidFood = resource;
    }
    public AbstractResource liquidAbstractResource()
    {
        return this.liquidFood;
    }
    public void solidAbstractResource(final AbstractResource resource)
    {
        this.solidFood = resource;
    }
    public AbstractResource solidAbstractResource()
    {
        return this.solidFood;
    }
    public float solidResourceVolumeRequirement()
    {
        return this.solidResourceVolumeRequirement;
    }
    public void liquidResourceVolumeRequirement(final float resourceVolumeRequirement)
    {
        this.liquidResourceVolumeRequirement = resourceVolumeRequirement;
    }
    public float liquidResourceVolumeRequirement()
    {
        return this.liquidResourceVolumeRequirement;
    }
    public void solidResourceVolumeRequirement(final float resourceVolumeRequirement)
    {
        this.solidResourceVolumeRequirement = resourceVolumeRequirement;
    }
    public String name()
    {
        return name;
    }
    public void name(final String name)
    {
        if(name.isEmpty()) {
            try {
                throw new NameFarmingException();
            }
            catch (NameFarmingException e) {
                LOGGER.warn(e.getInfo());
                this.name = e.name();
            }
        }
        else
            this.name = name;
    }
    public float currentCost() {
        return currentCost;
    }
    public void currentCost(final float currentCost) /*throws CostException */{
        /*if(currentCost<=0) {
            throw new CostException("We aren't charity organization", currentCost);
        }*/

        this.currentCost = currentCost;
    }

    public float defaultCost() {
        return defaultCost;
    }

    public void defaultCost(final float defaultCost) {
        this.defaultCost = defaultCost;
    }
    public abstract void eat() ;
    public abstract void drink();
    public abstract void growUp();
}

