package AbstractEntities;

import java.io.Serializable;
import java.util.Objects;

public abstract class Food extends Farming implements Serializable
{
    public double seedingArea;
    public double SeedingArea()
    {
        return this.seedingArea;
    }
    @Override
    public int hashCode()
    {
        System.out.println("[MyHasCode activated]");
        return Objects.hash( name, sort);
    }
    @Override
    public boolean equals(final Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        if(this.Sort().equals(((Food) object).Sort()))
            if (this.DefaultCost() == ((Food) object).DefaultCost() && this.SeedingArea() == ((Food) object).SeedingArea())
                return this.name.equals(((Food) object).name);

        return false;
    }
    @Override
    public String toString() {
        return "Spawner{" + "name='" + Name() + '\'' + ", sort='" + Sort() + '\'' + ", SeedingArea=" + SeedingArea() +'}';
    }
    protected String sort;
    public Food()
    {
        Sort("unknown");
    }
    public String Sort()
    {
        return sort;
    }

    public void Sort(final String sort)
    {
        this.sort = sort;
        System.out.println("Product " + this.getClass() + " get a sort " + this.sort);
    }

}
