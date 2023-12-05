package com.solvd.mavenFarm.cattleType;

import com.solvd.mavenFarm.abstractEntities.Cattle;

import java.io.Serializable;
import java.util.Objects;

public abstract class WorkCattle extends Cattle implements Serializable {
    private boolean isWorking = false;

    public boolean getWorkStatus() {
        return isWorking;
    }

    public void changeWorkStatus() {
        this.isWorking = !this.isWorking;
    }

    public abstract void doSomeWork();

    @Override
    public int hashCode() {
        System.out.println("[MyHasCode activated]");
        return Objects.hash(name);
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        if (this.currentCost == ((WorkCattle) object).currentCost && this.defaultCost == ((WorkCattle) object).defaultCost)
            return this.name.equals(((WorkCattle) object).name);

        return false;
    }

    @Override
    public String toString() {
        return "Cattle{" + "name='" + name + '\'' + ", age='" + age + '\'' + ", working ours=" + this.workingHours + '}';
    }
}
