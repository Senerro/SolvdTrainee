package Resourses;

import AbstractEntities.Cattle;
import AbstractEntities.Farming;
import CattleType.RawCattle;
import Raw.AbstractRaw;

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

    public float GetCornVolume()
    {
        return this.corn.GetVolume();
    }
    public float GetWatterVolume()
    {
        return this.water.GetVolume();
    }
    public void ChangeResurseVolume(AbstractResourse resourse, float volume)
    {
          container.get(resourse.ID-1).ChangeVolume(volume);
    }

    public boolean CheckWaterAvailability()
    {
        return !(container.get(0).GetVolume() <= 0);
    }
    public boolean CheckCornAvailability()
    {
        return !(container.get(1).GetVolume() <= 0);
    }
    public void ReduceResource(Farming farming)
    {
          ChangeResurseVolume(farming.GetAbstractResourse(), -1*farming.GetResourseVolumRequierment());
    }
}
