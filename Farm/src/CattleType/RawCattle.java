package CattleType;

import AbstractEntities.Cattle;
import AbstractEntities.Farming;
import Farm.Farm;

import java.io.Serializable;

public abstract class RawCattle extends Cattle implements Serializable
{
    public boolean isDead = false;
    private float weight = 0.1f;
    public abstract void GetSomeRaw();

    public void SetCattleWeight(float weight)
    {
        this.weight =  weight;
    }
    public float GetCattleWeight()
    {
        return this.weight;
    }

    public boolean isDead() {
        return isDead;
    }
    public void Death(Farm farm, Farming cattle)
    {

        this.GetSomeRaw();
        farm.farmingList.GetRawCattleList().remove(cattle);

    }
}
