package Raw;

import java.io.Serializable;

public class Apple extends AbstractRaw implements Serializable
{
    public Apple()
    {
        this.ShelfLife(45);
        this.DefaultCost(0.9f/6);
        this.Name("Apple");
        ID = 1;
    }
}
