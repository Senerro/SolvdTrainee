package Raw;
import Exception.*;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class Lemon extends AbstractRaw implements Serializable
{
    static final Logger LOGGER = Logger.getLogger(Lemon.class);
    public Lemon()
    {
        try{
            this.ShelfLife(25);
        }
        catch (ShelfLifeException ex)
        {
            LOGGER.error(ex.getMessage() +" entered shelflife was "+ ex.EnteredShelfLife());
        }
        this.DefaultCost(0.2f);
        this.Name("Lemon");
        ID =3;
    }
}
