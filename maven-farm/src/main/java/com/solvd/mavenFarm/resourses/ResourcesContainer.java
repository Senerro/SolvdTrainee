package com.solvd.mavenFarm.resourses;

import com.solvd.mavenFarm.abstractEntities.Farming;
import com.solvd.mavenFarm.enums.Resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ResourcesContainer implements Serializable
{
    Resources resEnum;
    ArrayList<AbstractResource> container = new ArrayList<AbstractResource>();

    Consumer<AbstractResource> res = x -> container.add(x);

    public ResourcesContainer()
    {
        for (var element: Resources.values()) {

            res.accept(element.get());
        }
    }
    public float CornVolume()
    {

        for (var element: Resources.values())
            if(element.getClass().getSimpleName().equals(Resources.Corn.get().getClass().getSimpleName()))
                return element.get().Volume();

        return new Corn().Volume();
    }
    public float WaterVolume()
    {
        for (var element: Resources.values())
            if(element.getClass().getSimpleName().equals(Resources.Water.get().getClass().getSimpleName()))
                return element.get().Volume();
        return new Water().Volume();
    }
    public final void ChangeResourceVolume(AbstractResource resource, float volume)
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
            ChangeResourceVolume(farming.solidAbstractResource(),-1*farming.solidResourceVolumeRequirement());
            ChangeResourceVolume(farming.liquidAbstractResource(), -1*farming.liquidResourceVolumeRequirement());
    }
}
