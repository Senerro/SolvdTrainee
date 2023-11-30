package com.solvd.mavenFarm.interfaces.functional;


import java.util.HashMap;

@FunctionalInterface
public interface IClassGettable<T, R> {
     void name(HashMap<T, R> list);
}
