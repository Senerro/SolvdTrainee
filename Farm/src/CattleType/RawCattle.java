package CattleType;

import AbstractEntities.Cattle;
import AbstractEntities.Farming;
import Farm.Farm;
import Raw.AbstractRaw;
import Exception.CattleWeightException;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public abstract class RawCattle extends Cattle implements Serializable
{
    private static final Logger LOGGER = Logger.getLogger(RawCattle.class);


    public boolean isDead = false;
    private float weight = 0.1f;
    public abstract List<AbstractRaw> Harvest();

    public void CattleWeight(final float weight)
    {
        if(weight <= 0)
        {
            try{throw new CattleWeightException(weight);}
            catch (CattleWeightException e)
            {
                this.weight = 0.1f;
                LOGGER.error(e.GetInfo());
            }
        }

        this.weight =  weight;
    }
    public float CattleWeight()
    {
        return this.weight;
    }

    public boolean isDead() {
        return isDead;
    }
    public void Death(final Farm farm, final Farming cattle)
    {
        this.Harvest();
        farm.farmingList.RawCattle().remove(cattle);
    }
    @Override
    public int hashCode()
    {
        System.out.println("[MyHasCode activated]");
        return Objects.hash(name, this.getClass());
    }
    @Override
    public boolean equals(final Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if(this.DefaultCost() == ((RawCattle) object).DefaultCost() && this.Age() == ((RawCattle) object).Age())
            if (this.Name() == ((RawCattle) object).Name() && this.CattleWeight() == ((RawCattle) object).CattleWeight())
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
