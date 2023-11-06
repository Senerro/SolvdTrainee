package Interfaces;

import AbstractEntities.Farming;
import CattleType.RawCattle;

public interface IChunkable {
    boolean MergeInChunk(RawCattle animal, RawCattle animal2);
}
