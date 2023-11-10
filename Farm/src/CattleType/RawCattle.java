package CattleType;

import AbstractEntities.Cattle;
import AbstractEntities.Farming;
import Farm.Farm;
import Raw.AbstractRaw;
import Exception.CattleWeightException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public abstract class RawCattle extends Cattle implements Serializable
{
    static final Logger LOGGER = LogManager.getLogger(RawCattle.class);
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }

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
        farm.farmingList.RawCattle().remove((RawCattle)cattle);
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
            if (this.Name().equals(((RawCattle) object).Name()) && this.CattleWeight() == ((RawCattle) object).CattleWeight())
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
