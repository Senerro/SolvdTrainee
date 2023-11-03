package CattleType;

import AbstractEntities.Cattle;
import AbstractEntities.Farming;
import Farm.Farm;

import java.io.Serializable;
import java.util.Objects;

public abstract class RawCattle extends Cattle implements Serializable
{
    public boolean isDead = false;
    private float weight = 0.1f;
    public abstract void SomeRaw();

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
        this.SomeRaw();
        farm.farmingList.GetRawCattleList().remove(cattle);

    }
    @Override
    public int hashCode()
    {
        System.out.println("[MyHasCode activated]");
        return Objects.hash(ID, name, this.getClass());
    }
    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        if(this.currentCost == ((RawCattle) object).currentCost && this.defaultCost == ((RawCattle) object).defaultCost)
            if (this.ID == ((RawCattle) object).ID && this.name == ((RawCattle) object).name)
                return true;

        return false;
    }
    @Override
    public String toString() {
        return "Cattle{" + "name='" + name + '\'' + ", age='" + age + '\'' + ", weight =" + this.weight + '}';
    }
}
