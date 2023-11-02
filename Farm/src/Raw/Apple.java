package Raw;

import java.io.Serializable;

public class Apple extends AbstractRaw implements Serializable
{
    public Apple()
    {
        this.SetShelfLife(45);
        this.SetDefaultCost(0.9f/6);
        this.SetName("Apple");
        ID = 1;
    }
}
