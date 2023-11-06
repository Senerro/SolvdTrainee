package Resourses;

import java.io.Serializable;

public class AbstractResourse implements Serializable
{
    public int ID;
    private String name;
    private float volume;
    private int Chunk;
    private float defaultCost;
    private float currentCost;


    public float DefaultCost() {
        return defaultCost;
    }
    public void DefaultCost(float defaultCost)
    {
        this.defaultCost = defaultCost;
    }
    public void CurrentCost(float currentCost)
    {
        this.currentCost = currentCost;
    }
    public void ChangeCurrentCost(float currentCost)
    {
     this.currentCost += currentCost;
     if(this.currentCost<0)
         this.currentCost = 0;
    }


    public float Volume() {
        return this.volume;
    }
    public void Volume(float volume)
    {
        this.volume = volume;
    }
    public void ChangeVolume(float volume)
    {
        this.volume+= volume;
    }

    public void Name(String name) {
        this.name = name;
    }
    public String Name()
    {
        return this.name;
    }
}

