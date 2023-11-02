package Raw;

import java.io.Serializable;

public class Meat extends AbstractRaw implements Serializable {
    public Meat()
    {
        this.SetShelfLife(3);
        this.SetDefaultCost(5);
        this.SetName("Meat");
        ID =4;
    }
}
