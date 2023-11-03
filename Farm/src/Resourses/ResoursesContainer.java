package Resourses;

import AbstractEntities.Farming;

import java.io.Serializable;
import java.util.ArrayList;

public class ResoursesContainer implements Serializable
{
    Corn corn = new Corn();
    Watter water = new Watter();
    int size = 0;
    ArrayList<AbstractResourse> container = new ArrayList<AbstractResourse>();

    public ResoursesContainer()
    {
        container.add(corn);
        this.size++;
        container.add(water);
        this.size++;
    }

    public int GetSize() {
        return this.size;
    }

    public float CornVolume()
    {
        return this.corn.Volume();
    }
    public float WatterVolume()
    {
        return this.water.Volume();
    }
    public void ChangeResurseVolume(AbstractResourse resourse, float volume)
    {
          container.get(resourse.ID-1).ChangeVolume(volume);
    }

    public boolean CheckWaterAvailability()
    {
        return !(container.get(0).Volume() <= 0);
    }
    public boolean CheckCornAvailability()
    {
        return !(container.get(1).Volume() <= 0);
    }
    public void ReduceResource(Farming farming)
    {
          ChangeResurseVolume(farming.LiquidAbstractResourse(), -1*farming.SolidResourseVolumRequierment());
    }
}
