package AbstractEntities;

import Raw.AbstractRaw;
import Resourses.AbstractResourse;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Farming implements Serializable
{
    private int chunk;

    protected float defaultCost;
    protected float currentCost;
    protected String name;
    private float solidResourseVolumRequierment;
    private float liquidResourseVolumRequierment;

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
    public void SolidAbstractResource(final AbstractResourse resourse)
    {
        this.solidFood = resourse;
    }
    public AbstractResourse SolidAbstractResource()
    {
        return this.solidFood;
    }
    public float SolidResourceVolumeRequirement()
    {
        return this.solidResourseVolumRequierment;
    }
    public void LiquidResourceVolumeRequirement(final float resourseVolumRequierment)
    {
        this.liquidResourseVolumRequierment = resourseVolumRequierment;
    }
    public float LiquidResourceVolumeRequirement()
    {
        return this.solidResourseVolumRequierment;
    }
    public void SolidResourceVolumeRequirement(final float resourseVolumRequierment)
    {
        this.solidResourseVolumRequierment = resourseVolumRequierment;
    }
    public String Name()
    {
        return name;
    }
    public void Name(final String name)
    {
        if (!name.isEmpty())
            this.name = name;
        else
            this.name = "unknown";
    }
    public ArrayList<AbstractRaw> RawResult()
    {
        return this.RawResult();
    }

    public float CurrentCost() {
        return currentCost;
    }

    public void CurrentCost(final float currentCost) {
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
