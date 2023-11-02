package Raw;

import java.io.Serializable;

public class Wool extends AbstractRaw implements Serializable
{
    public Wool()
    {
        this.SetShelfLife(7*365);
        this.SetDefaultCost(74.56f);
        this.SetName("Wool");
        ID = 6;
    }
}
