package Raw;
import Exception.*;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class Wool extends AbstractRaw implements Serializable
{
    static final Logger LOGGER = Logger.getLogger(Wool.class);
    public Wool()
    {
        try{
            this.ShelfLife(7*365);
        }
        catch (ShelfLifeException ex)
        {
            LOGGER.error(ex.getMessage() +" entered shelflife was "+ ex.EnteredShelfLife());
        }
        this.DefaultCost(74.56f);
        this.Name("Wool");
        ID = 6;
    }
}
