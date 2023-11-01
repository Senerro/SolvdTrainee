package AbstractEntities;

import java.io.Serializable;

public abstract class Food extends Farming implements Serializable
{
    public double SeedingArea;
    protected String sort;
    public Food()
    {
        SetSort("unknown");
    }
    public Food(String sort)
    {
        SetSort(sort);
    }
    public String GetSort()
    {
        return sort;
    }

    public void SetSort(String sort)
    {
        this.sort = sort;
        System.out.println("Product " + this.getClass() + " get a sort " + this.sort);
    }

}
