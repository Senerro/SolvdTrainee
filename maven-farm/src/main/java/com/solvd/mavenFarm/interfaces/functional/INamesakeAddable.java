package com.solvd.mavenFarm.interfaces.functional;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface INamesakeAddable<T>
{
    void add(String condition, ArrayList<T> list);

}
