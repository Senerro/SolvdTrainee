package AbstractEntities;

import Raw.AbstractRaw;
import Resourses.AbstractResourse;
import Resourses.ResoursesContainer;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Farming implements Serializable
{
    private int chunk;
    public ResoursesContainer container = new ResoursesContainer();
    private AbstractResourse solidFood = new AbstractResourse();
    private AbstractResourse liquidFood = new AbstractResourse();


    private float resourseVolumRequierment;
    public void LiquidAbstractResourse(AbstractResourse resourse)
    {
        this.liquidFood = resourse;
    }
    public AbstractResourse LiquidAbstractResourse()
    {
        return this.liquidFood;
    }
    public float SolidResourseVolumRequierment()
    {
        return this.resourseVolumRequierment;
    }
    public void SolidResourseVolumRequierment(float resourseVolumRequierment)
    {
        this.resourseVolumRequierment = resourseVolumRequierment;
    }
    protected float defaultCost;
    protected float currentCost;
    protected String name;
    public int ID;
    private ArrayList<AbstractRaw> rawResult = new ArrayList<>();
    public String Name()
    {
        return name;
    }
    public void Name(String name)
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
    public void Raw(AbstractRaw raw)
    {
        this.rawResult.add(raw);
    }

    public float CurrentCost() {
        return currentCost;
    }

    public void CurrentCost(float currentCost) {
        this.currentCost = currentCost;
    }
    public float DefaultCost() {
        return defaultCost;
    }

    public void DefaultCost(float defaultCost) {
        this.defaultCost = defaultCost;
    }


    public abstract void Eat() ;
    public abstract void Drink();
    public abstract void GrowUp();


}
