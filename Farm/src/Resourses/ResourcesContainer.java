package Resourses;

import AbstractEntities.Farming;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class ResourcesContainer implements Serializable
{
    Corn corn = new Corn();
    Water water = new Water();
    HashSet<AbstractResourse> container = new HashSet<>();

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
    public final void ChangeResourceVolume(AbstractResourse resource, float volume)
    {
      /*  boolean isSpotted = false;
                do
                {
                    for (int i = 0; i < container.size(); i++)
                        if(container.get(i).getClass() == (resource.getClass()))
                        {
                            container.get(i).ChangeVolume(volume);
                            isSpotted = true;
                        }
                }
                while (!isSpotted);*/
        for (var element:container) {
            if(element.getClass().equals(resource.getClass()))
                element.ChangeVolume(volume);
        }
    }

    public boolean CheckWaterAvailability()
    {
        return( WatterVolume() > 0);
    }
    public boolean CheckCornAvailability()
    {
        return (CornVolume() > 0);
    }
    public final void ReduceResource(Farming farming)
    {
            ChangeResourceVolume(farming.SolidAbstractResource(),-1*farming.SolidResourceVolumeRequirement());
            ChangeResourceVolume(farming.LiquidAbstractResource(), -1*farming.LiquidResourceVolumeRequirement());
    }

}
