package com.solvd.mavenFarm.cattleType;

import com.solvd.mavenFarm.abstractEntities.Cattle;
import com.solvd.mavenFarm.abstractEntities.Farming;
import com.solvd.mavenFarm.enums.Raws;
import com.solvd.mavenFarm.exception.CattleWeightException;
import com.solvd.mavenFarm.farm.Farm;
import com.solvd.mavenFarm.raw.AbstractRaw;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class RawCattle extends Cattle implements Serializable
{
    static final Logger LOGGER = LogManager.getLogger(RawCattle.class);
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    private Raws raw;
    public boolean isDead = false;
    private float weight = 0.1f;
    public Raws raw()
    {
        return this.raw;
    }
    public void raw(Raws raw)
    {
        this.raw = raw;
    }
    public void raw(AbstractRaw raw)
    {
        this.raw = this.raw.set(raw);
    }
    public abstract List<AbstractRaw> harvest();

    public void cattleWeight(final float weight)
    {
        if(weight <= 0)
        {
            try{throw new CattleWeightException(weight);}
            catch (CattleWeightException e)
            {
                this.weight = 0.1f;
                LOGGER.error(e.getInfo());
            }
        }

        this.weight =  weight;
    }
    public float cattleWeight()
    {
        return this.weight;
    }

    public boolean isDead() {
        return isDead;
    }
    public void death(final Farm farm, final Farming cattle)
    {
        this.harvest();

        farm.farmingList.rawCattle().remove((RawCattle)cattle);
    }
    public void death(final Farm farm)
    {
        this.harvest();
        farm.farmingList.rawCattle().remove(this);
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
        if(this.defaultCost() == ((RawCattle) object).defaultCost() && this.age() == ((RawCattle) object).age())
            if (this.name().equals(((RawCattle) object).name()) && this.cattleWeight() == ((RawCattle) object).cattleWeight())
                return true;

        return false;
    }
    @Override
    public String toString() {
        return "Cattle{" + "name='" + name() + '\'' + ", age='" + age() + '\'' + ", weight =" + cattleWeight() + '\'' + ", cost='" + currentCost() + '}';
    }
    public String toStringInFarm() {
        return "Cattle{" + "name='" + name() + '\'' + ", age='" + age() + '\'' + ", weight =" + cattleWeight() + '\'' + '}';
    }

}

