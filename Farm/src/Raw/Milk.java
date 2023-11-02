package Raw;

import java.io.Serializable;

public class Milk extends AbstractRaw implements Serializable
{
    public Milk()
    {
        this.SetShelfLife(3);
        this.SetDefaultCost(1.1f);
        this.SetName("Milk");
        ID = 5;
    }
}
