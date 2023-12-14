package com.solvd.mavenFarm.enums;

import com.solvd.mavenFarm.raw.*;

public enum Raws
{
    EGG(new Egg()),
    MEAT(new Meat()),
    MILK(new Milk()),
    WOOL(new Wool()),
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
