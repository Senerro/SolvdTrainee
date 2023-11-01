package CattleType;

import AbstractEntities.Cattle;

import java.io.Serializable;

public abstract class RawCattle extends Cattle implements Serializable
{
    public abstract void GetSomeRaw();
}
