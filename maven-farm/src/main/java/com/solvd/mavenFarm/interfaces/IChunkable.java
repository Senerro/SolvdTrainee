package com.solvd.mavenFarm.interfaces;

import com.solvd.mavenFarm.cattleType.RawCattle;

public interface IChunkable {
    boolean mergeInChunk(RawCattle animal, RawCattle animal2);
}
