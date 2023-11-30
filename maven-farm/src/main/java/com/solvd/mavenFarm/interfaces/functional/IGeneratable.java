package com.solvd.mavenFarm.interfaces.functional;

import com.solvd.mavenFarm.listick.MyList;
@FunctionalInterface
public interface IGeneratable<T>
{
    void fill(T object, int iterator, MyList<T> list);
}
