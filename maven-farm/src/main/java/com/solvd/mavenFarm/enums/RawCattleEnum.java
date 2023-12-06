package com.solvd.mavenFarm.enums;

import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Chicken;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Cow;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Pig;
import com.solvd.mavenFarm.cattleType.reqularRawCattle.Sheep;

public enum RawCattleEnum
{
    Chicken(new Chicken()),
    Cow(new Cow()),
    Pig(new Pig()),
    Sheep(new Sheep()),
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
