package com.solvd.mavenFarm.enums;

import com.solvd.mavenFarm.raw.*;

public enum Raws
{
    Apple(new Apple()),
    Egg(new Egg()),
    Lemon(new Lemon()),
    Meat(new Meat()),
    Milk(new Milk()),
    Wool(new Wool()),
    ;
    private AbstractRaw object;

    Raws(AbstractRaw object)
    {
        this.object = object;
    }
    public AbstractRaw get()
    {
        return this.object;
    }
    @Override
    public String toString()
    {
        return this.object.toString();
    }
    public Raws set(AbstractRaw raw)
    {
        return Raws.valueOf(raw.getClass().getSimpleName());
    }
}
