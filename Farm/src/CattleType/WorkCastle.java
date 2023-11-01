package CattleType;

import AbstractEntities.Cattle;

public abstract class WorkCastle extends Cattle
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
