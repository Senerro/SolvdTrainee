package Raw;

import java.io.Serializable;

public class Meat extends AbstractRaw implements Serializable {
    public Meat()
    {
        this.ShelfLife(3);
        this.DefaultCost(5);
        this.Name("Meat");
        ID =4;
    }
}
