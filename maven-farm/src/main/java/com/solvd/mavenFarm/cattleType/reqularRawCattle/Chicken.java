package com.solvd.mavenFarm.cattleType.reqularRawCattle;

import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.enums.Raws;
import com.solvd.mavenFarm.raw.AbstractRaw;
import com.solvd.mavenFarm.resourses.Corn;
import com.solvd.mavenFarm.resourses.Water;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Chicken extends RawCattle implements Serializable {
    public Chicken() {
        name("Chicken");
        Corn corn = new Corn();
        Water water = new Water();

        this.cattleWeight(850);
        this.defaultCost(2.5f);
        this.defaultCost(this.defaultCost() * cattleWeight());
        this.liquidAbstractResource(water);
        this.liquidResourceVolumeRequirement(50);
        this.solidAbstractResource(corn);
        this.solidResourceVolumeRequirement(50);
    }

    @Override
    public ArrayList<AbstractRaw> harvest() {
        return isDead() ? new ArrayList<>(Arrays.asList(Raws.MEAT.get(),Raws.EGG.get()))
                        : new ArrayList<>(Arrays.asList(Raws.EGG.get()));
    }
}

