package CattleType;

import AbstractEntities.Cattle;

import java.io.Serializable;

public abstract class RawCattle extends Cattle implements Serializable
{
    private boolean isDead = false;
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
    public void Death()
    {
        int b = 6/0;
    }
}
