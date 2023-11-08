package Resourses;

import AbstractEntities.Farming;

import java.io.Serializable;
import java.util.ArrayList;

public class ResourcesContainer implements Serializable
{
    Corn corn = new Corn();
    Water water = new Water();
    ArrayList<AbstractResourse> container = new ArrayList<AbstractResourse>();

    public ResourcesContainer()
    {
        container.add(corn);
        container.add(water);
    }

    public float CornVolume()
    {
        return this.corn.Volume();
    }
    public float WatterVolume()
    {
        return this.water.Volume();
    }
    public final void ChangeResurсeVolume(AbstractResourse resource, float volume)
    {
        boolean isSpotted = false;
                do
                {
                    for (int i = 0; i < container.size(); i++)
                        if(container.get(i).getClass() == (resource.getClass()))
                        {
                            container.get(i).ChangeVolume(volume);
                            isSpotted = true;
                        }
                }
                while (!isSpotted);
    }


    public boolean CheckWaterAvailability()
    {
        return (container.get(0).Volume() > 0);
    }
    public boolean CheckCornAvailability()
    {
        return (container.get(1).Volume() > 0);
    }
    public final void ReduceResource(Farming farming)
    {
            ChangeResurсeVolume(farming.SolidAbstractResource(),-1*farming.SolidResourceVolumeRequirement());
            ChangeResurсeVolume(farming.LiquidAbstractResource(), -1*farming.LiquidResourceVolumeRequirement());
    }
}
