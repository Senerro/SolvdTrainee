package com.solvd.mavenFarm.abstractEntities;

import java.io.Serializable;
import java.util.Objects;

public abstract class Food extends Farming implements Serializable
{
    public double seedingArea;
    public double seedingArea()
    {
        return this.seedingArea;
    }
    @Override
    public int hashCode()
    {
        System.out.println("[MyHasCode activated]");
        return Objects.hash( name, sort);
    }
    @Override
    public boolean equals(final Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        if(this.sort().equals( ((Food) object).sort()) )
            if (this.defaultCost() == ((Food) object).defaultCost() && this.seedingArea() == ((Food) object).seedingArea())
                return this.name.equals(((Food) object).name);

        return false;
    }
    @Override
    public String toString() {
        return "Spawner{" + "name='" + name() + '\'' + ", sort='" + sort() + '\'' + ", SeedingArea=" + seedingArea() +'}';
    }
    protected String sort;
    public Food()
    {
        sort("unknown");
    }
    public String sort()
    {
        return sort;
    }

    public void sort(final String sort)
    {
        this.sort = sort;
        System.out.println("Product " + this.getClass() + " get a sort " + this.sort);
    }

}

