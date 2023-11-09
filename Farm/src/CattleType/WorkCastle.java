package CattleType;

import AbstractEntities.Cattle;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;

public abstract class WorkCastle extends Cattle implements Serializable
{
    private boolean isWorking = false;
    public boolean GetWorkStatus()
    {
        return isWorking;
    }
    public void ChangeWorkStatus()
    {
        this.isWorking = !this.isWorking;
    }
    public abstract void DoSomeWork();
    @Override
    public int hashCode()
    {
        System.out.println("[MyHasCode activated]");
        return Objects.hash(name);
    }
    @Override
    public boolean equals(final Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        if(this.currentCost == ((WorkCastle) object).currentCost && this.defaultCost == ((WorkCastle) object).defaultCost)
            if (this.name == ((WorkCastle) object).name)
                return true;

        return false;
    }
    @Override
    public String toString() {
        return "Cattle{" + "name='" + name + '\'' + ", age='" + age + '\'' + ", working ours=" + this.workingHours + '}';
    }
}
