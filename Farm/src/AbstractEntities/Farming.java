package AbstractEntities;

import Raw.AbstractRaw;
import Resourses.AbstractResourse;
import Resourses.ResoursesContainer;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Farming implements Serializable
{
    public ResoursesContainer container = new ResoursesContainer();
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
    private ArrayList<AbstractRaw> rawResult = new ArrayList<>();
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
    public ArrayList<AbstractRaw> GetRawResult()
    {
        return this.GetRawResult();
    }
    public void AddRaw(AbstractRaw raw)
    {
        this.rawResult.add(raw);
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
