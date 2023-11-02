package Raw;

import java.io.Serializable;

public class Lemon extends AbstractRaw implements Serializable
{
    public Lemon()
    {
        this.SetShelfLife(12);
        this.SetDefaultCost(0.2f);
        this.SetName("Lemon");
        ID =3;
    }
}
