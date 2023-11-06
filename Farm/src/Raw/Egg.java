package Raw;

import java.io.Serializable;

public class Egg extends AbstractRaw implements Serializable
{
    public Egg()
    {
        this.ShelfLife(25);
        this.DefaultCost(0.1f);
        this.Name("Egg");
        ID =2;
    }
}
