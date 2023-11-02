package Raw;

import java.io.Serializable;

public class Egg extends AbstractRaw implements Serializable
{
    public Egg()
    {
        this.SetShelfLife(25);
        this.SetDefaultCost(0.1f);
        this.SetName("Egg");
        ID =2;
    }
}
