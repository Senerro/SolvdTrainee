package AbstractEntities;

import java.io.Serializable;
import java.util.Objects;

public abstract class Food extends Farming implements Serializable
{
    public double SeedingArea;
    @Override
    public int hashCode()
    {
        System.out.println("[MyHasCode activated]");
        return Objects.hash( name, sort);
    }
    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        if(this.sort == ((Food) object).sort && this.currentCost == ((Food) object).currentCost)
            if (this.defaultCost == ((Food) object).defaultCost && this.SeedingArea == ((Food) object).SeedingArea )
                if (this.name == ((Food) object).name)
                    return true;

        return false;
    }
    @Override
    public String toString() {
        return "Spawner{" + "name='" + name + '\'' + ", sort='" + sort + '\'' + ", SeedingArea=" + SeedingArea +'}';
    }

    protected String sort;
    public Food()
    {
        Sort("unknown");
    }
    public Food(String sort)
    {
        Sort(sort);
    }
    public String Sort()
    {
        return sort;
    }

    public void Sort(String sort)
    {
        this.sort = sort;
        System.out.println("Product " + this.getClass() + " get a sort " + this.sort);
    }

}
