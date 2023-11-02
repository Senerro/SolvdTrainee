package Resourses;

import java.io.Serializable;

public class AbstractResourse implements Serializable
{
    private float volume = 0f;
    private String name;
    public int ID;
    private float defaultCost;
    private float currentCost;


    public float GetDefaultCost() {
        return defaultCost;
    }
    public void SetDefaultCost(float defaultCost)
    {
        this.defaultCost = defaultCost;
    }
    public void SetCurrentCost(float currentCost)
    {
        this.currentCost = currentCost;
    }
    public void ChangeCurrnentCost(float currentCost)
    {
     this.currentCost += currentCost;
     if(this.currentCost<0)
         this.currentCost = 0;
    }


    public float GetVolume() {
        return this.volume;
    }
    public void SetVolume(float volume)
    {
        this.volume = volume;
    }
    public void ChangeVolume(float volume)
    {
        this.volume+= volume;
    }

    public void SetName(String name) {
        this.name = name;
    }
    public String GetName()
    {
        return this.name;
    }
}

