package Raw;
import Exception.*;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class Meat extends AbstractRaw implements Serializable
{
    static final Logger LOGGER = Logger.getLogger(Meat.class);
    public Meat()
    {
        try{
            this.ShelfLife(25);
        }
        catch (ShelfLifeException ex)
        {
            LOGGER.error(ex.getMessage() +" entered shelflife was "+ ex.EnteredShelfLife());
        }
        this.DefaultCost(5);
        this.Name("Meat");
        ID =4;
    }
}
