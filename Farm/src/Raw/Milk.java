package Raw;

import java.io.Serializable;

public class Milk extends AbstractRaw implements Serializable
{
    public Milk()
    {
        this.ShelfLife(3);
        this.DefaultCost(1.1f);
        this.Name("Milk");
        ID = 5;
    }
}
