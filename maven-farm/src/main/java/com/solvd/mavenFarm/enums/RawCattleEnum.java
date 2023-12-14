package com.solvd.mavenFarm.enums;

import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Chicken;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Cow;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Pig;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Sheep;

public enum RawCattleEnum
{
    CHICKEN(new Chicken()),
    COW(new Cow()),
    PIG(new Pig()),
    SHEEP(new Sheep()),
    ;RawCattle animal;
    RawCattleEnum(RawCattle animal)
    {
        this.animal = animal;
    }
    public RawCattle get()
    {
        return this.animal;
    }
}
