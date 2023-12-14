package com.solvd.mavenFarm.cattleType;

import com.solvd.mavenFarm.abstractEntities.Cattle;
import com.solvd.mavenFarm.enums.Raws;
import com.solvd.mavenFarm.farm.Farm;
import com.solvd.mavenFarm.global.GlobalEvent;
import com.solvd.mavenFarm.global.GlobalStateEnum;
import com.solvd.mavenFarm.raw.AbstractRaw;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public abstract class RawCattle extends Cattle implements Serializable {
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    static final Logger LOGGER = LogManager.getLogger(RawCattle.class);
    private Raws raw;
    private boolean isDead = (GlobalEvent.state == GlobalStateEnum.DEBUG);
    private float weight = 0.1f;
    public abstract List<AbstractRaw> harvest();

    public Raws raw() {
        return this.raw;
    }

    public void raw(Raws raw) {
        this.raw = raw;
    }

    public void raw(AbstractRaw raw) {
        this.raw = this.raw.set(raw);
    }

    public void cattleWeight(final float weight) {
        this.weight =  weight;
    }

    public float cattleWeight() {
        return this.weight;
    }

    public boolean isDead() {
        return isDead;
    }

    public void isDead(boolean b) {
        this.isDead = b;
    }

    public void death(final Farm farm) {
        this.isDead(true);
        farm.farmingList.rawFarm().addAll(this.harvest());
        farm.farmingList.rawCattle().remove(this);
    }

    @Override
    public int hashCode() {
        LOGGER.debug("[MyHasCode activated]");
        return Objects.hash(name, this.getClass());
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if(this.defaultCost() == ((RawCattle) object).defaultCost() && this.age() == ((RawCattle) object).age())
            return this.name().equals(((RawCattle) object).name()) && this.cattleWeight() == ((RawCattle) object).cattleWeight();
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

