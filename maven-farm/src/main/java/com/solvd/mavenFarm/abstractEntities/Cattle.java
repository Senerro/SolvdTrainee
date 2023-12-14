package com.solvd.mavenFarm.abstractEntities;

import java.io.Serializable;

public abstract class Cattle extends Farming implements Serializable {
    protected int age;

    public int age() {
        return age;
    }

    public void age(final int age) {
        this.age = age;
    }
}