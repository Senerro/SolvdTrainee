package Raw;

import java.io.Serializable;

public class Lemon extends AbstractRaw implements Serializable
{
    public Lemon()
    {
        this.ShelfLife(12);
        this.DefaultCost(0.2f);
        this.Name("Lemon");
        ID =3;
    }
}
