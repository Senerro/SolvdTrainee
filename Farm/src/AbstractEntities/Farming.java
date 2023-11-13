package AbstractEntities;

import Resourses.AbstractResourse;
import Exception.*;
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

    public void IncreaseChunk(final int chunk)
    {
        this.chunk += chunk;
    }
    public int Chunk()
    {
        return this.chunk;
    }

    protected float defaultCost;
    protected float currentCost;
    protected String name;
    private float solidResourceVolumeRequirement;
    private float liquidResourceVolumeRequirement;

    private AbstractResourse solidFood = new AbstractResourse();
    private AbstractResourse liquidFood = new AbstractResourse();



    public void LiquidAbstractResource(final AbstractResourse resource)
    {
        this.liquidFood = resource;
    }
    public AbstractResourse LiquidAbstractResource()
    {
        return this.liquidFood;
    }
    public void SolidAbstractResource(final AbstractResourse resource)
    {
        this.solidFood = resource;
    }
    public AbstractResourse SolidAbstractResource()
    {
        return this.solidFood;
    }
    public float SolidResourceVolumeRequirement()
    {
        return this.solidResourceVolumeRequirement;
    }
    public void LiquidResourceVolumeRequirement(final float resourceVolumeRequirement)
    {
        this.liquidResourceVolumeRequirement = resourceVolumeRequirement;
    }
    public float LiquidResourceVolumeRequirement()
    {
        return this.liquidResourceVolumeRequirement;
    }
    public void SolidResourceVolumeRequirement(final float resourceVolumeRequirement)
    {
        this.solidResourceVolumeRequirement = resourceVolumeRequirement;
    }
    public String Name()
    {
        return name;
    }
    public void Name(final String name)
    {
        if(name.isEmpty()) {
            try {
                throw new NameFarmingException();
                }
            catch (NameFarmingException e) {
                LOGGER.warn(e.GetInfo());
                this.name = e.Name();
            }
        }
        else
            this.name = name;
    }
    public float CurrentCost() {
        return currentCost;
    }
    public void CurrentCost(final float currentCost) /*throws CostException */{
        /*if(currentCost<=0) {
            throw new CostException("We aren't charity organization", currentCost);
        }*/

        this.currentCost = currentCost;
    }

    public float DefaultCost() {
        return defaultCost;
    }

    public void DefaultCost(final float defaultCost) {
        this.defaultCost = defaultCost;
    }
    public abstract void Eat() ;
    public abstract void Drink();
    public abstract void GrowUp();
}
