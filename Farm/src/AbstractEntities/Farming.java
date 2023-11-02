package AbstractEntities;

import Resourses.AbstractResourse;

import java.io.Serializable;

public abstract class Farming implements Serializable
{
    private AbstractResourse resourse;
    private float resourseVolumRequierment;
    public void SetAbstractResourse(AbstractResourse resourse)
    {
        this.resourse = resourse;
    }
    public AbstractResourse GetAbstractResourse()
    {
        return this.resourse;
    }
    public float GetResourseVolumRequierment()
    {
        return this.resourseVolumRequierment;
    }
    public void SetResourseVolumRequierment(float resourseVolumRequierment)
    {
        this.resourseVolumRequierment = resourseVolumRequierment;
    }
    protected float defaultCost;
    protected float currentCost;
    protected String name;
    public int ID;

    public String GetName()
    {
        return name;
    }
    public void SetName(String name)
    {
        if (!name.isEmpty())
            this.name = name;
        else
            this.name = "unknown";
    }



    public float GetCurrentCost() {
        return currentCost;
    }

    public void SetCurrentCost(float currentCost) {
        this.currentCost = currentCost;
    }
    public float GetDefaultCost() {
        return defaultCost;
    }

    public void SetDefaultCost(float defaultCost) {
        this.defaultCost = defaultCost;
    }

    public abstract void Eat() ;
    public abstract void Drink();
    public abstract void GrowUp();


}
