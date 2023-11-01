package CattleType;

import AbstractEntities.Cattle;

import java.io.Serializable;

public abstract class WorkCastle extends Cattle implements Serializable
{
    private boolean isWorking;
    public boolean GetWorkStatus()
    {
        return isWorking;
    }
    public void ChangeWorkStatus()
    {
        this.isWorking = !this.isWorking;
    }
    public abstract void DoSomeWork();
}
