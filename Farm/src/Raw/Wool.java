package Raw;

import java.io.Serializable;

public class Wool extends AbstractRaw implements Serializable
{
    public Wool()
    {
        this.ShelfLife(7*365);
        this.DefaultCost(74.56f);
        this.Name("Wool");
        ID = 6;
    }
}
