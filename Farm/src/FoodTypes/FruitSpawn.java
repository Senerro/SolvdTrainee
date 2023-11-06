package FoodTypes;

import AbstractEntities.Food;

import java.io.Serializable;
import java.util.Objects;

public abstract class FruitSpawn extends Food implements Serializable
{
    private int cropYield;

    public int CropYield() {
        return cropYield;
    }
    public void CropYield(final int cropYield)
    {
        this.cropYield = cropYield;
    }

    public void GetNewFruit()
    {
        System.out.println("I give fruit of myself because I am a fruit");
    }
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

        if(this.currentCost == ((FruitSpawn) object).currentCost && this.defaultCost == ((FruitSpawn) object).defaultCost)
            if (this.name == ((FruitSpawn) object).name)
                return true;

        return false;
    }
    @Override
    public String toString() {
        return "Cattle{" + "name='" + Name()  + '\'' + ", cropYield  is" + CropYield() + '}';
    }
}
