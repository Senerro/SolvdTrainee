package CattleType;

import AbstractEntities.Cattle;
import AbstractEntities.Farming;
import Farm.Farm;
import Raw.AbstractRaw;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public abstract class RawCattle extends Cattle implements Serializable
{
    public boolean isDead = false;
    private float weight = 0.1f;
    public abstract List<AbstractRaw> Harvest();

    public void CattleWeight(float weight)
    {
        this.weight =  weight;
    }
    public float CattleWeight()
    {
        return this.weight;
    }

    public boolean isDead() {
        return isDead;
    }
    public void Death(Farm farm, Farming cattle)
    {
        this.Harvest();
        farm.farmingList.RawCattleList().remove(cattle);
    }
    @Override
    public int hashCode()
    {
        System.out.println("[MyHasCode activated]");
        return Objects.hash(name, this.getClass());
    }
    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        if(this.currentCost == ((RawCattle) object).currentCost && this.defaultCost == ((RawCattle) object).defaultCost)
            if (this.name == ((RawCattle) object).name)
                return true;

        return false;
    }
    @Override
    public String toString() {
        return "Cattle{" + "name='" + Name() + '\'' + ", age='" + Age() + '\'' + ", weight =" + CattleWeight() + '\'' + ", cost='" + CurrentCost() + '}';
    }
    public String toStringInFarm() {
        return "Cattle{" + "name='" + Name() + '\'' + ", age='" + Age() + '\'' + ", weight =" + CattleWeight() + '\'' + '}';
    }
}
