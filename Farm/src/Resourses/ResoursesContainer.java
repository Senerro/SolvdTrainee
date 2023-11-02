package Resourses;

import AbstractEntities.Cattle;
import AbstractEntities.Farming;
import CattleType.RawCattle;

import java.io.Serializable;
import java.util.ArrayList;

public class ResoursesContainer implements Serializable
{
    Corn corn = new Corn();
    Watter water = new Watter();
    ArrayList<AbstractResourse> container = new ArrayList<AbstractResourse>();
    public ResoursesContainer()
    {
        container.add(corn);
        container.add(water);
    }


    public float GetCornVolume()
    {
        return this.corn.GetVolume();
    }
    public float GetWatterVolume()
    {
        return this.water.GetVolume();
    }
    public void AddWaterVolume(float volum)
    {
        this.water.ChangeVolume(volum);
    }
    public void AddCornVolume(float volum)
    {
        this.corn.ChangeVolume(volum);
    }
    public void ReduceResource(Farming farming)
    {
          container.get(farming.GetAbstractResourse().ID-1).ChangeVolume(farming.GetResourseVolumRequierment());
    }

}
