package com.solvd.mavenFarm.cattleType.reqularRawCattle;

import com.solvd.mavenFarm.cattleType.RawCattle;
import com.solvd.mavenFarm.enums.Raws;
import com.solvd.mavenFarm.raw.AbstractRaw;
import com.solvd.mavenFarm.raw.Meat;
import com.solvd.mavenFarm.raw.Milk;
import com.solvd.mavenFarm.resourses.Corn;
import com.solvd.mavenFarm.resourses.Water;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Cow extends RawCattle implements Serializable {
    private int color;
    public Cow() {
        name("Cow");

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

    public void SetColor(int color) {
        this.color = color;
    }

    @Override
    public ArrayList<AbstractRaw> harvest() {
        return isDead() ? new ArrayList<>(Arrays.asList(Raws.Meat.get(), Raws.Milk.get()))
                        : new ArrayList<>(Arrays.asList(Raws.Milk.get()));
    }
}
